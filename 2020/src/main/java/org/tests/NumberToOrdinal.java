package org.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberToOrdinal {



    public static String numberToOrdinal(Integer number) {
        if(number == 0) {
            return "0";
        }
        String ordinalStr = number + "th";
        int lastTwoDigits = number % 100;
        int lastSingleDigit = number % 10;
        if(lastSingleDigit == 1 && lastTwoDigits != 11) {
            ordinalStr =  number + "st";
        } else if(lastSingleDigit == 2 && lastTwoDigits != 12) {
            ordinalStr =  number + "nd";
        } else if(lastSingleDigit == 3 && lastTwoDigits != 13) {
            ordinalStr =  number + "rd";
        }
        return ordinalStr;
    }


    @Test
    public void set1() {
        NumberToOrdinal numberToOrdinal = new NumberToOrdinal();
        String ordinal = numberToOrdinal.numberToOrdinal(1);
        assertTrue(ordinal.equals("1st"));
    }

    @Test
    public void set2() {
        NumberToOrdinal numberToOrdinal = new NumberToOrdinal();
        String ordinal = numberToOrdinal.numberToOrdinal(2);
        assertTrue(ordinal.equals("2nd"));
    }

    @Test
    public void set4() {
        NumberToOrdinal numberToOrdinal = new NumberToOrdinal();
        String ordinal = numberToOrdinal.numberToOrdinal(3);
        assertTrue(ordinal.equals("3rd"));
    }

    @Test
    public void set5() {
        NumberToOrdinal numberToOrdinal = new NumberToOrdinal();
        String ordinal = numberToOrdinal.numberToOrdinal(4);
        assertTrue(ordinal.equals("4th"));
    }

    @Test
    public void set6() {
        NumberToOrdinal numberToOrdinal = new NumberToOrdinal();
        String ordinal = numberToOrdinal.numberToOrdinal(21);
        assertTrue(ordinal.equals("21st"));
    }
}
