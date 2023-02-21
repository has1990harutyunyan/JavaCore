package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");


    public static String dateToString(Date date) {
        if (date == null) {
            return null;
        }
        return SDF.format(date);

    }

    public static Date stringToDate(String string) {
        if (string == null) {
            return null;
        }
        try {
            return SDF.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}

