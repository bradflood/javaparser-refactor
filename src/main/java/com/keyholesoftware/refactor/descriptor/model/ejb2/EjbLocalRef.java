package com.keyholesoftware.refactor.descriptor.model.ejb2;

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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ejbLink == null) ? 0 : ejbLink.hashCode());
        result = prime * result + ((ejbRefName == null) ? 0 : ejbRefName.hashCode());
        result = prime * result + ((ejbRefType == null) ? 0 : ejbRefType.hashCode());
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((localHome == null) ? 0 : localHome.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EjbLocalRef other = (EjbLocalRef) obj;
        if (ejbLink == null) {
            if (other.ejbLink != null)
                return false;
        } else if (!ejbLink.equals(other.ejbLink))
            return false;
        if (ejbRefName == null) {
            if (other.ejbRefName != null)
                return false;
        } else if (!ejbRefName.equals(other.ejbRefName))
            return false;
        if (ejbRefType == null) {
            if (other.ejbRefType != null)
                return false;
        } else if (!ejbRefType.equals(other.ejbRefType))
            return false;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (localHome == null) {
            if (other.localHome != null)
                return false;
        } else if (!localHome.equals(other.localHome))
            return false;
        return true;
    }


    
}
