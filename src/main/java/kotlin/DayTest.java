package kotlin;

import java.util.regex.Pattern;

/**
 * @author zhangkun
 * @time 2021/10/24 下午10:20
 */
public class DayTest {

    private final static String regex = "^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6}|[0-9a-fA-F]{3})$";
    private final static String color_regex = "^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$";
    private final static String COLOR_REGEX_8 = "^#([0-9a-fA-F]{8})$";
    private final static String COLOR_REGEX_6 = "^#([0-9a-fA-F]{6})$";


    public static void main(String[] args) {

        boolean isColor = checkColor(color_regex, "#ffeeff");
        System.out.println("isColor  " + isColor);

        boolean isColor1 = checkColor(COLOR_REGEX_8, "#00dd0eff");
        System.out.println("isColor1  " + isColor1);

        boolean isColor2 = checkColor(COLOR_REGEX_6, "#dd0eff");
        System.out.println("isColor2  " + isColor2);


        convertColor("2e", "#2edd0eff");
        convertColor("2e", "#dd0abb");
        convertColor("2e","#abb");

    }


    /**
     * 颜色转换
     *
     * @param transparency 透明度，默认是82% 透敏度 对应的是 2E 且必须是两位
     */
    public static int convertColor(String transparency, String color) {

        if ((!isEmpty(transparency) && transparency.length() == 2) && checkColor(color)) {
            String convertColor;
            if (Pattern.matches(COLOR_REGEX_8, color)) {
                System.out.println(" convertColor 8 ");
                convertColor = "#" + transparency + color.substring(3);
            } else {
                System.out.println(" convertColor  6");
                convertColor = "#" + transparency + color.substring(1);
            }
            System.out.println("convertColor " + convertColor + " leng "+convertColor.length());
            if (checkColor(convertColor)) {
                System.out.println("convertColor true " + convertColor);
                return 1;
            }
        }
        throw new IllegalArgumentException("Unknown color");
    }

    public static boolean checkColor(String color) {
        return checkColor(color_regex, color);
    }

    public static boolean checkColor(String regex, String color) {
        return Pattern.matches(regex, color);
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
