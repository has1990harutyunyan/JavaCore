package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private static Calendar calendar = Calendar.getInstance();


    public static String dateToString(Date date) {
        if (date == null) {
            return null;
        }
        return SDF.format(date);

    }

    public static Date stringToDate(String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        try {
            return SDF.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getDayOfMonth(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getTimeOfDay(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static Calendar dateToCalendar(Date date) {
        calendar.setTime(date);
        return calendar;

    }



}

