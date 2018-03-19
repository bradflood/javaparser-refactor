package com.keyholesoftware.refactor.parser.model.ejb2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class Session  {
    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getEjbClass() {
        return ejbClass;
    }

    public void setEjbClass(String ejbClass) {
        this.ejbClass = ejbClass;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public EjbLocalRef getEjbLocalRef() {
        return ejbLocalRef;
    }

    public void setEjbLocalRef(EjbLocalRef ejbLocalRef) {
        this.ejbLocalRef = ejbLocalRef;
    }

    public String getEjbName() {
        return ejbName;
    }

    public String getHome() {
        return home;
    }

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
