package com.cvnavi.app.service;

/**
 * Created by zww on 2017/7/10.
 */

import android.app.IntentService;
import android.content.Intent;
import android.serialport.api.SerialPortDataHandler;
import android.support.annotation.Nullable;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.commanage.RxMessageManager;

import java.io.IOException;

public class CommService extends IntentService {

    public CommService() {
        super("CommService");
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LogUtils.i("启动服务");
        SerialPortDataHandler serialPortDataHandler = SerialPortDataHandler.getInstance();
        try {
            serialPortDataHandler.start();
        } catch (IOException e) {
            LogUtils.i(" serialPort open failed........");
            e.printStackTrace();
        }
        RxMessageManager.getInstance(serialPortDataHandler).MessageSend();
        //可以省略，自动停止
        stopSelf();

    }



}
