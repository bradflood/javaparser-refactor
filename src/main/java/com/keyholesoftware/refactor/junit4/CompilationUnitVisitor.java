package com.keyholesoftware.refactor.junit4;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;

public class CompilationUnitVisitor extends ModifierVisitor<Void> {

	private static final ImportDeclaration JUNIT3_IMPORT_DECLARATION_TEST_CASE = new ImportDeclaration(JavaParser.parseName("junit.framework.TestCase"), false, false);
	private static final ImportDeclaration JUNIT4_IMPORT_DECLARATION_AFTER = new ImportDeclaration(JavaParser.parseName("org.junit.After"), false, false);
	private static final ImportDeclaration JUNIT4_IMPORT_DECLARATION_BEFORE = new ImportDeclaration(JavaParser.parseName("org.junit.Before"), false, false);
	private static final ImportDeclaration JUNIT4_IMPORT_DECLARATION_TEST = new ImportDeclaration(JavaParser.parseName("org.junit.Test"), false, false);
	
	@Override
    public CompilationUnit visit(final CompilationUnit coid, Void arg) { 
    	super.visit(coid, arg);
    	
    	coid.getImports().remove(JUNIT3_IMPORT_DECLARATION_TEST_CASE);
    	coid.getImports().add(JUNIT4_IMPORT_DECLARATION_AFTER);
    	coid.getImports().add(JUNIT4_IMPORT_DECLARATION_BEFORE);
    	coid.getImports().add(JUNIT4_IMPORT_DECLARATION_TEST);
    	return coid ;
    }	
	
}
