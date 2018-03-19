package com.keyholesoftware.refactor;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.ModifierVisitor;

public class BaseClassDeclarationVisitor extends ModifierVisitor<Void> {

	// FIXME: allow for cardinality > 1
	protected ClassOrInterfaceDeclaration removeSuperClass(ClassOrInterfaceDeclaration coid, String superClassName) {
		NodeList<ClassOrInterfaceType> extendedTypes = coid.getExtendedTypes();
		if (extendedTypes.size() != 1 ) {
			return coid ;
		}
		if (!superClassName.equals(extendedTypes.get(0).getNameAsString())) {
			return coid ;
		}
		extendedTypes.remove(0);
		
		return coid ;
	}

	// FIXME: allow for cardinality > 1
	protected ClassOrInterfaceDeclaration removeImplementationClass(ClassOrInterfaceDeclaration coid, String implementationClassName) {
		NodeList<ClassOrInterfaceType> implementedTypes = coid.getImplementedTypes();
		if (implementedTypes.size() != 1 ) {
			return coid ;
		}
		if (!implementationClassName.equals(implementedTypes.get(0).asString())) {
			return coid ;
		}
		implementedTypes.remove(0);
		
		return coid ;
	}

}
