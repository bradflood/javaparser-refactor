package com.keyholesoftware.refactor.junit4;

import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.utils.SourceRoot;

public class MethodDeclarationVisitorTest {

	private static final Path root = Paths.get("src/test/resources/java_source_code");
	private Function<CompilationUnit, String> printer = new PrettyPrinter()::print;

	@Test
	public void shouldAnnotateTestMethods() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("Test", "public void testIWillFail"), code, true);
	}

	@Test
	public void shouldNotAnnotateNonTestMethods() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("Test", "public void notATest"), code, false);
	}

	@Test
	public void shouldNotAnnotateTestMethodsAlreadyAnnotated() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch("\\@Test\\s*\\@Test\\s*public void testAlreadyHasTestAnnotation", code, false);
	}

	@Test
	public void methodSetupShouldHaveAnnotationBefore() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("Before", "(public|protected) void setUp"), code, true);
	}

	@Test
	public void methodSetupShouldNotHaveAnnotationOverride() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("Override", "(public|protected) void setUp"), code, false);
	}

	@Test
	public void methodSetupShouldHaveVisibilityPublic() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch("public void setUp", code, true);
	}



	@Test
	public void methodTearDownShouldHaveAnnotationAfter() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("After", "(public|) void tearDown"), code, true);
	}
	
	@Test
	public void methodTearDownShouldNotHaveAnnotationOverride() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		assertRegexSearch(createRegexPattern("Override", "(public|) void tearDown"), code, false);
	}	
	
	@Test
	public void methodTearDownShouldHaveVisibilityPublic() {
		SourceRoot sourceRoot = new SourceRoot(root);
		CompilationUnit cu = sourceRoot.parse("junit", "SimpleJunit3.java");

		cu.accept(new MethodDeclarationVisitor(), null);

		final String code = printer.apply(cu);
		
		assertRegexSearch("public void tearDown", code, true);
	}	
	
	private void assertRegexSearch(final String regex, final String code, boolean shouldBeFound) {
		Pattern p = Pattern.compile(regex);
		assertRegexSearch(p, code, shouldBeFound);
	}
	
	private void assertRegexSearch(final Pattern pattern, final String code, boolean shouldBeFound) {
		Matcher matcher = pattern.matcher(code);
		boolean found = matcher.find();
		assertTrue(found == shouldBeFound);
	}	
	
	private Pattern createRegexPattern(String annotation, String methodString) {
		StringBuilder buf = new StringBuilder();
		buf.append("\\@").append(annotation).append("\\s*").append(methodString);

		return Pattern.compile(buf.toString());

	}

}
