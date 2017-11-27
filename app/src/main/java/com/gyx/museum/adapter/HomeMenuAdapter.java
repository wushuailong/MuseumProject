package com.gyx.museum.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;
import com.gyx.museum.model.HomeMenu;

import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\9 0009.
 */

public class HomeMenuAdapter extends BaseQuickAdapter<HomeMenu> {
    public HomeMenuAdapter(List<HomeMenu> list) {
        super(R.layout.activity_homemenu_item,list);
    }
    @Override
    protected void convert(BaseViewHolder helper, HomeMenu homeMenu) {
        helper.setImageResource(R.id.icon_img,homeMenu.getImage());
        helper.setText(R.id.title_tv,homeMenu.getDesp());
    }
}
