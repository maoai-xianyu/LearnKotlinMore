package livedata;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
        testMap();
    }

    public static void testMap(){
        for (int i = 0; i < 5000; i++) {
            HashMap<String,String> map = new HashMap<>();
//            ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

            for (int j = 0; j < 2; j++) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (getChannel(map,"main_key") == null) {
                            System.out.println("#########@@@@this is null");
                        }
                    }
                });
                thread.start();
            }
        }
        System.out.println("######@finish");
    }


    public static String getChannel(HashMap<String,String> map,String key) {
//    public synchronized static String getChannel(HashMap<String,String> map,String key) {
//    public static String getChannel(ConcurrentHashMap<String,String> map,String key) {
        if (!map.containsKey(key)) {
            map.put(key,"hello");
        }
        return map.get(key);
    }
}
