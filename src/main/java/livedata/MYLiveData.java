package livedata;

public class MYLiveData<T> {

    private String mKey;

    public MYLiveData(String key) {
        this.mKey = key;
    }


    public void obsever(T t){

        System.out.println("------ 订阅");

    }
}
