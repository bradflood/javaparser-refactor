package com.keyholesoftware.refactor.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.keyholesoftware.refactor.parser.model.EjbJar;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;

public class EjbDescriptorParser {

    public static void main(String[] args) throws IOException {
        
        Path file = Paths.get("src/test/resources/xml_deployment_descriptors/ejb2-stateless-session.xml");
        
        ObjectMapper objectMapper = new XmlMapper();
        EjbJar descriptor = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes(file), StandardCharsets.UTF_8),
                EjbJar.class);
        System.out.println(descriptor);
    }
    
}
