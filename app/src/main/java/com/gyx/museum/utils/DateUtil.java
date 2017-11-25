package com.gyx.museum.utils;

import java.util.Calendar;
import java.util.Locale;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\17 0017.
 */

public class DateUtil {
    public static String curChinaFormatDate(){
        return new android.text.format.DateFormat().format("yyyy-MM-dd HH:mm:ss", Calendar.getInstance(Locale.CHINA)).toString();
    }
}
