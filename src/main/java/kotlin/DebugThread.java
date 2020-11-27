package kotlin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DebugThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " index = " + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
