package com.gyx.museum.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;
import com.gyx.museum.image.ImageManager;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.utils.ImageLoader;
import com.gyx.museum.utils.ImageLoaderUtil;
import com.gyx.museum.utils.ImageUtil;
import com.gyx.museum.widget.ScaleImageView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\9 0009.
 */

public class MuseumClassifyAdapter extends BaseQuickAdapter<ImageBean> {
    private Context context;
    private List<Integer> mHeights = new ArrayList<>();;
    public MuseumClassifyAdapter(List<ImageBean> list, Context context) {
        super(R.layout.item_image_text,list);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, ImageBean imageBean) {

        final ScaleImageView imageView = helper.getView(R.id.imageview);
      /*  Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageBean.getResource());
        int height = bitmap.getHeight();
        int width= bitmap.getWidth();
        double scale = (float)width /(float)height;
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        int vh = (int) Math.round((getScreenWidth(context)/2)/scale);
        params.width = getScreenWidth(context)/2;
        params.height =vh  ;
        imageView.setLayoutParams(params);
        */


      //  Log.i("heightMax", w+"***"+h +"&&&&"+scale+"vh"+vh);
        //
       // imageView.setInitSize(imageBean.getWidth(), imageBean.getHeight());
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        //int vh = (int) Math.round((getScreenWidth(context)/2)/scale);
        params.width = imageBean.getWidth();
        params.height =imageBean.getHeight() ;
        imageView.setLayoutParams(params);
        //Glide.with(context).load(imageBean.getSource()).placeholder(R.mipmap.ic_launcher).into(imageView);
        //ImageLoader.load(context,
          //      imageBean.getSource(), imageView);
        imageView.setImageResource(imageBean.getResource());

        helper.setText(R.id.title_tv,imageBean.getTitle());
        helper.setText(R.id.code_tv,imageBean.getCode());




     /*   ImageLoaderUtil.displayImage(mContext, imageView, imageBean.getSource(), ImageLoaderUtil.getPhotoImageOption(), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
            }
            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            }
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap bitmap) {
                int w = bitmap.getWidth();
                int h = bitmap.getHeight();

                double scale = (float)w /(float)h;

                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                int vh = (int) Math.round((getScreenWidth(context)/2)/scale);
                params.width = getScreenWidth(context)/2;
                params.height =vh  ;
                Log.i("heightMax", w+"***"+h +"&&&&"+scale+"vh"+vh);
                imageView.setLayoutParams(params);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });*/

    }
    public void getRandomHeight(List<ImageBean> mList){
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+ Math.random()*400));
        }
    }
    public static int getScreenWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
