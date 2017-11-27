package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.fragment.ExpInteractionFragment;
import com.gyx.museum.ui.fragment.HomeFragment;
import com.gyx.museum.ui.fragment.HomeFragment2;
import com.gyx.museum.ui.fragment.MineFragment;
import com.gyx.museum.ui.fragment.WisdomGuideFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\27 0027.
 */

public class MainActivity extends BaseActivity {
    HomeFragment2 homePageFragment;
    ExpInteractionFragment expInteractionFragment;
    WisdomGuideFragment wisdomGuideFragment;
    MineFragment mineFragment;
    @BindView(R.id.tab01_lv)
    RadioButton tab01Lv;
    @BindView(R.id.tab02_lv)
    RadioButton tab02Lv;
    @BindView(R.id.tab03_lv)
    RadioButton tab03Lv;
    @BindView(R.id.tab04_lv)
    RadioButton tab04Lv;

    @Override
    protected int attachLayoutRes() {
        return R.layout.actity_home;
    }

    @Override
    protected void initViews() {
        setSelect(0);
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    public void setSelect(int i) {
        resetImgs();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                if (homePageFragment == null) {
                    homePageFragment = new HomeFragment2();
                    transaction.add(R.id.id_content, homePageFragment);
                } else {
                    transaction.show(homePageFragment);
                }
                break;
            case 1:
                if (wisdomGuideFragment == null) {
                    wisdomGuideFragment = new WisdomGuideFragment();
                    transaction.add(R.id.id_content, wisdomGuideFragment);
                } else {
                    transaction.show(wisdomGuideFragment);
                }
                break;
            case 2:
                if (expInteractionFragment == null) {
                    expInteractionFragment = new ExpInteractionFragment();
                    transaction.add(R.id.id_content, expInteractionFragment);
                } else {
                    transaction.show(expInteractionFragment);
                }
                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.id_content, mineFragment);
                } else {   //
                    transaction.show(mineFragment);
                }
                break;

            default:
                break;
        }

        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
        if (wisdomGuideFragment != null) {
            transaction.hide(wisdomGuideFragment);
        }
        if (expInteractionFragment != null) {
            transaction.hide(expInteractionFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    /**
     * 切换图片至暗色
     */
    public void resetImgs() {
        //今天天气不错辅导费热熔
        //id_scenicpot_rdo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_main, 0, 0);
        // id_mine_rdo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_foot, 0, 0);
    }

    @OnClick({R.id.tab01_lv, R.id.tab02_lv, R.id.tab03_lv, R.id.tab04_lv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab01_lv:
                setSelect(0);
                break;
            case R.id.tab02_lv:
                setSelect(1);
                break;
            case R.id.tab03_lv:
                setSelect(2);
                break;
            case R.id.tab04_lv:
                setSelect(3);
                break;
        }
    }

}
