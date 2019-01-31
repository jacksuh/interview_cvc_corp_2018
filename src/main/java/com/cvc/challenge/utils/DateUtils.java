package com.cvc.challenge.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static int diffBetweenDates(Date date1, Date date2) {
        long diffInMillies;
        if (date2.after(date1)) {
            diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        } else {
            diffInMillies = Math.abs(date1.getTime() - date2.getTime());
        }
        Long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff.intValue();
    }
}