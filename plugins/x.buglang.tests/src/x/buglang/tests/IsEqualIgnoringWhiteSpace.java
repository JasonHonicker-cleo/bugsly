package x.buglang.tests;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Tests if a string is equal to another string, ignoring any changes in whitespace.
 */
public class IsEqualIgnoringWhiteSpace extends TypeSafeMatcher<CharSequence> {

    private final CharSequence charSequence;

    public IsEqualIgnoringWhiteSpace(CharSequence charSequence) {
        if (charSequence == null) {
            throw new IllegalArgumentException("Non-null value required by IsEqualIgnoringCase()");
        }
        this.charSequence = charSequence;
    }

    public boolean matchesSafely(CharSequence charSequence) {
        return strip(this.charSequence).equals(strip(charSequence));
    }
    
    public boolean matchesSafelyIgnoreCase(CharSequence charSequence) {
    	return strip(this.charSequence).equalsIgnoreCase(strip(charSequence));
    }
    
    public void describeTo(Description description) {
        description.appendText("eqIgnoringWhiteSpace(")
                .appendValue(this.charSequence)
                .appendText(")");
    }

    public String strip(CharSequence charSequence) {
        StringBuilder result = new StringBuilder();
        boolean lastWasSpace = true;
        for (int i = 0; i < charSequence.length(); i++) {
            char c = charSequence.charAt(i);
            if (Character.isWhitespace(c) || c == '\n' || c == '\r' || c == '\t') {
                if (!lastWasSpace) {
                    result.append(' ');
                }
                lastWasSpace = true;
            } else {
                result.append(c);
                lastWasSpace = false;
            }
        }
        return result.toString().trim();
    }

    @Factory
    public static Matcher<CharSequence> equalIgnoringSpaceEnterCase(CharSequence charSequence) {
        return new IsEqualIgnoringWhiteSpace(charSequence);
    }

}
