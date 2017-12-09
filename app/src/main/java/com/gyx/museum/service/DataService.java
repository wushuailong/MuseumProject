package com.gyx.museum.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.gyx.museum.base.BaseApplication;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.utils.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Othershe
 * Time: 2016/8/18 11:48
 */
public class DataService extends IntentService {
    public DataService() {
        super("");
    }

    public static void startService(Context context, List<ImageBean> datas) {
        Intent intent = new Intent(context, DataService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) datas);
        intent.putExtras(bundle);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        List<ImageBean> datas = (List<ImageBean>) intent.getSerializableExtra("data");
        handleGirlItemData(datas);
    }

    private void handleGirlItemData(List<ImageBean> datas) {
        if (datas.size() == 0) {
            EventBus.getDefault().post("finish");
            return;
        }
        for (final ImageBean data : datas) {
            final Bitmap bitmap = BitmapFactory.decodeResource(BaseApplication.getInstance().getResources(), data.getResource());
           // Bitmap bitmap = ImageLoader.load(this, data.getSource());
            if (bitmap != null) {
                double scale = (float)bitmap.getWidth() /(float)bitmap.getHeight();
                int vh = (int) Math.round((getScreenWidth(BaseApplication.getInstance())/2)/scale);
                data.setWidth(getScreenWidth(BaseApplication.getInstance())/2);
                data.setHeight(vh);
            }
        }
        EventBus.getDefault().post(datas);
    }
    public static int getScreenWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
