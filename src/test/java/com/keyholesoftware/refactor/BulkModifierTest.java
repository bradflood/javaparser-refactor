package com.keyholesoftware.refactor;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.SourceRoot;
import com.keyholesoftware.refactor.junit4.ClassDeclarationVisitor;
import com.keyholesoftware.refactor.junit4.CompilationUnitVisitor;
import com.keyholesoftware.refactor.junit4.MethodDeclarationVisitor;

public class BulkModifierTest {

	@Ignore("ill defined test")
	@Test
	public void noop_doesnt_blow_up() throws Exception {
		SourceRoot sourceRoot= new SourceRoot(Paths.get("src/test/resources/java_source_code/empty"));
		List<GenericVisitor<Visitable, Void>> visitors = Collections.EMPTY_LIST;
		
		BulkModifier modifier = new BulkModifier(sourceRoot, visitors);
		boolean result = modifier.modify() ;
		
		assertTrue(result);
	}
	
	@Test
	public void junit_visitors_modify_junit3_to_junit4() throws Exception {
		SourceRoot sourceRoot= new SourceRoot(Paths.get("src/test/resources/java_source_code/junit"));
		List<GenericVisitor<Visitable, Void>> junitVisitors = new ArrayList<>();
		
		junitVisitors.add(new CompilationUnitVisitor());	
		junitVisitors.add(new ClassDeclarationVisitor());	
		junitVisitors.add(new MethodDeclarationVisitor());
		
		BulkModifier modifier = new BulkModifier(sourceRoot, junitVisitors);
		
		boolean result = modifier.modify() ;
		sourceRoot.saveAll(Paths.get("target/output/junit"));
		assertTrue(result);
	}
}
