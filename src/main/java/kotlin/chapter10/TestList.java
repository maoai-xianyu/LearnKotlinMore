package kotlin.chapter10;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        modelCopy();
        coll();
        collDeepNew();
        collDeep();
        collBeautiful();

    }


    private static void modelCopy() {
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
                p1.name = "zhang";
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

    private static void coll() {
        System.out.println("CollectionUtils -------- 需要对新改的数据进行重新赋值");

        List<PP> listP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listP.add(new PP(i, "i " + i));
        }

        //list深度拷贝
        List<PP> newListP = new ArrayList<>(listP.size());
        CollectionUtils.addAll(newListP, new Object[listP.size()]);
        Collections.copy(newListP, listP);
        for (int i = 0; i < newListP.size(); i++) {
            if (i == 1) {
                PP pp = new PP(newListP.get(i).id, newListP.get(i).name);
                pp.name = "zhang";
                newListP.set(i, pp);
                break;
            }
        }
        System.out.println("原list值：" + listP);
        System.out.println("新list值：" + newListP);

        System.out.println("---------------------");


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //list深度拷贝
        List<Integer> newList = new ArrayList<>();
        CollectionUtils.addAll(newList, new Object[list.size()]);
        Collections.copy(newList, list);
        newList.set(0, 10);

        System.out.println("原list值：" + list);
        System.out.println("新list值：" + newList);
    }


    private static void collDeepNew() {
        System.out.println("循环赋值 创建新的对象 -------");

        ArrayList<PP> listP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listP.add(new PP(i, "i " + i));
        }

        ArrayList<PP> newListP = (ArrayList<PP>) listP.clone();
        System.out.println(" newListP == listP 前" + (newListP == listP));
        if (newListP != null) {
            for (int i = 0; i < newListP.size(); i++) {
                if (i == 1) {
                    PP pp = new PP(newListP.get(i).id, newListP.get(i).name);
                    pp.name = "zhang";
                    newListP.set(i, pp);
                    break;
                }
            }
            System.out.println(" newListP == listP 后" + (newListP == listP));

            System.out.println("---------------------");
            System.out.println("循环赋值 原list值：" + listP);
            System.out.println("循环赋值 新list值：" + newListP);
        }


        System.out.println("---------------------");

    }


    private static void collDeep() {
        System.out.println("DeepCopyUtil -------- 深拷贝 需要实体类继承 Serializable");

        List<PP> listP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listP.add(new PP(i, "i " + i));
        }

        //list深度拷贝
        List<PP> newListP = DeepCopyUtil.deepCopy(listP);
        if (newListP != null) {
            for (int i = 0; i < newListP.size(); i++) {
                if (i == 1) {
                    newListP.get(i).name = "zhang";
                    break;
                }
            }

            System.out.println("原list值：" + listP);
            System.out.println("新list值：" + newListP);
        }

    }

    private static void collBeautiful() {
        System.out.println("collBeautiful -------- 深拷贝 需要实体类继承 Serializable");

        List<PP> listP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listP.add(new PP(i, "i " + i));
        }

        //list深度拷贝
        try {
            List<PP> newListP = new ArrayList<>();
            for (int i = 0; i < listP.size(); i++) {
                newListP.add((PP) BeanUtils.cloneBean(listP.get(i)));
            }

            for (int i = 0; i < newListP.size(); i++) {
                if (i == 1) {
                    newListP.get(i).name = "zhang";
                }
            }

            System.out.println("原list值：" + listP);
            System.out.println("新list值：" + newListP);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class P implements Cloneable {

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


    static class PP implements Serializable {

        public PP(int id, String name) {
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

    }

}
