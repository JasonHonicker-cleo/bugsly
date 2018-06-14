package x.buglang.scoping;

import org.eclipse.xtext.xbase.scoping.NestedTypeAwareImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class BugslyImportSectionNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {
	
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		Builder<ImportNormalizer> builder = ImmutableList.<ImportNormalizer>builder();
		
		builder.add(createImportNormalizer(QualifiedName.create("x","buglang","lib"), true, false))
		.add(createImportNormalizer(QualifiedName.create("x","buglang","lib","other"), true, false));

		ImmutableList<ImportNormalizer> results = builder.build();
		return results;
	}
	
	protected ImportNormalizer createImportNormalizer(QualifiedName importedNamespace, boolean wildcard, boolean ignoreCase) {
		return new NestedTypeAwareImportNormalizer(importedNamespace, wildcard, ignoreCase);
	}
}
