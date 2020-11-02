package kotlin.chapter08.javareflections;

import net.println.kotlin.chapter08.javareflections.JavaReflectionsKt;
import net.println.kotlin.chapter08.javareflections.Person;

/**
 * @author zhangkun
 * @time 2020/9/29 8:14 上午
 */
public class JavaTestHello {

    public static void main(String[] args) {
        try {
            JavaReflectionsKt.class.getDeclaredMethod("sayHello", Person.class)
                    .invoke(null,new Person("zhang", 12));
            // invoke 调用静态方法，第一个参数需要传null，函数本身，第二个参数是sayHello的参数,
            // 如果是非静态则需要传入实例
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
