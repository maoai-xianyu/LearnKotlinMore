package livedata;

import java.util.HashMap;
import java.util.Random;


/**
 * 复现过一次  拿到是空的现象
 */

public class TestHashMap1 {

    private static HashMap<String, String> map;

    public static void main(String[] args) {
        testMap();
    }

    public static void testMap() {
        map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    if (getChannel(Thread.currentThread().getName() +data,data+"") == null) {
                        System.out.println("#########@@@@this is null");
                    }
                }
            });
            thread.start();
        }
        System.out.println("######@finish");
    }


    public synchronized static String getChannel(String key,String data) {
        if (!map.containsKey(key)) {
            map.put(key, data+"");
        }
        return map.get(key);
    }
}
