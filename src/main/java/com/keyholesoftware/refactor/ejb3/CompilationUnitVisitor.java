package com.keyholesoftware.refactor.ejb3;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;

public class CompilationUnitVisitor extends ModifierVisitor<Void> {

//	private static final ImportDeclaration JUNIT3_IMPORT_DECLARATION_TEST_CASE = new ImportDeclaration(JavaParser.parseName("junit.framework.TestCase"), false, false);
	
	@Override
    public CompilationUnit visit(final CompilationUnit coid, Void arg) { 
    	super.visit(coid, arg);
    	
    	// FIXME: identify import changes
    	
//    	coid.getImports().remove(JUNIT3_IMPORT_DECLARATION_TEST_CASE);
    	return coid ;
    }	
	
}
