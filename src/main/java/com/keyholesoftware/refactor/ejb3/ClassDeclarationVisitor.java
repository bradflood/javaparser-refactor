package com.keyholesoftware.refactor.ejb3;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import com.keyholesoftware.refactor.BaseClassDeclarationVisitor;

public class ClassDeclarationVisitor extends BaseClassDeclarationVisitor {

	private static final String JAVAX_EJB_SESSION_BEAN = "javax.ejb.SessionBean";


	@Override
    public ClassOrInterfaceDeclaration visit(final ClassOrInterfaceDeclaration coid, Void arg) { 
    	super.visit(coid, arg);
    	
    	if (isEjb21StatelessSessionBean(coid)) {
    		removeImplementationClass(coid, JAVAX_EJB_SESSION_BEAN);
    	}
    	
    	return coid ;
    }
	
	
	private boolean isEjb21StatelessSessionBean(final ClassOrInterfaceDeclaration coid) {
		ClassOrInterfaceType javaxEjbSessionBean = JavaParser.parseClassOrInterfaceType(JAVAX_EJB_SESSION_BEAN);
		return coid.getImplementedTypes().contains(javaxEjbSessionBean);
	}

}
