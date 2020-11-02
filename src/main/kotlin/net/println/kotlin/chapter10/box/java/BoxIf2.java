package net.println.kotlin.chapter10.box.java;

import java.util.Map;

/**
 * @author zhangkun
 * @time 2020/10/22 12:06 下午
 */
public interface BoxIf2 extends Map<Integer, String> {

    String get(int key);

    String get(Integer key);
}
