package com.gyx.museum.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.utils.CountDownButtonHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\30 0030.
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.yaz_btv)
    TextView yzmTv;
    @BindView(R.id.yzm_et)
    EditText yzmEt;
    @BindView(R.id.pass_et)
    EditText passEt;
    @BindView(R.id.con_pass_et)
    EditText conPassEt;
    @BindView(R.id.login_tv)
    TextView loginTv;
    @BindView(R.id.forget_tv)
    TextView forgetTv;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/hanziti.ttf");
        passEt.setTypeface(typeface);
        passEt.setTransformationMethod(new PasswordTransformationMethod());
        conPassEt.setTypeface(typeface);
        conPassEt.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.yaz_btv, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yaz_btv:
                yzmBtn();
                break;
            case R.id.login_btn:
                register();
                break;
        }
    }
    public void register(){
        String phone = phoneEt.getText().toString();
        String yzm = yzmEt.getText().toString();
        String pass = passEt.getText().toString();
        String conpass = conPassEt.getText().toString();
        if(TextUtils.isEmpty(phone)){
            CommonUtil.showToast(mContext,"手机号不能为空");
            return;
        }
        if(TextUtils.isEmpty(yzm)){
            CommonUtil.showToast(mContext,"验证码不能为空");
            return;
        }
        if(TextUtils.isEmpty(pass)){
            CommonUtil.showToast(mContext,"密码不能为空");
            return;
        }
        if(TextUtils.isEmpty(conpass)){
            CommonUtil.showToast(mContext,"请再次输入密码");
            return;
        }

    }
    public void yzmBtn(){
            String phone = phoneEt.getText().toString();
            if(TextUtils.isEmpty(phone)){
                CommonUtil.showToast(mContext,"手机号不能为空");
                return;
            }
            CountDownButtonHelper helper = new CountDownButtonHelper(yzmTv,"倒计时",60,1);

            helper.setOnFinishListener(new CountDownButtonHelper.OnFinishListener() {
                @Override
                public void finish() {
                    // Toast.makeText(RegisterActivity.this,"倒计时结束",Toast.LENGTH_SHORT).show();
                    yzmTv.setText("再次获取");
                }
            });
            helper.start();
         }


}
