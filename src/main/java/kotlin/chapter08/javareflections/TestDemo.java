package kotlin.chapter08.javareflections;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("test1");

        list.removeAll(list2);


    }
}
