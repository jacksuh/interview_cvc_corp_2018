package com.cvc.challenge.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static int diffBetweenDates(Date date1, Date date2) {
        long diff;
        if (date1.after(date2)) {
            diff = date1.getTime() - date2.getTime();
        } else {
            diff = date2.getTime() - date1.getTime();
        }

        return Math.toIntExact(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

    }
}