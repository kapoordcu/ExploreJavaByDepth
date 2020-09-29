package explore.topics._regex;

import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class UsernamePattern {
    public static boolean validate(String username) {
        String regex = "^[a-zA-Z]([.]?[a-zA-Z0-9]+)*$";
        Pattern p = Pattern.compile(regex);
        if(username==null) {
            return false;
        }
        Matcher m = p.matcher(username);
        return m.matches() && username.length()>=6 && username.length()<=20;
    }

    @Test
    public void testOn1a() {
        boolean isValid = validate("Robert.Domek");
        assertTrue(isValid);
    }

    @Test
    public void testOn2a() {
        boolean isValid = validate("Robert Domek");
        assertFalse(isValid);
    }
}
