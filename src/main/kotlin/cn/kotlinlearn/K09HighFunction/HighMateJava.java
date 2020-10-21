package cn.kotlinlearn.K09HighFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * author:  zhangkun .
 * date:    on 2018/5/25.
 *
 * 给一个字符串数组，检查每个字符串的字母是否都在美式键盘的同一行里（字符串只包括英语拉丁字母），返回符合条件的字符串。
 *
 * 一般来说，Java 的解决方法分成下面几步：
 * 定义每行所含的字母，遍历输入的数组；
 * 对于每个字符串，查找首字符在键盘的哪一行；接着检查之后的字符是否都在这一行里。
 * 将符合条件的字符串汇总输出。
 */
public class HighMateJava {

    public static void main(String[] args) {

        String[] strings = {"qweqweqwe", "svrhk", "zxczxczx", "piukmne","asdasdasd"};

        String[] words = findWords(strings);

        for (String word : words) {
            System.out.println(" 数据是  " + word);
        }

    }

    public static String[] findWords(String[] words) {
        final String[] rows = {
                "qwertyuiopQWERTYUIOP",
                "asdfghjklASDFGHJKL",
                "zxcvbnmZXCVBNM"
        };
        List<String> list = new ArrayList<>(words.length);
        oneWord:
        for (String word : words) {
            char c = word.charAt(0);
            String lookingFor = rows[0];
            for (String row : rows) {
                if (row.indexOf(c) != -1) {
                    lookingFor = row;
                    break;
                }
            }
            for (int i = 1; i < word.length(); i++) {
                if (lookingFor.indexOf(word.charAt(i)) == -1) {
                    continue oneWord;
                }
            }
            list.add(word);
        }
        return list.toArray(new String[0]);
    }

}
