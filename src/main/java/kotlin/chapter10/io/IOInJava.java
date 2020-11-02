package kotlin.chapter10.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhangkun
 * @time 2020/10/22 8:43 上午
 */
public class IOInJava {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("build.gradle"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
