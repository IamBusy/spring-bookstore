package com.william.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by william on 17/04/2017.
 */
public class DateHelper {
    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:ii:ss");
        return dateFormat.format(date);
    }
}
