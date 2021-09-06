package kotlin;

/**
 * @author zhangkun
 * @time 2020/10/27 9:29 下午
 */
public class DebugTest {

    public static final int MATRIX_SAVE_FLAG = 0x01;

    /**
     * Restore the current clip when restore() is called.
     */
    public static final int CLIP_SAVE_FLAG = 0x02;

    /**
     * The layer requires a per-pixel alpha channel.
     */
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;

    /**
     * The layer requires full 8-bit precision for each color channel.
     */
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;

    public static void main(String[] args) {


        String sssss = "sdasdasdasdas{}asdasdasdasdasd";
        String[] split = sssss.split("\\{}");
        for (String s : split
        ) {
            System.out.println(s);
        }

        System.out.println("ssss");
        String mm = "sdsdsdsdsdsd";

      /*  int i = mm.indexOf(null);
        System.out.println(i);*/


        int saveFlags = MATRIX_SAVE_FLAG
                | CLIP_SAVE_FLAG
                | HAS_ALPHA_LAYER_SAVE_FLAG
                | FULL_COLOR_LAYER_SAVE_FLAG
                | CLIP_TO_LAYER_SAVE_FLAG;

        System.out.println("saveFlags " + saveFlags);


        String str = "openapp.jdmobile://virtual?params=%7B%22category%22%3A%22jump%22%2C%22des%22%3A%22m%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fcl%3Fposid%3D1999%26v%3D707%26union_id%3D1000023385%26pid%3D3232%26tagid%3D157312%26didmd5%3D__IMEI__%26idfamd5%3D__IDFA__%26did%3D__IMEIIMEI__%26idfa%3D__IDFAIDFA__%26oaid%3D__OAID__%26caid%3D__CAID__%26to%3Dhttps%253A%252F%252Fprodev.m.jd.com%252Fmall%252Factive%252FC7T8PzEjGKL7WiXAJmATw4YuNeZ%252Findex.html%253Fad_od%253D1%2526babelChannel%253Dttt13%22%2C%22m_param%22%3A%7B%22jdv%22%3A%22122270672%7Ckong%7Ct_1000023385_157312%7Czssc%7Cd36d13b9-61c4-4fdf-b7f2-11dbc28d14dd-p_1999-pr_3232-at_157312%22%7D%2C%22keplerFrom%22%3A%221%22%2C%22kepler_param%22%3A%7B%22source%22%3A%22kepler-open%22%2C%22otherData%22%3A%7B%22channel%22%3A%22b4dc3278288f4a25982ccdec07ebdc41%22%7D%7D%7D";

        int i1 = str.indexOf("://");

        String substring = str.substring(0, i1);
        System.out.println("substring  " + substring);

    }
}
