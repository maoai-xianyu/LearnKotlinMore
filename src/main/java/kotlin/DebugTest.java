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

        System.out.println("ssss");
        String mm = "sdsdsdsdsdsd";

        int i = mm.indexOf(null);
        System.out.println(i);


        int saveFlags = MATRIX_SAVE_FLAG
                | CLIP_SAVE_FLAG
                | HAS_ALPHA_LAYER_SAVE_FLAG
                | FULL_COLOR_LAYER_SAVE_FLAG
                | CLIP_TO_LAYER_SAVE_FLAG;

        System.out.println("saveFlags " + saveFlags);
    }
}
