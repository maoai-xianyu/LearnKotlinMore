package kotlin.chapter10;

import java.util.ArrayList;
import java.util.List;

public class TestString {

    private static List<String> idPageStr = new ArrayList<>();
    private static List<String> idPageStr2 = new ArrayList<>();


    public static void main(String[] args) {


        long sss = 123123123132L /1000;
        System.out.println("ssss "+sss);


        List<Long> ids = new ArrayList<>();

        ids.add(1112263434L);
        ids.add(1112266294L);
        ids.add(1112262841L);
        ids.add(1112265485L);
        ids.add(1112273080L);
        ids.add(1112218017L);
        ids.add(1035857158L);
        ids.add(1112269022L);
        ids.add(1112404984L);
        ids.add(1112440166L);
        ids.add(1112442077L);
        ids.add(1112420581L);
        ids.add(1112437624L);
        ids.add(1112442062L);

        splitePageId(ids);

        for (String str : idPageStr) {
            System.out.println("str " + str);
        }


        splitePageId2(ids);
        for (String str : idPageStr2) {
            System.out.println("str2 " + str);
        }
    }

    private static void splitePageId(List<Long> ids) {
        int limit = 10;
        int size = ids.size();
        int pageCount = size % limit == 0 ? (size / limit) : (size / limit + 1);
        for (int i = 0; i < pageCount; i++) {
            int start = limit * i;
            int end = start + limit;
            //如果是最后一行
            if (i == pageCount - 1) {
                end = ids.size();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ids.subList(start, end));
            //去掉两头的中括号
            stringBuilder.deleteCharAt(0);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            idPageStr.add(stringBuilder.toString());
        }
    }


    private static void splitePageId2(List<Long> ids) {
        int limit = 10;
        int size = ids.size();
        int pageCount = size % limit == 0 ? (size / limit) : (size / limit + 1);
        for (int i = 0; i < pageCount; i++) {
            int start = limit * i;
            int end = start + limit;
            //如果是最后一行
            if (i == pageCount - 1) {
                end = ids.size();
            }
            StringBuilder stringBuilder = new StringBuilder();
            List<Long> longs = ids.subList(start, end);
            for (int j = 0; j < longs.size(); j++) {
                stringBuilder.append(longs.get(i)).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            idPageStr2.add(stringBuilder.toString());
        }
    }

    // 1112440166, 1112442077, 1112420581, 1112437624, 1112442062
}
