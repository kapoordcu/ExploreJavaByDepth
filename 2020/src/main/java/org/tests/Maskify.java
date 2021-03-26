package org.tests;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class Maskify {

    public static String maskify(String creditCardNumber) {
        Pattern digitRegex = Pattern.compile("\\d");
        StringBuilder maskedValue = new StringBuilder();
        if(creditCardNumber == null
                || creditCardNumber.length()==0
                || creditCardNumber.length()<6) {
            return creditCardNumber;
        }
        maskedValue.append(creditCardNumber, 0, 1);
        maskedValue.append(creditCardNumber.substring(1, creditCardNumber.length()-4).replaceAll(digitRegex.pattern(), "#"));
        maskedValue.append(creditCardNumber.substring(creditCardNumber.length()-4));
        return maskedValue.toString();
    }

    @Test
    public void set1() {
        String Array = "4556364607935616";
        Maskify maskify = new Maskify();
        String masked = maskify.maskify(Array);
        assertTrue(masked.equals("4###########5616"));
    }

    @Test
    public void set2() {
        String Array = "4556-3646-0793-5616"	;
        Maskify maskify = new Maskify();
        String masked = maskify.maskify(Array);
        assertTrue(masked.equals("4###-####-####-5616"));
    }


    @Test
    public void set3() {
        String Array = "64607935616";
        Maskify maskify = new Maskify();
        String masked = maskify.maskify(Array);
        assertTrue(masked.equals("6######5616"));
    }

    @Test
    public void set4() {
        String Array = "12345";
        Maskify maskify = new Maskify();
        String masked = maskify.maskify(Array);
        assertTrue(masked.equals("12345"));
    }

    @Test
    public void set5() {
        String Array = "123456";
        Maskify maskify = new Maskify();
        String masked = maskify.maskify(Array);
        assertTrue(masked.equals("1#3456"));
    }
}
