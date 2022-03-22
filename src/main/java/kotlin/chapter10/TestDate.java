package kotlin.chapter10;

import net.println.kotlin.chapter04.D;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDate {

    public static final long ZERO_TIMESTAMP = 1044028800000L;

    private static final DateFormat FMT_DATE_NO_YEAR = new SimpleDateFormat("MM-dd", Locale.US);
    private static final DateFormat FMT_DATE = new SimpleDateFormat("yy-MM-dd", Locale.US);
    private static final DateFormat FMT_TIME = new SimpleDateFormat("HH:mm", Locale.US);

    public static void main(String[] args) {


        int a = 2147483645;

        System.out.println(Integer.MAX_VALUE);


        System.out.println("" + (Integer.MAX_VALUE - a));

        int b = a+10;
        System.out.println(b);

        if (a + 10 > Integer.MAX_VALUE) {
            a = Integer.MAX_VALUE;
        } else {
            a = a + 1;
        }

        System.out.println("----" + a);


        long sss = 123123123132L / 1000;
        System.out.println("ssss " + sss);

        long date1 = System.currentTimeMillis();
        System.out.println("date2 " + date1);
        Date date = new Date(date1);
        String format = format(date);
        System.out.println(format);

    }

    public static String format(Date date) {
        if (date == null || date.getTime() < ZERO_TIMESTAMP)
            return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar now = Calendar.getInstance();
        if (now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && now.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                && now.get(Calendar.DATE) == calendar.get(Calendar.DATE))
            return FMT_TIME.format(date);
        else if (now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))
            return FMT_DATE_NO_YEAR.format(date);
        else
            return FMT_DATE.format(date);
    }
}
