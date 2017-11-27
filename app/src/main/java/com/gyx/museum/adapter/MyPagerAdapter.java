package com.gyx.museum.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyx.museum.image.ImageManager;
import com.gyx.museum.model.LoopImage;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\18 0018.
 */

public class MyPagerAdapter extends StaticPagerAdapter {

    List<LoopImage> loopImageList;
    Context context;
    // SetScaleType(ImageView.ScaleType.CENTER_CROP);
    // 按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽)
    public MyPagerAdapter(List<LoopImage> loopImageList, Context context){
        this.loopImageList = loopImageList;
        this.context = context;
    }
    @Override
    public View getView(ViewGroup container, int position) {
        LoopImage loopImage = loopImageList.get(position);
        ImageView imageView = new ImageView(container.getContext());
       // imageView.setImageResource(image[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       // imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageManager.getInstance().loadImage(context,loopImage.getPath(),imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return loopImageList.size();
    }
}

