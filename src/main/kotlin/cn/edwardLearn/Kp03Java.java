package cn.edwardLearn;

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 */
public class Kp03Java {


    public static void main(String[] args) {

        Person personA = new Person("p1",12);
        Person personB = new Person("p2",35);
        Person personC = new Person("p1",12);

        // 引用相等
        System.out.println(personA == personB);
        System.out.println(personA == personC);
        // 结构相等
        System.out.println(personA.equals(personB));
        System.out.println(personA.equals(personC));

    }

}
