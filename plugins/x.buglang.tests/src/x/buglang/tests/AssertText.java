package x.buglang.tests;

import junit.framework.ComparisonFailure;

public class AssertText {

	static public void assertTextInverted(String actual, String expected) {
		assertText(expected,actual);
	}
	
	static public void assertText(String expected, String actual) {
		if(!new IsEqualIgnoringWhiteSpace(expected).matchesSafely(actual)) {
			throw new ComparisonFailure("", expected, actual);
		}
	}
	
	static public void assertText(String message, String expected, String actual) {
		if(!new IsEqualIgnoringWhiteSpace(expected).matchesSafely(actual)) {
			throw new ComparisonFailure(message, expected, actual);
		}
	}

}
