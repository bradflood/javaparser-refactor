package com.keyholesoftware.refactor.ejb3;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import org.junit.Test;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.utils.SourceRoot;

public class ClassDeclarationVisitorTest {

	private static final Path root = Paths.get("src/test/resources/java_source_code");
	private Function<CompilationUnit, String> printer = new PrettyPrinter()::print;
	

	@Test
	public void shouldRemoveImplementationClass() {
		SourceRoot sourceRoot = new SourceRoot(root);
        CompilationUnit cu = sourceRoot.parse("ejb", "AccountBean21.java");
        
        cu.accept(new ClassDeclarationVisitor(), null) ;
        
        final String code = printer.apply(cu);       
        assertThat(code, not(containsString("implements")));
	}


}
