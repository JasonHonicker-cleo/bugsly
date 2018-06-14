/*
 * generated by Xtext 2.12.0
 */
package x.buglang.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import x.buglang.parser.antlr.internal.InternalBugslyParser;
import x.buglang.services.BugslyGrammarAccess;

public class BugslyParser extends AbstractAntlrParser {

	@Inject
	private BugslyGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalBugslyParser createParser(XtextTokenStream stream) {
		return new InternalBugslyParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "File";
	}

	public BugslyGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BugslyGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}