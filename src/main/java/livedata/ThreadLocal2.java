package livedata;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 可以拿到空的现象
 */
public class ThreadLocal2 {
    private static HashMap<Thread, Integer> map;

    public static void main(String[] args) {
        map = new HashMap<Thread, Integer>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                map.put(Thread.currentThread(), data);
                System.out.println(Thread.currentThread() + ", data:"
                        + data);
                new A().show();
                new B().show();
            }).start();
        }
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