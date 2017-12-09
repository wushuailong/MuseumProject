package com.gyx.museum.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/1 0001.
 *
 *  这个bean是使用插件GsonFormat生成的
 */
public class ImageBean implements Serializable {

    /**
     * boardid : comment_bbs
     * clkNum : 0
     * digest : 不朽的奥黛丽·赫本
     * docid : BN1OU51M9001U51N
     * downTimes : 217
     * img : http://easyread.ph.126.net/c8CNR5I6tGFhyQz8z3xkUw==/7917098346989689582.jpg
     * imgType : 0
     * imgsrc : http://easyread.ph.126.net/c8CNR5I6tGFhyQz8z3xkUw==/7917098346989689582.jpg
     * picCount : 0
     * pixel : 700*757
     * program : HY
     * recType : 0
     * replyCount : 5
     * replyid : BN1OU51M9001U51N
     * source : 堆糖网
     * title : 不朽的奥黛丽·赫本
     * upTimes : 909
     */


    private String source;
    private String title;
    private int upTimes;
    private int resource;
    private String code;
    private int width;
    private int height;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpTimes() {
        return upTimes;
    }

    public void setUpTimes(int upTimes) {
        this.upTimes = upTimes;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
