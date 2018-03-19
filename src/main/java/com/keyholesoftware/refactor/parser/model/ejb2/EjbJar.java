package com.keyholesoftware.refactor.parser.model.ejb2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Set;

public final class EjbJar {
    @JacksonXmlProperty(localName = "display-name")
    private String displayName;
    @JacksonXmlProperty(localName = "enterprise-beans")
    private Set<Session> sessionBeans;

    public EjbJar() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public Set<Session> getSessionBeans() {
        return sessionBeans;
    }

    @Override
    public String toString() {
        return "EjbJar{" + "displayName='" + displayName + '\'' + ", enterpriseBeans=" + sessionBeans + '}';
    }

}
