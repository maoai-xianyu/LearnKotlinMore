import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teat {

    public static void main(String[] args) {

        float max = Math.max(1, Float.parseFloat("1.5"));

        long time = (long) (max * 60 * 60 * 1000);
        System.out.println("--- time = " + time);


        try {

            int i = 1 / 1;
            //return;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("执行");



        List<String> sss = new ArrayList<>();
        sss.add("zhang");
        sss.add("zhang2");
        sss.add("zhang3");
        sss.add("zhang4");
        sss.add("zhang5");

        sss.removeIf(s -> s.equals("zhang"));

        System.out.println(sss);

        System.out.println("----------");

        List<TestModel> testModels = new ArrayList<>();

        testModels.add(new TestModel("11",1));
        testModels.add(new TestModel("22",2));
        testModels.add(new TestModel("33",3));
        testModels.add(new TestModel("44",4));
        testModels.add(new TestModel("55",5));

        TestModel model = null;
        for (TestModel test: testModels) {
            if (test.id == 2){
                model = test;
            }
        }

        if (model != null) {
            testModels.remove(model);
            System.out.println("----------");
            System.out.println(testModels);

            testModels.add(0,model);
        }

        System.out.println(testModels);


        System.out.println(" --- "+getMinuteSecondFormatDate(6200));
        System.out.println(" --- "+getMonthDayHourMinuteFormatDate(6200));


    }

    private static final ThreadLocal<DateFormat> MINUTE_SECOND_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };


    public static String getMinuteSecondFormatDate(long time) {
        return MINUTE_SECOND_FORMAT.get().format(new Date(time));
    }


    public static final ThreadLocal<DateFormat> MONTH_DAY_HOUR_MINUTE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM-dd HH:mm");
        }
    };

    public static String getMonthDayHourMinuteFormatDate(long time) {
        return MONTH_DAY_HOUR_MINUTE_FORMAT.get().format(new Date(time));
    }

}
