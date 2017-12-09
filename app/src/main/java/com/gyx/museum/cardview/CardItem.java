package com.gyx.museum.cardview;


public class CardItem {

    private int mImageResource;
    private int titleResource;
    public int getmImageResource() {
        return mImageResource;
    }

    public int getTitleResource() {
        return titleResource;
    }

    public CardItem(int mImageResource, int titleResource) {
            this.mImageResource = mImageResource;
        this.titleResource = titleResource;

    }

}
