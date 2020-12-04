fun main(args: Array<String>) {

    val MATRIX_SAVE_FLAG = 0x01

    /**
     * Restore the current clip when restore() is called.
     */
    val CLIP_SAVE_FLAG = 0x02

    /**
     * The layer requires a per-pixel alpha channel.
     */
    val HAS_ALPHA_LAYER_SAVE_FLAG = 0x04

    /**
     * The layer requires full 8-bit precision for each color channel.
     */
    val FULL_COLOR_LAYER_SAVE_FLAG = 0x08

    val CLIP_TO_LAYER_SAVE_FLAG = 0x10


    val saveFlags = (MATRIX_SAVE_FLAG
            or CLIP_SAVE_FLAG
            or HAS_ALPHA_LAYER_SAVE_FLAG
            or FULL_COLOR_LAYER_SAVE_FLAG
            or CLIP_TO_LAYER_SAVE_FLAG)

    println("saveFlags $saveFlags")

}