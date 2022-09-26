package livedata;

import java.util.HashMap;
import java.util.Random;

/**
 * 使用同步也会有 显示为空的时候
 */
public class ThreadLocal3 {
    private static HashMap<Thread, Integer> map;

    public static void main(String[] args) {
        map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                //map.put(Thread.currentThread(), data);
                getChannel(Thread.currentThread(), data);
                System.out.println(Thread.currentThread() + ", data:"
                        + data);
                /*new A().show();
                new B().show();*/
                showA();
                showB();
            }).start();
        }
    }


    public synchronized static int getChannel(Thread key, int data) {
        if (!map.containsKey(key)) {
            map.put(key, data);
        }

        //System.out.println(key + ", data:" + data +" map " +map);
        return map.get(key);
    }

    private synchronized static void showA (){
        System.out.println(Thread.currentThread() + "调用A, data:" + map.get(Thread.currentThread()));
    }

    private synchronized static void showB (){
        System.out.println(Thread.currentThread() + "调用b, data:" + map.get(Thread.currentThread()));
    }


    // 同步也是会有的
    static class A {
        public synchronized void show() {
            System.out.println(Thread.currentThread() + "调用A, data:" + map.get(Thread.currentThread()));
        }
    }

    static class B {
        public synchronized void show() {
            System.out.println(Thread.currentThread() + "调用B, data:" + map.get(Thread.currentThread()));
        }
    }
}