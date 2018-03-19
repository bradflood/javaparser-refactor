package com.keyholesoftware.refactor.junit4;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.visitor.ModifierVisitor;

public class MethodDeclarationVisitor extends ModifierVisitor<Void> {

	@Override
	public MethodDeclaration visit(final MethodDeclaration md, Void arg) {
		super.visit(md, arg);

		annotateTestMethod(md);
		modifySetUp(md) ;
		modifyTearDown(md) ;
		return md;
	}

	private MethodDeclaration annotateTestMethod(final MethodDeclaration md) {
		final AnnotationExpr annotationTest = new MarkerAnnotationExpr(JavaParser.parseName("Test"));

		if (md.getNameAsString().startsWith("test") && !md.getAnnotations().contains(annotationTest)) {
			md.addAnnotation(annotationTest);
		}
		return md;
	}

	private MethodDeclaration modifySetUp(final MethodDeclaration md) {
		final AnnotationExpr annotationOverride = new MarkerAnnotationExpr(JavaParser.parseName("Override"));
		final AnnotationExpr annotationBefore = new MarkerAnnotationExpr(JavaParser.parseName("Before"));

		if (md.getNameAsString().startsWith("setUp")) {
			md.addAnnotation(annotationBefore);
			md.getAnnotations().remove(annotationOverride);
			modifyVisibilityToPublic(md);
		}
		
		return md;
	}
	
	private MethodDeclaration modifyTearDown(final MethodDeclaration md) {
		final AnnotationExpr annotationOverride = new MarkerAnnotationExpr(JavaParser.parseName("Override"));
		final AnnotationExpr annotationAfter = new MarkerAnnotationExpr(JavaParser.parseName("After"));

		if (md.getNameAsString().startsWith("tearDown")) {
			md.addAnnotation(annotationAfter);
			md.getAnnotations().remove(annotationOverride);
			modifyVisibilityToPublic(md);
		}
		
		return md;
	}

	private void modifyVisibilityToPublic(final MethodDeclaration md) {
		/*
		 * note: need to test for Default visibility; however when visibility is DEFAULT, getModifiers().contains(com.github.javaparser.ast.Modifier.DEFAULT) does not return true
		 * FIXME: this will not trigger if Default visibility but another type of modifier (such as ABSTRACT, or STATIC) is set
		 */
		if (md.getModifiers().contains(com.github.javaparser.ast.Modifier.PROTECTED) || md.getModifiers().contains(com.github.javaparser.ast.Modifier.PRIVATE) || md.getModifiers().isEmpty()) {
			md.setModifier(com.github.javaparser.ast.Modifier.PROTECTED, false);
			md.setModifier(com.github.javaparser.ast.Modifier.PRIVATE, false);
			md.setModifier(com.github.javaparser.ast.Modifier.DEFAULT, false);
			md.setModifier(com.github.javaparser.ast.Modifier.PUBLIC, true);
		}
	}	
}