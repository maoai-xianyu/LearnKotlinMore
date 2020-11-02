package kotlin.chapter10.sam;
import java.util.ArrayList;

/**
 * @author zhangkun
 * @time 2020/10/21 11:16 下午
 */
public class SAMInJava {
    private ArrayList<Runnable> runnableArrayList = new ArrayList<>();

    public void addTask(Runnable runnable) {
        runnableArrayList.add(runnable);
        System.out.println("after add " + runnable + "we have " + runnableArrayList.size() + "个");
    }

    public void removeTask(Runnable runnable) {
        runnableArrayList.remove(runnable);
        System.out.println("after remove " + runnable + "we have " + runnableArrayList.size() + "个");

    }
}
