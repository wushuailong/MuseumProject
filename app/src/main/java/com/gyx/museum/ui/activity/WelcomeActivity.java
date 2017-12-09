package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.gyx.museum.R;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\30 0030.
 */

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        startMainOrGuide();
    }
    //首次启动开启导航页
    private void startMainOrGuide() {


        new Handler().postDelayed(new Runnable() {
            public void run() {
                /*boolean flag = BaseApplication.mSharedPrefUtil.getBoolean(SharedConstants.LOGINFLAG,false);
                if(flag){
                    loginPresenter.onLogin(BaseApplication.mSharedPrefUtil.getString(SharedConstants.PHONE,""),BaseApplication.mSharedPrefUtil.getString(SharedConstants.PASSWORD,""));
                }else{
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
                }*/
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
                finish();

            }
        }, 2000);
    }
}
