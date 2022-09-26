package livedata;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zhangkun
 * @time 2022/2/21 11:16
 * @Description 管理类，单例模式
 */
public class MYLiveDataBusCore {

    private final Map<String, MYLiveData<?>> mBusMap;

    private MYLiveDataBusCore() {
        mBusMap = new HashMap<>();
    }

    /**
     * 单例模式实现
     */
    private static class SingletonHolder {

        private static final MYLiveDataBusCore DEFAULT_BUS = new MYLiveDataBusCore();
    }

    public static MYLiveDataBusCore getInstance() {
        return SingletonHolder.DEFAULT_BUS;
    }

    public <T> MYLiveData<T> getChannel(String key) {
        if (!mBusMap.containsKey(key)) {
            System.out.println("------  存在 "+key);
            mBusMap.put(key, new MYLiveData<>(key));
        }
        return (MYLiveData<T>) mBusMap.get(key);
    }


    public void removeKey(String key) {
        mBusMap.remove(key);
    }
}
