package com.gyx.museum.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;

import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class MxWenwuAdapter  extends BaseQuickAdapter<String> {
    public MxWenwuAdapter(List<String> list) {
        super(R.layout.activity_mxsww_item,list);
    }
    @Override
    protected void convert(BaseViewHolder helper, String homeMenu) {
        //helper.setImageResource(R.id.icon_img,homeMenu.getImage());
        // helper.setText(R.id.title_tv,homeMenu.getDesp());
    }
}
