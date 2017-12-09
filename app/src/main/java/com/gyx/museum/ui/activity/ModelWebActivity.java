package com.gyx.museum.ui.activity;

import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

/**
 * Created by Administrator on 2017\12\9 0009.
 */

public class ModelWebActivity extends BaseActivity {
    private String[] mNames = {"万磁王", "恩佐斯", "加拉克苏斯大王", "死亡之翼", "伊兰尼库斯","晋侯鸟尊"};

    private int count = 0;
    private TextView nameTV;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_modelweb;
    }

    @Override
    protected void initViews() {
        count = getIntent().getIntExtra("int_data", 0);
        nameTV = (TextView)this.findViewById(R.id.id_name);
    }

    @Override
    protected void updateViews() {
        nameTV.setText(mNames[count]+"");

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
