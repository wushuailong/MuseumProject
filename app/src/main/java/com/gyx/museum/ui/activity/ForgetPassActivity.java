package com.gyx.museum.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\30 0030.
 */

public class ForgetPassActivity extends BaseActivity {
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.yaz_btv)
    TextView yzmTv;
    @BindView(R.id.yzm_et)
    EditText yzmEt;
    @BindView(R.id.user_et)
    EditText userEt;
    @BindView(R.id.pass_et)
    EditText passEt;
    @BindView(R.id.login_tv)
    TextView loginTv;
    @BindView(R.id.forget_tv)
    TextView forgetTv;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_forgetpass;
    }

    @Override
    protected void initViews() {
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/hanziti.ttf");
        passEt.setTypeface(typeface);
        passEt.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.yaz_btv, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yaz_btv:
                break;
            case R.id.login_btn:
                break;
        }
    }
}
