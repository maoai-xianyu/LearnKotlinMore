package cn.edwardLearn;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Kp52Car {

    private String model;
    private String color;
    private int year;

    private String test;
    private String name;

    private Object object;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Kp52Car(String model, String color, int year, String test, String name) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.test = test;
        this.name = name;
    }

    public Kp52Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Kp52Car() {
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public @NotNull
    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void variableMethod(String... strings) {
        for (String str : strings) {
            System.out.println("---" + str);
        }
    }

    public void wantsIntArray(int[] array){
        for (int i:array) {
            System.out.println("----"+i);
        }
    }

    @Override
    public String toString() {
        return "Kp52Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", test='" + test + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
