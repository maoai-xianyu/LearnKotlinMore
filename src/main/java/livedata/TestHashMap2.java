package livedata;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap2 {

    public static void main(String[] args) {
        final Map map = new HashMap(4, 0.5f);
        new Thread() {
            public void run() {
                while (true) {
                    System.out.println(map.get("name1"));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        for (int i = 0; i < 3; i++) {
            map.put("name" + i, "value" + i);
        }


        System.out.println(new HashMap<String, String>().put("id", "001"));
    }

}
