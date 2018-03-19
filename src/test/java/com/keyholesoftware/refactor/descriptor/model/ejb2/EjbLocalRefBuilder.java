package com.keyholesoftware.refactor.descriptor.model.ejb2;

import com.keyholesoftware.refactor.descriptor.model.ejb2.EjbLocalRef;

public class EjbLocalRefBuilder {

    private String ejbRefName;
    private String ejbRefType;
    private String localHome;
    private String local;
    private String ejbLink;

    public EjbLocalRefBuilder() {
    }

    public EjbLocalRefBuilder ejbRefName(String ejbRefName) {
        this.ejbRefName = ejbRefName;
        return this;
    }

    public EjbLocalRefBuilder ejbRefType(String ejbRefType) {
        this.ejbRefType = ejbRefType;
        return this;
    }

    public EjbLocalRefBuilder localHome(String localHome) {
        this.localHome = localHome;
        return this;
    }
    
    public EjbLocalRefBuilder local(String local) {
        this.local = local;
        return this;
    }    
    
    public EjbLocalRefBuilder ejbLink(String ejbLink) {
        this.ejbLink = ejbLink;
        return this;
    }      
    
    public EjbLocalRef build() {
        EjbLocalRef ejbLocalRef = new EjbLocalRef();
        ejbLocalRef.setEjbRefName(ejbRefName);
        ejbLocalRef.setEjbRefType(ejbRefType);
        ejbLocalRef.setLocalHome(localHome);
        ejbLocalRef.setLocal(local);
        ejbLocalRef.setEjbLink(ejbLink);
        return ejbLocalRef;
    }
}
