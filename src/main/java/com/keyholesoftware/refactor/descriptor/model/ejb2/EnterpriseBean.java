package com.keyholesoftware.refactor.descriptor.model.ejb2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class EnterpriseBean {
    @JacksonXmlProperty(localName = "ejb-name")
    private String ejbName;
        
}
