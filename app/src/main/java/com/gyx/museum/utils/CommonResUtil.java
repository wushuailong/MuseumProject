package com.gyx.museum.utils;

import com.gyx.museum.R;
import com.gyx.museum.model.HomeMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\30 0030.
 */

public class CommonResUtil {
    public static List<HomeMenu> getMenuList(){
        List<HomeMenu> list = new ArrayList<>();
        list.add(new HomeMenu(R.mipmap.home_bwg_icon,"博物馆"));
        list.add(new HomeMenu(R.mipmap.home_gc_icon,"馆藏"));
        list.add(new HomeMenu(R.mipmap.home_zl_icon,"展览"));
        list.add(new HomeMenu(R.mipmap.home_hd_icon,"活动"));
        return  list;
    }
}
