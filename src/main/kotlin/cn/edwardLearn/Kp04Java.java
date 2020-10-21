package cn.edwardLearn;

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 */
public class Kp04Java {

    public static void main(String[] args) {

        Person personA = new Person("jascsd", 12);
        Object person = personA;
        Person person1 = (Person) person;
        System.out.println(" person1" + person1);

        if (person instanceof Person) {
            System.out.println("true");
            System.out.println(((Person) person).getName());
        }

    }
}
