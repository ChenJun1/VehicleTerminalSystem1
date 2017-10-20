package com.cvnavi.app.commanage;

import android.serialport.api.SerialPortDataHandler;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.BaseApp;
import com.cvnavi.app.utils.ToastUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/11 16:49
 * version: 1.0
 * Depict:
 */

public class RxMessageManager {
    private static final String TAG = "RxMessageManager";
    private SerialPortDataHandler mSerialPortDataHandler;
    private volatile static RxMessageManager mRxMessageManager;
    int cout=0;

    private RxMessageManager(SerialPortDataHandler serialPortDataHandler) {
        this.mSerialPortDataHandler = serialPortDataHandler;
    }

    public static RxMessageManager getInstance(SerialPortDataHandler serialPortDataHandler) {
        if (mRxMessageManager == null) {
            synchronized (RxMessageManager.class) {
                if (mRxMessageManager == null) {
                    mRxMessageManager = new RxMessageManager(serialPortDataHandler);
                }
            }
        }
        return mRxMessageManager;
    }

    public void MessageSend() {

        Flowable<byte[]> flowable = Flowable.create(new FlowableOnSubscribe<byte[]>() {
            @Override
            public void subscribe(FlowableEmitter<byte[]> e) throws Exception {
                while ((mSerialPortDataHandler.isRun())) {
                    byte[] msg = mSerialPortDataHandler.receive();
                    if (null != msg && msg.length > 0) {
                        //Todo 解析并发送通知ui
//                        LogUtils.i(e.isCancelled()+"flag-------");
                        LogUtils.i(e.requested()+"request-------");
                        e.onNext(msg);
                        cout=0;
                    } else {
                        ++cout;
                        try {
                            if (!Thread.interrupted())
                                Thread.sleep(1000);
                        } catch (Exception ie) {
                            Thread.interrupted();
                            LogUtils.e("thread interrupted");
                        }
                        if(cout>=5){
                            cout=0;
                            e.onNext(new byte[]{});
                        }
                    }
                }

            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io());

        Subscriber<byte[]> subscriber = new Subscriber<byte[]>() {
            Subscription mSubscription;
            @Override
            public void onSubscribe(Subscription s) {
                mSubscription=s;
                s.request(1);
            }

            @Override
            public void onNext(byte[] bytes) {
                LogUtils.d("Rx-OnNext");
                if(bytes.length==0&& BaseApp.getCount()>0){
                    //LogUtils.d("----onNextNULL");
                    ToastUtils.showToast("终端连接已断开...");
                }else{
                    HandleMessage.getMsg(bytes);
                }
                mSubscription.request(1);
            }

            @Override
            public void onError(Throwable t) {
                LogUtils.e(t.getMessage());
            }

            @Override
            public void onComplete() {
                LogUtils.d("onComplete");
            }
        };
        flowable.observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

}
