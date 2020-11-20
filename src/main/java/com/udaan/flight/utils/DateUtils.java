package com.udaan.flight.utils;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static int getDayOftheWeek(Date date){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.DAY_OF_WEEK);
    }
    public static int getDayOftheWeek(Timestamp timestamp){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(timestamp);
        System.out.println(calendar.get(Calendar.DATE));
        return  calendar.get(Calendar.DAY_OF_WEEK);
    }
    public static  Date getDate(Timestamp timestamp){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.clear( Calendar.HOUR_OF_DAY );
        calendar.clear( Calendar.MINUTE );
        calendar.clear( Calendar.SECOND );
        calendar.clear( Calendar.MILLISECOND );
        Date date=calendar.getTime();
        return date;
    }
}
