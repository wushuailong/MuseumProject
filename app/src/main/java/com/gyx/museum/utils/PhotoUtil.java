package com.gyx.museum.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gyx.museum.R;


/**
 * 内容：
 * Created by 关云秀 on 2017\10\18 0018.
 */

public class PhotoUtil {
    public static void getPhoto(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).error(R.mipmap.err_bg).placeholder(R.mipmap.no_data_bg).dontAnimate().centerCrop().into(imageView);
    }
}
