import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {


    public static void main(String[] args) {

        String context = "《奇迹·笨小孩笨小孩笨小孩笨小孩》专项";
        String context1 = "《奇迹·笨小孩笨小孩笨小孩笨小孩》专项";


        /*int lastIndexOf = context.lastIndexOf("xx");

        int cropIndex;
        if (lastIndexOf < 0) {
            cropIndex = context.length();
        } else {
            cropIndex = lastIndexOf;
        }

        String substring = context.substring(0, cropIndex);
        String substring1 = context.substring(0, 0);

        System.out.println(
                substring
        );

        System.out.println(substring1);

        if (context != null && context.length() >0) {

            if (context1.equals(context)){
                System.out.println("相等");
                return;
            }
        }

        System.out.println("测试");*/


        List<String> lsit = new ArrayList<>();
        lsit.add("test");
        lsit =  new ArrayList<>();
        lsit.add("test");

        System.out.println(lsit +" --- "+lsit.size());

        TestModel st = (TestModel)null;
        System.out.println("st "+st);



        List<String> lsit2 = new ArrayList<>();
        for (String str : lsit2) {
            System.out.println("str "+str);
        }

       /*  List<String> lsit3 = null;
        for (String str : lsit3) {
            System.out.println("str11 "+str);
        }*/


        Map<String,String> map  = new HashMap<>();
        map.put("1111","11111");
        map.put("2222","22222");
        map.put("3333","33333");
        map.put("4444","44444");


        map.remove("1111");


        String s = map.get("1111");
        System.out.println("--------  "+s);


    }
}
