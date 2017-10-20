package com.cvnavi.app.bean;

/**
 * 作者：wangshy on 17/10/18 17:23
 */

public class MoreFragmentBean {
    public MoreFragmentBean(int drawableTop, String name) {
        this.drawableTop = drawableTop;
        this.name = name;
    }

    public MoreFragmentBean(int drawableTop, int drawableTop1, String name) {
        this.drawableTop = drawableTop;
        this.drawableTop1 = drawableTop1;
        this.name = name;
    }

    public int getDrawableTop() {
        return drawableTop;
    }

    public void setDrawableTop(int drawableTop) {
        this.drawableTop = drawableTop;
    }

    private int drawableTop;

    public int getDrawableTop1() {
        return drawableTop1;
    }

    public void setDrawableTop1(int drawableTop1) {
        this.drawableTop1 = drawableTop1;
    }

    private int drawableTop1;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MoreFragmentBean{" +
                "drawableTop='" + drawableTop + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
