package com.keyholesoftware.refactor.parser.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class EnterpriseBean {
    @JacksonXmlProperty(localName = "ejb-name")
    private String ejbName;
        
}
