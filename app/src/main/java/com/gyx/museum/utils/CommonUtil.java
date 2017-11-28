package com.gyx.museum.utils;

import android.content.Context;
import android.widget.Toast;

import com.gyx.museum.model.ImageBean;

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
    public static List<ImageBean> getMenuActive(){
        List<ImageBean> list = new ArrayList<>();

            ImageBean imageBean = new ImageBean();
            imageBean.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204921&di=438e1f0108f3f14d2a5746ea3e5a9790&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd000baa1cd11728b83904125c2fcc3cec3fd2c7c.jpg");

            list.add(imageBean);
        ImageBean imageBean2 = new ImageBean();
        imageBean2.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204921&di=d2f03135355c6197d91d7981d5c0e6e0&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fb7003af33a87e9504696277f1a385343fbf2b424.jpg");
        list.add(imageBean2);
        ImageBean imageBean3 = new ImageBean();
        imageBean3.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204920&di=5749db5027b1e53db13d27bf6b9d654c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7dd98d1001e939010ef3fb2c71ec54e736d1962a.jpg");

        list.add(imageBean3);
        ImageBean imageBean4 = new ImageBean();
        imageBean4.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204921&di=438e1f0108f3f14d2a5746ea3e5a9790&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd000baa1cd11728b83904125c2fcc3cec3fd2c7c.jpg");

        list.add(imageBean4);
        ImageBean imageBean5 = new ImageBean();
        imageBean5.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204920&di=dbdd3da35c9f7cb3dd546e4144cd9898&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b8ef2f0d600d162d9f3d3c9d9.jpg");
        list.add(imageBean5);


        ImageBean imageBean6 = new ImageBean();
        imageBean6.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847731943&di=06848c8e82427dba5ca79cb17037673b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F96dda144ad345982abe99bb406f431adcbef84b0.jpg");
        list.add(imageBean6);

        ImageBean imageBean7 = new ImageBean();
        imageBean7.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847731942&di=c2aa611c30f51499ff8a2f13477ad319&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D104b5114798da9775a228e68d838926c%2F3812b31bb051f819dcc3916dd0b44aed2e73e737.jpg");
        list.add(imageBean7);

        ImageBean imageBean8 = new ImageBean();
        imageBean8.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847731942&di=bbec1d828b03a848ff08f77b159a6c2e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F267f9e2f07082838237f3a0ab299a9014c08f1ba.jpg");
        list.add(imageBean8);

        ImageBean imageBean9 = new ImageBean();
        imageBean9.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847731941&di=cd30d1aa7dfaa82aee2708bdb82c74d8&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F5481242ae97a1.jpg");
        list.add(imageBean9);

        ImageBean imageBean10 = new ImageBean();
        imageBean10.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204921&di=d2f03135355c6197d91d7981d5c0e6e0&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fb7003af33a87e9504696277f1a385343fbf2b424.jpg");
        list.add(imageBean10);
        ImageBean imageBean11 = new ImageBean();
        imageBean11.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204920&di=5749db5027b1e53db13d27bf6b9d654c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7dd98d1001e939010ef3fb2c71ec54e736d1962a.jpg");

        list.add(imageBean11);
        ImageBean imageBean12 = new ImageBean();
        imageBean12.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204921&di=438e1f0108f3f14d2a5746ea3e5a9790&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd000baa1cd11728b83904125c2fcc3cec3fd2c7c.jpg");

        list.add(imageBean12);
        ImageBean imageBean13 = new ImageBean();
        imageBean13.setSource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511847204920&di=dbdd3da35c9f7cb3dd546e4144cd9898&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b8ef2f0d600d162d9f3d3c9d9.jpg");
        list.add(imageBean13);
        return  list;
    }
}
