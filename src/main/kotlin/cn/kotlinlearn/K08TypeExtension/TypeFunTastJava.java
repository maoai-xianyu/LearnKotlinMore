package cn.kotlinlearn.K08TypeExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * author:  zhangkun .
 * date:    on 2018/3/21.
 */

public class TypeFunTastJava {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PublicFunKt.swap(list,0,1);
        System.out.println(list);


        int m = 0;
        boolean odd = PublicFunKt.isOdd(m);
        System.out.println(" 奇数 "+odd);

    }
}
