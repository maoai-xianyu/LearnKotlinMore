package net.println.kotlinnew.chapter07.innerclasses;

/**
 * @author zhangkun
 * @time 2020/10/21 11:20 上午
 */
public class JavaInnerClasses {
    public static void main(String... args) {

        // 本地类
        class LocalClass implements Cloneable, Runnable {
            @Override
            public void run() { }
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
