package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.activity.MyCollectActivity;
import com.gyx.museum.ui.activity.MySysSetActivity;
import com.gyx.museum.utils.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 内容：我的
 * Created by 关云秀 on 2017\11\27 0027.
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.photo_img)
    ImageView photoImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.my_buy_lv)
    LinearLayout myBuyLv;
    @BindView(R.id.my_yuyue_lv)
    LinearLayout myYuyueLv;
    @BindView(R.id.my_love_lv)
    LinearLayout myLoveLv;
    @BindView(R.id.my_set_lv)
    LinearLayout mySetLv;
    @BindView(R.id.my_del_lv)
    LinearLayout myDelLv;
    @BindView(R.id.my_about_lv)
    LinearLayout myAboutLv;
    @BindView(R.id.my_fuwu_lv)
    LinearLayout myFuwuLv;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        Glide.with(this).load(R.mipmap.my_photo).bitmapTransform(new GlideCircleTransform(mContext)).into(photoImg);
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }



    @OnClick({R.id.photo_img, R.id.my_buy_lv, R.id.my_yuyue_lv, R.id.my_love_lv, R.id.my_set_lv, R.id.my_del_lv, R.id.my_about_lv, R.id.my_fuwu_lv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.photo_img:
                break;
            case R.id.my_buy_lv:
                break;
            case R.id.my_yuyue_lv:
                break;
            case R.id.my_love_lv:
                startActivity(new Intent(mContext, MyCollectActivity.class));
                break;
            case R.id.my_set_lv:
                startActivity(new Intent(mContext, MySysSetActivity.class));
                break;
            case R.id.my_del_lv:
                break;
            case R.id.my_about_lv:
                break;
            case R.id.my_fuwu_lv:
                break;
        }
    }
}
