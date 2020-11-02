package kotlin.chapter10.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangkun
 * @time 2020/10/21 11:35 下午
 */
public class RegexInJava {

    public static void main(String[] args) {

        String source = "我是中国人，大家好啊。一条龙 010-22200222.";
        String pattern = ".*(\\d{3}-\\d{8}).*";
        Matcher matcher = Pattern.compile(pattern).matcher(source);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }
}
