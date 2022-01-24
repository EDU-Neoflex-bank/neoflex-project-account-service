package ru.neoflex.accountservice.utils;

import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDateGenerator {
    public static Date getRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int startYear = 2000;
        int endYear = 2022;

        int year = startYear + (int) Math.round(Math.random() * (endYear - startYear));
        int dayOfYear = 1 + (int) Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.YEAR, year);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
    }
}
