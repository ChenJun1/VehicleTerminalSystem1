package com.cvnavi.app.utils;

import android.widget.TextView;
import android.widget.Toast;

import com.cvnavi.app.BaseApp;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zww on 2017/7/13.
 */

public class ToastUtils {
    private static Toast toast, timetoast;
    private static String oldMsg;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void imitShowToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(BaseApp.getContext(), string, Toast.LENGTH_SHORT);
        } else {
            toast.setText(string);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void imitShowToast(int StringRes) {
        imitShowToast(getString(StringRes));
    }

    public static void ShowToastSmooth(String string) {
        Toast.makeText(BaseApp.getContext(), string, Toast.LENGTH_SHORT).show();
    }

    public static void ShowToastSmooth(int StringRes) {
        Toast.makeText(BaseApp.getContext(), StringRes, Toast.LENGTH_SHORT).show();
    }

    public static void customTimeToast(String string, int time) {
        if (toast == null) {
            toast = Toast.makeText(BaseApp.getContext(), "", time);
        }
        toast.setText(string);
        toast.show();
    }

    public static void cancelToast() {
        if (toast == null) {
            toast = Toast.makeText(BaseApp.getContext(), "", Toast.LENGTH_SHORT);
        }
        toast.cancel();
    }

    public static void showToast(String s) {
        if (timetoast == null) {
            timetoast = Toast.makeText(BaseApp.getContext(), s, Toast.LENGTH_SHORT);
            timetoast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    timetoast.show();
                }
            } else {
                oldMsg = s;
                timetoast.setText(s);
                timetoast.show();
            }
        }
        oneTime = twoTime;
    }


    public static void showToast(int resId) {
        showToast(getString(resId));
    }

    public static void showTimeToast(String s,int time)
    {
        toast=Toast.makeText(BaseApp.getContext(), s, Toast.LENGTH_LONG);
        showMyToast(toast, time);
    }

    //string
    public static String getString(int id) {
        return BaseApp.getContext().getResources().getString(id);
    }

    private static void setToastSize()
    {
        TextView v = (TextView) timetoast.getView().findViewById(android.R.id.message);
        v.setTextSize(25);
    }

    private static void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }

}
