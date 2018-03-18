package com.keyholesoftware.refactor.parser.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class EjbLocalRef  {
    @JacksonXmlProperty(localName = "ejb-ref-name")
    private String ejbRefName;    
    @JacksonXmlProperty(localName = "ejb-ref-type")
    private String ejbRefType;
    @JacksonXmlProperty(localName = "local-home")
    private String localHome;
    @JacksonXmlProperty(localName = "local")
    private String local;
    @JacksonXmlProperty(localName = "ejb-link")
    private String ejbLink;

    
    public void setEjbRefName(String ejbRefName) {
        this.ejbRefName = ejbRefName;
    }


    public void setEjbRefType(String ejbRefType) {
        this.ejbRefType = ejbRefType;
    }


    public void setLocalHome(String localHome) {
        this.localHome = localHome;
    }


    public void setLocal(String local) {
        this.local = local;
    }


    public void setEjbLink(String ejbLink) {
        this.ejbLink = ejbLink;
    }


    public EjbLocalRef() {
        
    }


    
}
