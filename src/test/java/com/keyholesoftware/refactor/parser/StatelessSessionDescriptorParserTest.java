package com.keyholesoftware.refactor.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.keyholesoftware.refactor.parser.model.EjbJar;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class StatelessSessionDescriptorParserTest {

    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException {
        Path file = Paths.get("src/test/resources/xml_deployment_descriptors/ejb2-stateless-session.xml");
        
        ObjectMapper objectMapper = new XmlMapper();
        EjbJar descriptor = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes(file), StandardCharsets.UTF_8),
                EjbJar.class);
        
        assertThat(descriptor.getDisplayName(),equalTo("EJBModule_EJB2_Simple"));
    }

}
