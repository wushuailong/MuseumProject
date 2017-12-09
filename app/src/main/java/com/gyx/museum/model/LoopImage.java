package com.gyx.museum.model;

/**
 * 作者： 关云秀 on 2017/3/7.
 * 描述：
 */
public class LoopImage {

    /**
     * id : 362
     * photouuid : 0
     * path : /zhihui/upload/1/1438787b-c010-/zhihui/upload/1/dd6281ef-97c3-48f7-9682-6bb5d19294cd.jpg
     */

    private int id;
    private String photouuid;
    private String path;
    private int res;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotouuid() {
        return photouuid;
    }

    public void setPhotouuid(String photouuid) {
        this.photouuid = photouuid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
