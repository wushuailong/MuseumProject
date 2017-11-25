package com.gyx.museum.contract;

import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.base.BaseView;
import com.gyx.museum.model.User;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\25 0025.
 */

public interface LoginContract{
    public interface LoginView extends BaseView<User>{

    }
    public interface LoginPresenter extends BasePresenter<LoginView>{
        void onLogin();
    }
}
