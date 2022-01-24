package ru.neoflex.accountservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static final String SHORT_DATE_FORMAT = "dd-MM-yyyy";

    public static Date stringDayMonthYearToDate(String date) {
        try {
            return new SimpleDateFormat(SHORT_DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}