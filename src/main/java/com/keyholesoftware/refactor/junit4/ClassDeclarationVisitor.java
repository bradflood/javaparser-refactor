package com.keyholesoftware.refactor.junit4;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import com.keyholesoftware.refactor.BaseClassDeclarationVisitor;

public class ClassDeclarationVisitor extends BaseClassDeclarationVisitor {

	@Override
    public ClassOrInterfaceDeclaration visit(final ClassOrInterfaceDeclaration coid, Void arg) { 
    	super.visit(coid, arg);
    	removeSuperClass(coid, "TestCase");
    	
    	return coid ;
    }
	

}
