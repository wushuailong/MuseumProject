package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.opencv.wsl.ImgRecognitionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：体验互动 ar
 * Created by 关云秀 on 2017\12\7 0007.
 */

public class TyhdArActivity extends BaseActivity {
    @BindView(R.id.ar_sao_img)
    ImageView arSaoImg;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_tyhd_ar;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick(R.id.ar_sao_img)
    public void onClick() {
        Intent intent = new Intent(TyhdArActivity.this, ImgRecognitionActivity.class);
        startActivity(intent);
    }
}
