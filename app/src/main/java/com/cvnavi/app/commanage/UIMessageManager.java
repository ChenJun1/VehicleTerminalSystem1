package com.cvnavi.app.commanage;

import android.serialport.api.SerialPortDataHandler;
import android.serialport.api.SerialPortInterface;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.util.Arrays;

/**
 * Created by zww on 2017/7/10.
 */

public class UIMessageManager implements SerialPortInterface {
    private static UIMessageManager uiMessageManager;
    private SerialPortDataHandler commManager;

    @Override
    public void start() {

    }

    @Override
    public void send(byte[] sendData) {
        if(sendData!=null) {
            commManager = SerialPortDataHandler.getInstance();
            commManager.send(sendData);
            LogUtils.i("协议发送----"+ Arrays.toString(TextTransformationUtils.bytesToHexStrings
                    (sendData)));
        }
    }

    @Override
    public byte[] receive() {
        return commManager.receive();
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isRun() {
        return commManager.isRun();
    }


    public static UIMessageManager getInstance() {
        if (uiMessageManager == null) {
            synchronized (UIMessageManager.class) {
                if (uiMessageManager == null) {
                    uiMessageManager = new UIMessageManager();
                }
            }
        }
        return uiMessageManager;
    }

}
