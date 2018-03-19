package com.keyholesoftware.refactor.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.keyholesoftware.refactor.parser.model.EjbLocalRefBuilder;
import com.keyholesoftware.refactor.parser.model.SessionBuilder;
import com.keyholesoftware.refactor.parser.model.ejb2.EjbJar;
import com.keyholesoftware.refactor.parser.model.ejb2.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class StatelessSessionDescriptorParserTest {

    private Session bean1;
    private Session bean2;

    @Before
    public void createExpected() {
        bean1 = new SessionBuilder().ejbName("TrackSessionFacade").home("is346.TrackSessionFacadeHome")
                .remote("is346.TrackSessionFacade").ejbClass("is346.TrackSessionFacadeBean").sessionType("Stateless").transactionType("Container")
                .ejbLocalRef(new EjbLocalRefBuilder().ejbRefName("ejb/track").ejbRefType("Entity")
                        .localHome("is346.TrackHome").local("is346.Track").ejbLink("Track").build())
                .build();
        bean2 = new SessionBuilder().ejbName("ArtistSessionFacade").home("is346.ArtistSessionFacadeHome")
                .remote("is346.ArtistSessionFacade").ejbClass("is346.ArtistSessionFacadeBean").sessionType("Stateless").transactionType("Container")
                .ejbLocalRef(new EjbLocalRefBuilder().ejbRefName("ejb/artist").ejbRefType("Entity")
                        .localHome("is346.ArtistHome").local("is346.Artist").ejbLink("Artist").build())
                .build();       
    }

    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException {
        Path file = Paths.get("src/test/resources/xml_deployment_descriptors/ejb2-stateless-session.xml");
        
        ObjectMapper objectMapper = new XmlMapper();
        EjbJar descriptor = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes(file), StandardCharsets.UTF_8),
                EjbJar.class);
        
        assertThat(descriptor.getDisplayName(),equalTo("EJBModule_EJB2_Simple"));
        assertThat(descriptor.getSessionBeans(), hasSize(2));
    }

}
