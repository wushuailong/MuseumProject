package com.gyx.museum.model;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\27 0027.
 */

public class HomeMenu {
    private int image;
    private String desp;

    public HomeMenu(int image, String desp) {
        this.image = image;
        this.desp = desp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }
}
