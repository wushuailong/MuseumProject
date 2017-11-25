package com.gyx.museum.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.utils.CommonUtil;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\25 0025.
 */

public class ZxingActivity extends BaseActivity implements QRCodeView.Delegate, View.OnTouchListener {
    public static final int STYLE_ALL = 0;
    public static final String STYLE = "zxing_style";
    public static final int STYLE_TEXT = 1;
    public static final int STYLE_WEB = 2;
    public static final int STYLE_DOWNLOAD = 3;
    public static final int STYLE_IMG = 4;
    public final static int mMessageFlag = 0x1110;
    @BindView(R.id.zxingview)
    ZXingView mZxingview;
    @BindView(R.id.FAB_left_zxingstart)
    FloatingActionButton FABLeftZxingstart;
    public int mZxingStyle;
    public AlertDialog.Builder mDialogBuilder;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mZxingview.showScanRect();

            switch (msg.what) {
                case mMessageFlag:
                    String result = (String) msg.obj;
                    if (TextUtils.isEmpty(result)) {
                        Toast.makeText(ZxingActivity.this, "未发现二维码", Toast.LENGTH_SHORT).show();
                    } else
                        showSuccessDialog(result);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_zxing;
    }

    @Override
    protected void initViews() {
        getStyle();
        initZxingView();
        FABLeftZxingstart.setOnTouchListener(this);
    }
    private void initZxingView() {
        mZxingview.setDelegate(this);
        mZxingview.startSpot();
    }
    private void getStyle() {
        Intent intent = getIntent();
        mZxingStyle = intent.getIntExtra(STYLE, 0);
    }
    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.e("zxing",result);
        showSuccessDialog(result);
        vibrate();
    }
    /**
     * 震动手机
     */
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
    @Override
    public void onScanQRCodeOpenCameraError() {
        Logger.e("打开相机出错");
    }
    @Override
    protected void onStart() {
        super.onStart();
        mZxingview.startCamera();
        mZxingview.showScanRect();
    }

    @Override
    protected void onStop() {
        mZxingview.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZxingview.onDestroy();
        super.onDestroy();
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mZxingview.openFlashlight();
                break;
            case MotionEvent.ACTION_UP:
                mZxingview.closeFlashlight();
                break;
            default:

                break;
        }
        return false;
    }

    RadioGroup radioGroup;
    public void showSuccessDialog(final String result) {
        Log.e("zxing",result);
        mZxingview.stopSpot();
        mDialogBuilder = new AlertDialog.Builder(this);
        mDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mZxingview.startSpot();
            }
        });
        CommonUtil.showToast(this,result);
       /* if (mZxingStyle == STYLE_ALL) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.selectspot_dialog_zxing, null);
            radioGroup = (RadioGroup) inflate.findViewById(R.id.radiogroup_dialog_zxing);
            radioGroup.check(R.id.rb_text);
            mDialogBuilder.setView(inflate);

        }
        mDialogBuilder.setTitle("扫取结果");
        mDialogBuilder.setMessage(result);

        View view = LayoutInflater.from(this).inflate(R.layout.headtitle_dialog_zxing, null);
        view.findViewById(R.id.copy_dialog_zxing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCopyTextToClipboard(result);
            }
        });
        mDialogBuilder.setCustomTitle(view);



        mDialogBuilder.setNegativeButton(R.string.cancel, null);
        mDialogBuilder.setPositiveButton(R.string.imtrue, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (mZxingStyle) {
                    case STYLE_ALL:
                       // actionAll(result,radioGroup);
                        break;
                    case STYLE_DOWNLOAD:
                        break;
                    case STYLE_IMG:
                       //actionImg(result);
                        break;
                    case STYLE_TEXT:
                       // actionText();
                        break;
                    case STYLE_WEB:
                        //actionWeb(result);
                        break;
                    default:
                        break;
                }
            }
        });

        mDialogBuilder.show();*/

    }

}
