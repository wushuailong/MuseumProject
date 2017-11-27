package com.gyx.museum.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\17 0017.
 */

public class CommonUtil {
    private static Toast toast;

    public static void showToast(Context context,
                                 String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
    public static List<String> getMenuActive(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("sss");
        }
        return  list;
    }
}
