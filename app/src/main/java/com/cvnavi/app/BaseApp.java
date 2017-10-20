package com.cvnavi.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/4 09:48
 * version: 1.0
 * Depict:
 */

public class BaseApp extends Application {

    // 赋值为－1，在欢迎界面改为0，如果被强杀，application重新初始化，在父类Activity判断该常量的值。
    public static int isLife=-1;
    private static Context sContext;

    private static int count=0;

    private static BaseApp app;

    private static int isLogin;

    private static float sDensity;

    public static Context getContext() {
        return sContext;
    }

    private static ArrayList<Activity> pageList = new ArrayList<>();

    public static BaseApp getInstance() {
        return app;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        BaseApp.count = count;
    }

    public static int getIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(int isLogin) {
        BaseApp.isLogin = isLogin;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String currentProcessName = getCurrentProcessName();
        LogUtils.i("onCreate currentProcessName=" + currentProcessName);
        if (getPackageName().equals(currentProcessName)) {
            registerActivityLifecycleCallbacks(new ActivityLifeCallback() {

                @Override
                public void onActivityStarted(Activity activity) {
                    count++;
                }

                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    pageList.add(activity);
                }

                @Override
                public void onActivityStopped(Activity activity) {
                    count--;
                }

                @Override
                public void onActivityDestroyed(Activity activity) {
                    pageList.remove(activity);
                }
            });
        }
        app = this;
        sContext=getApplicationContext();
        CrashHandler.getInstance().init(this);
        sDensity = sContext.getResources().getDisplayMetrics().density;

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
    }

    private String getCurrentProcessName() {
        String currentProcessName = "";
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                currentProcessName = processInfo.processName;
                break;
            }
        }
        return currentProcessName;
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public static void finishActivity() {
        for (Activity activity : pageList) {
            if (null != activity) {
                activity.finish();
            }
        }
        pageList.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
