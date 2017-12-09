package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：博物馆详细内容
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class ZldetailsActivity extends BaseActivity {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.love_tv)
    TextView loveTv;
    @BindView(R.id.love_img)
    ImageView loveImg;
    @BindView(R.id.share_img)
    ImageView shareImg;
    @BindView(R.id.share_tv)
    TextView shareTv;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.time_tv)
    TextView timeTv;
    @BindView(R.id.address_tv)
    TextView addressTv;
    @BindView(R.id.content_tv)
    TextView contentTv;
    private String flag;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_zldetails;
    }

    @Override
    protected void initViews() {

        flag = getIntent().getStringExtra("hdFlag");
        if(TextUtils.isEmpty(flag)) {
            initTitle(true, "展览");
        }else{
            if (flag.equals("1")) {
                initTitle(true, "活动");
            }
        }
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.love_tv,R.id.love_img, R.id.share_tv,R.id.share_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.love_tv:
                loveImg.setImageResource(R.mipmap.love_true);
                loveImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.collect_anim));
                break;
            case R.id.love_img:
                loveImg.setImageResource(R.mipmap.love_true);
                loveImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.collect_anim));
                break;
            case R.id.share_tv:
                shareImg.setImageResource(R.mipmap.share_true);
                shareImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.collect_anim));
                break;
            case R.id.share_img:
                shareImg.setImageResource(R.mipmap.share_true);
                shareImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.collect_anim));
                break;
        }
    }
}
