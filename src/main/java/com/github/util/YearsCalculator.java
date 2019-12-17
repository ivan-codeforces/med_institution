package com.github.util;

import java.util.GregorianCalendar;

public final class YearsCalculator {

    private static int calcYears(GregorianCalendar birthDay) {
        GregorianCalendar checkDay= new GregorianCalendar();
        int years = checkDay.get(GregorianCalendar.YEAR) - birthDay.get(GregorianCalendar.YEAR);
        int checkMonth = checkDay.get(GregorianCalendar.MONTH);
        int birthMonth = birthDay.get(GregorianCalendar.MONTH);
        if ( checkMonth < birthMonth ) {
            years --;
        } else  if (checkMonth == birthMonth
                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthDay.get(GregorianCalendar.DAY_OF_MONTH)) {
        }
        return years;
    }
}
