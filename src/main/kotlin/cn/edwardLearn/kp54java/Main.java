package cn.edwardLearn.kp54java;

import cn.edwardLearn.kp54kotlin.CarTest;
import cn.edwardLearn.kp54kotlin.CatTestDomain;
import cn.edwardLearn.kp54kotlin.SingletonObj;
import cn.edwardLearn.kp54kotlin.StaticCar;

import java.io.IOException;

/**
 * create by zhangkun .
 * on 2018/10/30
 */
public class Main {

    public static void main(String[] args) {


        CatTestDomain catTestDomain = new CatTestDomain("demo");
        CatTestDomain catTestDomain1 = new CatTestDomain(1);

        System.out.println(catTestDomain.getColor());
        System.out.println(catTestDomain.getModel());

        System.out.println(catTestDomain1.getColor());
        System.out.println(catTestDomain1.getModel());


        StaticCar.topLevel();
        StaticCar.print("still hello world calling in java");

        CarTest carTest = new CarTest("demo","yellow",1,true);
        System.out.println(carTest.isAutomatic());
        carTest.setAutomatic(false);


        CarTest.Companion.carComp();

        System.out.println("----------------两种方式都可以");
        CarTest.Companion.carCompJvm();
        CarTest.carCompJvm();


        SingletonObj.INSTANCE.doSomething();

        SingletonObj.doSomethingJvm();


        System.out.println(CarTest.Companion.getIshBrid());
        System.out.println(CarTest.getIshBridJvm());
        System.out.println(CarTest.isConst);

        //carTest.typeTry("");
        //carTest.typeTry(null);

        try {
            StaticCar.throwIOException();
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        // java 中不行
        StaticCar.defaultParam("this is java");


    }
}
