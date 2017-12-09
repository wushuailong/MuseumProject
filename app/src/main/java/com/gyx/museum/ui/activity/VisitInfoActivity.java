package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.popupwindow.BwgVisitPopupwindow;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.utils.DateUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\3 0003.
 */

public class VisitInfoActivity extends BaseActivity {
    @BindView(R.id.vist_info_tv)
    TextView vistInfoTv;
    @BindView(R.id.date_tv)
    TextView dateTv;
    @BindView(R.id.vist_date_time)
    LinearLayout vistDateTime;
    @BindView(R.id.time_tv)
    TextView timeTv;
    @BindView(R.id.vist_time_lv)
    LinearLayout vistTimeLv;
    @BindView(R.id.make_btn)
    Button makeBtn;
    @BindView(R.id.root_lv)
    LinearLayout rootLv;
    BwgVisitPopupwindow bwgVisitPopupwindow;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_visit_info;
    }

    @Override
    protected void initViews() {
        initTitle(true,"参观预约");
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.vist_date_time, R.id.vist_time_lv, R.id.make_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vist_date_time:
                List<String> datelist = DateUtil.get7week();
                ActionSheetDialogNoTitle(datelist);
                break;
            case R.id.vist_time_lv:
               // ActionSheetDialogNoTitle();
                break;
            case R.id.make_btn:
                bwgVisitPopupwindow = new BwgVisitPopupwindow(mContext,onClick);
                bwgVisitPopupwindow.show(rootLv);
                break;
        }
    }
    public final View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //circleFragmentPresenter.onReward(mContext,userId,random);
            CommonUtil.showToast(mContext,"提交了");
            bwgVisitPopupwindow.dismiss();
        }
    };
    /**
     * 选择日报周报月报
     */
    private void ActionSheetDialogNoTitle(List<String> datelist) {
        final String[] stringItems = (String[])datelist.toArray(new String[datelist.size()]);;
        final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, null);
        dialog.isTitleShow(false).show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dateTv.setText(stringItems[position]);
                dialog.dismiss();
            }
        });
    }
}
