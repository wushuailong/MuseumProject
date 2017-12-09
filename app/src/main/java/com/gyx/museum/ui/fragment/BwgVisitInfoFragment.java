package com.gyx.museum.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.popupwindow.BwgVisitPopupwindow;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\3 0003.
 */

public class BwgVisitInfoFragment extends BaseFragment {
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
    private TimePickerView  pvCustomTime;
    BwgVisitPopupwindow bwgVisitPopupwindow;
    public static BwgVisitInfoFragment newInstance() {
        BwgVisitInfoFragment fragment = new BwgVisitInfoFragment();
        return fragment;
    }
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_visit_info;
    }

    @Override
    protected void initViews() {
        initTitle(true,"参观预约");
        initCustomTimePicker();
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

                pvCustomTime.show();  //显示开会时间
                break;
            case R.id.vist_time_lv:
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

    private void initCustomTimePicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(selectedDate.get(Calendar.YEAR)-1, selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH),selectedDate.get(Calendar.HOUR_OF_DAY), selectedDate.get(Calendar.MINUTE));
        Calendar endDate = Calendar.getInstance();
        endDate.set(selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(mContext, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                dateTv.setText(DateUtil.getTime(date)+"  星期"+DateUtil.getWeek(DateUtil.getTime(date)));

            }
        })
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年","月","日","时","分","秒")
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();
    }
}
