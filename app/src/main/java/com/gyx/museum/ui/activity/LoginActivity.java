package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.activity.CaptureActivity;
import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.contract.LoginContract;
import com.gyx.museum.model.User;
import com.gyx.museum.presenter.LoginPresenter;
import com.gyx.museum.utils.CommonUtil;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\25 0025.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView{
    @BindView(R.id.login_btn)
    Button loginBtn;
    //打开扫描界面请求码
    private int REQUEST_CODE = 0x01;
    //扫描成功返回码
    private int RESULT_OK = 0xA1;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }


    @OnClick(R.id.login_btn)
    public void onClick() {
        mPresenter.onLogin();
        //ZxingActivityPermissionsDispatcher.startSpotWithCheck(this,ZxingActivity.STYLE_ALL);
        Intent intent = new Intent(LoginActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
    @Override
    public void showToast() {

        Toast.makeText(this,"点击 了",Toast.LENGTH_SHORT).show();
        Logger.i("sss");
    }
    @Override
    public void getData(User user) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");
            //将扫描出的信息显示出来
            //qrCodeText.setText(scanResult);
            CommonUtil.showToast(this,scanResult);
        }
    }
}
