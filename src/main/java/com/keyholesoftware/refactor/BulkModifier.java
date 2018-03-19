package com.keyholesoftware.refactor;

import java.io.IOException;
import java.util.List;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.SourceRoot;
import static com.github.javaparser.utils.Utils.assertNotNull;

public class BulkModifier {
	private final SourceRoot root ;
	private final List<GenericVisitor<Visitable, Void>> visitors ;

	public BulkModifier(SourceRoot root, List<GenericVisitor<Visitable, Void>> visitors) {
		assertNotNull(root);
		assertNotNull(visitors);		
		this.root = root ;
		this.visitors = visitors;
	}
	
	public boolean modify() {
		List<ParseResult<CompilationUnit>> parseResults ; 
		try {
			parseResults = root.tryToParse("");
		} catch (IOException e) {
			e.printStackTrace();
			return false ;
		}
		
		for (ParseResult<CompilationUnit> parseResult : parseResults) {
			if (parseResult.getResult().isPresent()) {
				CompilationUnit cu = parseResult.getResult().get();
				injectVisitors(cu);
			}
		}
		return true ;
	}
	
	private void injectVisitors(CompilationUnit cu) {
		for (GenericVisitor<Visitable, Void> visitor : visitors) {
			cu.accept(visitor, null);
		}
	}
	
}
