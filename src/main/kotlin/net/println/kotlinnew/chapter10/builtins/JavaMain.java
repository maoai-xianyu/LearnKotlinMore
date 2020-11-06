package net.println.kotlinnew.chapter10.builtins;

import java.io.IOException;

public class JavaMain {
    public static void main(String... args) {
        try {
            KotlinAnnotations.throwException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void throwException() throws IOException {

    }
}
