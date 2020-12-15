package kotlin.chapter10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {

    public static void main(String[] args) {


        ArrayList<P> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new P(i, "i " + i));
        }

        // 方式一 不行
        //ArrayList<P> listNew = (ArrayList<P>) list.clone();
        // 方式二 Arrays copy 数组
        // ArrayList<P> listNew = Arrays.asList(list);

        // 方式三，可以，但是需要对象重写 clone 方法
        ArrayList<P> listNew = new ArrayList<>();
        for (P p : list) {
            try {
                listNew.add(p.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < listNew.size(); i++) {
            if (listNew.get(i).id == 1) {
                P p1 = listNew.get(i);
                p1.name="zhang";
                break;
            }
        }

        for (P p : list) {
            System.out.println(p);
        }

        System.out.println("------");

        for (P p : listNew) {
            System.out.println(p);
        }

    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    static class P implements Cloneable{

        public P(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int id;
        String name;

        @Override
        public String toString() {
            return "P{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        protected P clone() throws CloneNotSupportedException {
            return (P) super.clone();
        }
    }
}
