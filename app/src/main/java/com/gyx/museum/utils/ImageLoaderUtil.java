package com.gyx.museum.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.gyx.museum.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


/**
 * Created by HMY
 */
public class ImageLoaderUtil {

    public static ImageLoader getImageLoader(Context context) {

        return ImageLoader.getInstance();
    }

    public static DisplayImageOptions getPhotoImageOption() {
        double extra =0.5;
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.err_bg).showImageOnFail(R.mipmap.err_bg)
                .showImageOnLoading(R.mipmap.err_bg)
                .extraForDownloader(extra).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        return options;
    }

    public static void displayImage(Context context, ImageView imageView, String url, DisplayImageOptions options) {
        getImageLoader(context).displayImage(url, imageView, options);
    }

    public static void displayImage(Context context, ImageView imageView, String url, DisplayImageOptions options, ImageLoadingListener listener) {
        getImageLoader(context).displayImage(url, imageView, options, listener);
    }
}
