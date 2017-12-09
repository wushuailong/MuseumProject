package com.opencv.wsl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.gyx.museum.R;


/**
 * Created by Administrator on 2017\12\7 0007.
 */

public class MainActivity extends Activity{
    private static final String TAG = "MainActivity";

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    ///为了使照片竖直显示
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }


    private String[] mNames = {"万磁王", "恩佐斯", "加拉克苏斯大王", "死亡之翼", "伊兰尼库斯"};
    private int[] mImgs = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e};
    private final static int IMG_RECOGNITION = 0;
    private ImageView iv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  iv = (ImageView) findViewById(R.id.id_iv);
        findViewById(R.id.id_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImgRecognitionActivity.class);
                startActivityForResult(intent, IMG_RECOGNITION);
            }
        });*/


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMG_RECOGNITION) {
            int data2 = data.getIntExtra("data", -1);
            Toast.makeText(this, "看到的是" + mNames[data2], Toast.LENGTH_LONG).show();
            iv.setImageResource(mImgs[data2]);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
