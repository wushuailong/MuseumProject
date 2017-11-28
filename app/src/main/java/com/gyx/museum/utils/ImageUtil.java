package com.gyx.museum.utils;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\28 0028.
 */

public class ImageUtil {
    /**
     * 计算宽高比
     *
     * @param width
     * @param height
     * @return
     */
    public static float getAspectRatio(int width, int height) {
        float ratio = (float) width / (float) height;
        //宽高比<0.7 表示长图 需要截断处理
        if (ratio < 0.7) {
            return 0.7f;
        }
        //// TODO: 2016/5/11 0011 ratio>3会导致图片不能显示
        return ratio;
    }
}
