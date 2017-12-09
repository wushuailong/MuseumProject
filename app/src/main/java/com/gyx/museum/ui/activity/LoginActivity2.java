package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gyx.museum.*;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.contract.LoginContract;
import com.gyx.museum.model.User;
import com.gyx.museum.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\30 0030.
 */

public class LoginActivity2 extends BaseActivity<LoginPresenter> implements LoginContract.LoginView{
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.pass_editText)
    EditText passEditText;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.reg_tv)
    TextView regTv;
    @BindView(R.id.forget_tv)
    TextView forgetTv;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login2;
    }

    @Override
    protected void initViews() {
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/hanziti.ttf");
        passEditText.setTypeface(typeface);
        passEditText.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }

    @OnClick({R.id.login_btn, R.id.reg_tv, R.id.forget_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                mPresenter.onLogin();
                startActivity(new Intent(mContext, MainActivity.class));
                break;
            case R.id.reg_tv:
                startActivity(new Intent(mContext,RegisterActivity.class));
                break;
            case R.id.forget_tv:
                startActivity(new Intent(mContext,ForgetPassActivity.class));
                break;
        }
    }

    @Override
    public void showToast() {

    }

    @Override
    public void getData(User user) {

    }
}
