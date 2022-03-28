import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
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


    }

}
