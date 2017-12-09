package com.gyx.museum.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\7 0007.
 */

public class MyUpdatePassActivity extends BaseActivity {
    @BindView(R.id.old_pass_et)
    EditText oldPassEt;
    @BindView(R.id.new_pass_et)
    EditText newPassEt;
    @BindView(R.id.sure_pass_et)
    EditText surePassEt;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_update;
    }

    @Override
    protected void initViews() {
        initTitle(true, "修改密码");
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/hanziti.ttf");
        oldPassEt.setTypeface(typeface);
        oldPassEt.setTransformationMethod(new PasswordTransformationMethod());
        newPassEt.setTypeface(typeface);
        newPassEt.setTransformationMethod(new PasswordTransformationMethod());
        surePassEt.setTypeface(typeface);
        surePassEt.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick(R.id.login_btn)
    public void onClick() {
    }
}
