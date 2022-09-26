package livedata;

import java.lang.reflect.Proxy;

public class Testsss {


    public static <T> MYLiveData<T> get(String key) {
        return MYLiveDataBusCore.getInstance().getChannel(key);
    }

    /**
     * 将事件的定义由事件总线框架本身通过动态代理去实现，用于提供用于事件约束
     */
    public static <E> E of(Class<E> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }

        if (0 < cls.getInterfaces().length) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }

        /*return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls},
                (proxy, method, args) -> {

                    System.out.println("------ cls.getCanonicalName() " + cls.getCanonicalName());
                    System.out.println("------  method.getName() " + method.getName());
//                    return get(cls.getCanonicalName()+"_"+method.getName());
                    return null;
                }));*/

        E res = null;
        try {
            res = (E) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls},
                    (proxy, method, args) -> {

                        System.out.println("------ cls.getCanonicalName() " + cls.getCanonicalName());
                        System.out.println("------  method.getName() " + method.getName());
//                    return get(cls.getCanonicalName()+"_"+method.getName());
                        return null;
                    });
        } catch (Exception e) {
           e.printStackTrace();
        }



        return res;

    }

    public static void main(String[] args) {

        Money money = new Money();

        of(LiveDataEvent.class)
                .test()
                .obsever(money);

    }

}
