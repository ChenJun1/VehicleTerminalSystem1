package com.cvnavi.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.serialport.api.SerialPortDataHandler;
import android.serialport.api.SerialPortManager;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zww on 2017/7/12.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private static CrashHandler INSTANCE = new CrashHandler();

    private Context mContext;
    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<>();

    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private CrashHandler() {
    }


    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //没有异常信息则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                //给予handleException处理时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e(TAG, "error : ", e);
            }
        }
    }


    /**
     * 自定义错误处理,收集错误信息 发送错误报告等
     *
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        SerialPortDataHandler.getInstance().close();
        LogUtils.i("-----------------------崩溃");


        //收集设备参数信息
//        collectDeviceInfo(mContext);
        //保存日志文件
//        saveCrashInfo2File(ex);

//        BaseApp.finishActivity();

        return false;
    }

    /**
     * 收集设备参数信息
     */
    public void collectDeviceInfo(Context ctx) {
        //获取版本信息
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "an error occured when collect package info", e);
        }
        //反射获取硬件信息
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
                Log.d(TAG, field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                Log.e(TAG, "an error occured when collect crash info", e);
            }
        }
    }

}
