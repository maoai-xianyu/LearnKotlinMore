package livedata;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用同步也会有 显示为空的时候
 *
 *
 */
public class ThreadLocal5 {
    private static ConcurrentHashMap<String, Integer> map;
//    private static HashMap<String, Integer> map;

    public static void main(String[] args) {
        map = new ConcurrentHashMap<>();
//        map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                int data = new Random().nextInt(500) + 1;
                String key = data + "_method";
                getChannel(key, data);
                System.out.println(Thread.currentThread() + "----  " + key + ", data:" + data);
                showA(key);
                showB(key);
            }).start();
        }
    }

    public synchronized static int getChannel(String key, int data) {
        if (!map.containsKey(key)) {
            map.put(key, data);
        }
        return map.get(key);
    }

//    private static void showA(String key) {
    private synchronized static void showA(String key) {
        System.out.println("key " + key + "  调用A, data:" + map.get(key));
    }

//    private static void showB(String key) {
    private synchronized static void showB(String key) {
        System.out.println("key " + key + "  调用b, data:" + map.get(key));

    }

}