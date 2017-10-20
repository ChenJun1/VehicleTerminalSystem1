package com.cvnavi.app.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import com.cvnavi.app.BaseApp;

import java.util.List;

/**
 *  Don't used
 * Created by zww on 2016/5/11.
 */
public class ServiceUtils {

    public static boolean checkisRunning(Class<?> clazz) {
        ActivityManager actManager = (ActivityManager)
                BaseApp.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = actManager.getRunningServices(1000);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo.service.getClassName().equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean changeState(Class<?> clazz) {

        Intent intent = new Intent(BaseApp.getContext(), clazz);
        ActivityManager actManager = (ActivityManager)
                BaseApp.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = actManager.getRunningServices(1000);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo.service.getClassName().equals(clazz.getName())) {
                BaseApp.getContext().stopService(intent);
                return false;
            }
        }
        BaseApp.getContext().startService(intent);
        return true;
    }

    public static boolean stopService(Class<?> clazz){
        Intent intent = new Intent(BaseApp.getContext(), clazz);
        ActivityManager actManager = (ActivityManager)
                BaseApp.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = actManager.getRunningServices(1000);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo.service.getClassName().equals(clazz.getName())) {
                BaseApp.getContext().stopService(intent);
                return true;
            }
        }
        return false;
    }



}
