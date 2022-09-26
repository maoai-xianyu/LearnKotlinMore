package livedata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocal {
    private static ConcurrentHashMap<Thread, Integer> map;

    public static void main(String[] args) {
        map = new ConcurrentHashMap<Thread, Integer>();
        for (int i = 0; i < 5000; i++) {
            new Thread(new Runnable() {

                public void run() {
                    int data = new Random().nextInt();
                    //map.put(Thread.currentThread(), data);
                    getChannel(Thread.currentThread(), data);
                    System.out.println(Thread.currentThread() + ", data:"
                            + data);
                    /*new A().show();
                    new B().show();*/
                    showA();
                    showB();
                }
            }).start();
        }
    }

    public static int getChannel(Thread key, int data) {
        if (!map.containsKey(key)) {
            map.put(key, data);
        }
        System.out.println(key + ", data:" + data);
        return map.get(key);
    }


    private static void showA() {
        System.out.println(Thread.currentThread() + "调用A, data:" + map.get(Thread.currentThread()));
    }

    private static void showB() {
        System.out.println(Thread.currentThread() + "调用b, data:" + map.get(Thread.currentThread()));
    }

    static class A {
        public void show() {
            System.out.println(Thread.currentThread() + "调用A, data:" + map.get(Thread.currentThread()));
        }
    }

    static class B {
        public void show() {
            System.out.println(Thread.currentThread() + "调用B, data:" + map.get(Thread.currentThread()));
        }
    }
}