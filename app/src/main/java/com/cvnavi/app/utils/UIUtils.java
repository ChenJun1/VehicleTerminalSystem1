package com.cvnavi.app.utils;

import android.graphics.drawable.Drawable;

import com.cvnavi.app.BaseApp;

/**
 * Created by zww on 2017/7/24.
 * 界面和资源相关工具
 */

public class UIUtils {

    //string
    public static String getString(int id) {
        return BaseApp.getContext().getResources().getString(id);
    }

    //dimens
    public static float getDimens(int id) {
        return BaseApp.getContext().getResources().getDimension(id);
    }

    //drawable
    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(int id) {
        return BaseApp.getContext().getResources().getDrawable(id);
    }

    //drawable
    @SuppressWarnings("deprecation")
    public static int getColor(int id) {
        return BaseApp.getContext().getResources().getColor(id);
    }

    //stringArray
    public static String[] getStringArray(int id) {
        return BaseApp.getContext().getResources().getStringArray(id);
    }

    public static float getDimensPixel(int id) {
        return BaseApp.getContext().getResources().getDimensionPixelOffset(id);
    }
}
