package com.keyholesoftware.refactor.parser.model;

public class SessionBuilder {

    private String ejbName;
    private String home;
    private String remote;
    private String ejbClass;
    private String sessionType;
    private String transactionType;
    private EjbLocalRef ejbLocalRef;

    public SessionBuilder() {
    }

    public SessionBuilder ejbName(String ejbName) {
        this.ejbName = ejbName;
        return this;
    }

    public SessionBuilder home(String home) {
        this.home = home;
        return this;
    }

    public SessionBuilder remote(String remote) {
        this.remote = remote;
        return this;
    }
    
    public SessionBuilder ejbClass(String ejbClass) {
        this.ejbClass = ejbClass;
        return this;
    }  
    public SessionBuilder sessionType(String sessionType) {
        this.sessionType = sessionType;
        return this;
    }     
    public SessionBuilder transactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }  
    public SessionBuilder ejbLocalRef(EjbLocalRef ejbLocalRef) {
        this.ejbLocalRef = ejbLocalRef;
        return this;
    }
    
    public Session build() {
        Session session = new Session();
        session.setEjbName(ejbName);
        session.setHome(home);
        session.setRemote(remote);
        session.setEjbClass(ejbClass);
        session.setSessionType(sessionType);
        session.setTransactionType(transactionType);
        session.setEjbLocalRef(ejbLocalRef);
        return session;
    }
}
