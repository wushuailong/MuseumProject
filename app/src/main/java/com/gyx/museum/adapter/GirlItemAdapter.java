package com.gyx.museum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseApplication;
import com.gyx.museum.base.baseadapter.BaseAdapter;
import com.gyx.museum.base.baseadapter.ViewHolder;
import com.gyx.museum.image.ImageManager;
import com.gyx.museum.model.GirlItemData;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.widget.ScaleImageView;


import java.util.List;

/**
 * Author: Othershe
 * Time: 2016/8/18 21:59
 */
public class GirlItemAdapter extends BaseAdapter<GirlItemData> {

    public GirlItemAdapter(Context context, List<GirlItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }


    @Override
    protected void convert(ViewHolder holder, GirlItemData data) {
        ScaleImageView imageView = holder.getView(R.id.girl_item_iv);
        imageView.setInitSize(data.getWidth(), data.getHeight());
        ImageManager.getInstance().loadImage(BaseApplication.getInstance(),data.getUrl(),imageView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_image_text;
    }
}
