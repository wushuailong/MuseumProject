package com.gyx.museum.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.widget.ScaleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\9 0009.
 */

public class BwgExhibitionAdapter extends BaseQuickAdapter<ImageBean> {
    private Context context;
    public BwgExhibitionAdapter(List<ImageBean> list, Context context) {
        super(R.layout.activity_bwg_exhibition_item,list);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, ImageBean imageBean) {


    }

}
