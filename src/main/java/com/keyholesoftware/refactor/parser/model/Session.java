package com.keyholesoftware.refactor.parser.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class Session  {
    @JacksonXmlProperty(localName = "ejb-name")
    private String ejbName;    
    @JacksonXmlProperty(localName = "home")
    private String home;
    @JacksonXmlProperty(localName = "remote")
    private String remote;
    @JacksonXmlProperty(localName = "ejb-class")
    private String ejbClass;
    @JacksonXmlProperty(localName = "session-type")
    private String sessionType;
    @JacksonXmlProperty(localName = "transaction-type")
    private String transactionType;
    @JacksonXmlProperty(localName = "ejb-local-ref")
    private EjbLocalRef ejbLocalRef;

    
    public Session() {
        
    }

    public void setEjbName(String ejbName) {
        this.ejbName = ejbName;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Session [ejbName=" + ejbName + ", home=" + home + ", remote=" + remote + ", ejbClass=" + ejbClass
                + ", sessionType=" + sessionType + ", transactionType=" + transactionType + ", ejbLocalRef="
                + ejbLocalRef + "]";
    }
    
}
