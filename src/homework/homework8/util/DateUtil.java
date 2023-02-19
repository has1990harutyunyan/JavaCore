package homework.homework8.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public static String DateToString(Date date) {
        if (date == null) {
            return null;
        }
        return SDF.format(date);
    }

    public static Date StringToDate(String dateStr) throws ParseException {
        if (dateStr == null) {
            return null;
        }
        return SDF.parse(dateStr);
    }

}
