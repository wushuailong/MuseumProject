package com.gyx.museum.popupwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gyx.museum.R;

/**
 * 作者： 关云秀 on 2017/1/17.
 * 描述：
 */
public class BwgVisitPopupwindow extends PopupWindow implements View.OnClickListener{
    PopupWindow popupWindow;
    EditText nameEt,idcardEt,phoneEt;
    Button subBtn;
    LinearLayout idRootLv;
    private ImageView imageView;
    public BwgVisitPopupwindow(Context context ,View.OnClickListener onClickListener) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewContent = inflater.inflate(R.layout.activity_bwg_popupwindow, null);

        idRootLv = (LinearLayout)viewContent.findViewById(R.id.id_root_lv);
        nameEt = (EditText)viewContent.findViewById(R.id.name_et);
        idcardEt = (EditText)viewContent.findViewById(R.id.idcard_et);
        phoneEt = (EditText)viewContent.findViewById(R.id.phone_et);
        subBtn = (Button)viewContent.findViewById(R.id.submit_btn);
        //  imageView = (ImageView)viewContent.findViewById(R.id.anim_image);
        popupWindow = new PopupWindow(viewContent, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.popupDialog);


        idRootLv.setOnClickListener(this);
        subBtn.setOnClickListener(onClickListener);
    }


    public void show(View view) {
        popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public void dismiss() {
        popupWindow.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_root_lv:
                dismiss();
                idRootLv.clearAnimation();
                break;
        }
    }
}
