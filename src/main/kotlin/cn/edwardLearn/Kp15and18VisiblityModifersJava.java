package cn.edwardLearn;

/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 */
public class Kp15and18VisiblityModifersJava {

    public static void main(String[] args) {

        Kp15ClassB kp15ClassB = new Kp15ClassB();
        System.out.println(kp15ClassB);

        Kp18JavaPerson javaPerson = new Kp18JavaPerson("Jsok", 13);
        System.out.println(javaPerson);

        System.out.println(Config.FamousCourseState.FC_CHINA);
        System.out.println(Config.FamousCourseState.INSTANCE.getFC_FOREIGN());
    }

}


