package com.gyx.museum.presenter;

import com.gyx.museum.contract.LoginContract;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\25 0025.
 */

public class LoginPresenter implements LoginContract.LoginPresenter {

    LoginContract.LoginView view;
    public LoginPresenter(LoginContract.LoginView view) {
        this.view = view;
    }

    @Override
    public void onLogin() {
        view.showToast();

    }


    @Override
    public void detachView() {
        view = null ;
    }
}
