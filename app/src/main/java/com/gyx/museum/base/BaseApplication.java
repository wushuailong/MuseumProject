package com.gyx.museum.base;

import android.app.Activity;
import android.os.Environment;
import android.support.multidex.MultiDexApplication;
import android.util.Log;


import com.gyx.museum.config.Constants;
import com.gyx.museum.config.SharedConstants;
import com.gyx.museum.utils.DateUtil;
import com.gyx.museum.utils.SharedPrefUtil;
import com.gyx.museum.widget.FontsOverride;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\7 0007.
 */

public class BaseApplication extends MultiDexApplication implements
        Thread.UncaughtExceptionHandler {
    private static BaseApplication mApplication;
    public static List<Activity> activityList = new LinkedList<Activity>();
    public static SharedPrefUtil mSharedPrefUtil;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mSharedPrefUtil = new SharedPrefUtil(this, SharedConstants.sharersinfor);
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/PingFang Bold.ttf");
        //友盟
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        UMShareAPI.get(this);
        getUmConfig();
        //启动异常捕获线程
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);



    }
    public void getUmConfig(){
        PlatformConfig.setWeixin("111111","11111");
        PlatformConfig.setQQZone("111111","1111");
        PlatformConfig.setSinaWeibo("111111","1111","");
    }
    public static BaseApplication getInstance() {
        return mApplication;
    }

    public void removeActivity(Activity act, int index) {
        if (activityList != null && !activityList.isEmpty()) {
            activityList.remove(act);
        }
    }

    public void addActivity(Activity act) {
        if (activityList != null) {
            activityList.add(act);
        }
    }

    public List<Activity> getActivityList() {
        return activityList;
    }


    public static void removeActivity() {
        Log.i("activityList", activityList.size() + "***");
        //
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }


    //保存错误日志到本地文件夹
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (null == ex)
            return;

        setErrorInfor(thread, ex);
    }

    public void setErrorInfor(final Thread thread, final Throwable ex) {

        outLog(ex);
        if (null != defaultUncaughtExceptionHandler)
            defaultUncaughtExceptionHandler.uncaughtException(thread, ex);

    }

    //打印错误日志
    public void outLog(Throwable ex) {
        File sdFile = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
            sdFile = new File(sdCardDir, Constants.WORNGFILE);
            final int MAX_SIZE = 1 * 1024 * 1024; // 1M
            boolean append = true;
            if (sdFile.length() > MAX_SIZE) {
                append = false;
            }
            try {
                FileOutputStream fos = new FileOutputStream(sdFile, append);
                PrintWriter printWriter = new PrintWriter(fos);
                String bar = "----------------------------";
                printWriter.append(bar + DateUtil.curChinaFormatDate() + bar);//系統时间
                printWriter.append(bar + android.os.Build.MODEL + bar);//手机型号
                printWriter.append("\n");
                ex.printStackTrace(printWriter);
                printWriter.close();
                fos.close();  //关闭输出流

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
