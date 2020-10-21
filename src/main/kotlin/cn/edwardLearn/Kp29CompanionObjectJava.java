package cn.edwardLearn;

/**
 * author:  zhangkun .
 * date:    on 2018/6/8.
 */
public class Kp29CompanionObjectJava {

    private static int staticVar = 10;

    public static void accessStativVar(){
        System.out.println("Accessing stativVar = "+ staticVar);
    }

    public static void main(String[] args) {
        new Kp29CompanionObjectJavaTest().test();
    }
}
