package kotlin.chapter08.javareflections;

import net.println.kotlin.chapter08.javareflections.JavaReflectionsKt;
import net.println.kotlin.chapter08.javareflections.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhangkun
 * @time 2020/9/29 8:14 上午
 */
public class JavaTestHello {

    public static final int MATRIX_SAVE_FLAG = 0x01;
    public static final int CLIP_SAVE_FLAG = 0x02;
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    private static List<String> list;
    private static int viewNum;

    public static void main(String[] args) {
        float a = 1.0f;
        float b = 0.0f;
        System.out.println( a / b);

        float mm = 90 * (a / b);
        System.out.println(mm);

        try {
            JavaReflectionsKt.class.getDeclaredMethod("sayHello", Person.class)
                    .invoke(null,new Person("zhang", 12));
            // invoke 调用静态方法，第一个参数需要传null，函数本身，第二个参数是sayHello的参数,
            // 如果是非静态则需要传入实例
        } catch (Exception e) {
            e.printStackTrace();
        }

        int saveFlags = MATRIX_SAVE_FLAG
                | CLIP_SAVE_FLAG
                | HAS_ALPHA_LAYER_SAVE_FLAG
                | FULL_COLOR_LAYER_SAVE_FLAG
                | CLIP_TO_LAYER_SAVE_FLAG;
        System.out.println(" saveFlags "+saveFlags);


        list = new ArrayList<>();

        time("0001");
        time("0002");
        time("0003");
        time("0004");
        time("0005");

    }

    private static void time(String str){
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                list.add(str);
                sum(++viewNum);
            }
        }, 600);// 这里百毫秒
    }

    private static void sum(int i){

        if (i == 5) {
            System.out.println(list.toString());
        }
    }
}
