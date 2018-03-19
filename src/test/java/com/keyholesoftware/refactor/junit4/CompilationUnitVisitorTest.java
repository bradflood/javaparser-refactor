package com.keyholesoftware.refactor.junit4;

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

public class CompilationUnitVisitorTest {

	private static final Path root = Paths.get("src/test/resources/java_source_code");
	private Function<CompilationUnit, String> printer = new PrettyPrinter()::print;
	

	@Test
	public void shouldModifyImports() {
		SourceRoot sourceRoot = new SourceRoot(root);
        CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");
        
        cu.accept(new CompilationUnitVisitor(), null) ;
        
        final String code = printer.apply(cu);
        assertThat(code, not(containsString("import junit.framework.TestCase;")));
        assertThat(code, containsString("import org.junit.After;"));
        assertThat(code, containsString("import org.junit.Before;"));
        assertThat(code, containsString("import org.junit.Test;"));
	}
}
