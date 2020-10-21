package net.println.kotlin.chapter04;

/**
 * @author zhangkun
 * @time 2020/5/27 8:58 上午
 */
public class StaticJAva {

    public static void main(String[] args) {
        Latitude latitude0 = Latitude.Companion.toDouble(3.0);
        // latitude0  和 latitude 一样 toDouble 是被 JvmStatic 修饰的
        Latitude latitude = Latitude.toDouble(3.0);
        System.out.println("数据 " + latitude.getValue());
        Latitude latitude1 = Latitude.Companion.ofDouble(2.0);
        System.out.println("数据 latitude1 " + latitude1.getValue());
    }
}
