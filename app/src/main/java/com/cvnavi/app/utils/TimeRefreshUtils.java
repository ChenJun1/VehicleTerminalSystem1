package com.cvnavi.app.utils;

import android.text.TextUtils;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * CreatedTime:  2017/7/12 11:28
 * version: 1.0
 * Depict:
 */

public class TimeRefreshUtils {
    private static TimeRefreshUtils INSTANCE;

    private TimeRefreshUtils() {
    }

    public static TimeRefreshUtils getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (TimeRefreshUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TimeRefreshUtils();
                }
            }
        }
        return INSTANCE;
    }


    private String time;
    private TextView mTextView;
    private boolean flag = false;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(TextView textView) {
        mTextView = textView;
    }

    public void RefreshTime() {
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {

                while (flag) {
                    try {
                        if (!Thread.interrupted())
                            Thread.sleep(1000);
                    } catch (Exception ie) {
                        Thread.interrupted();
                        LogUtils.e("thread interrupted");
                    }
                    if (!TextUtils.isEmpty(getTime())) {
                        setTime(getTimeString(getTime()));
                        e.onNext(getTimeString(getTime()));
                    }
                }

            }
        }, BackpressureStrategy.ERROR);


        Subscriber<String> subscriber = new Subscriber<String>() {
            Subscription mSubscription;
            @Override
            public void onSubscribe(Subscription s) {
                mSubscription=s;
                s.request(1);
            }

            @Override
            public void onNext(String s) {
                if (getTextView() != null) {
                    getTextView().setText(s);
                    DateUtils.setTime(s);
                    mSubscription.request(1);
                }
            }

            @Override
            public void onError(Throwable t) {

                LogUtils.e(t.getMessage() + "TimeRefreshUtils-onError");
            }

            @Override
            public void onComplete() {
                LogUtils.d("TimeRefreshUtils-onComplete");
            }
        };
        flowable.subscribeOn(Schedulers.io()).
                unsubscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(subscriber);
    }

    /**
     * 取消
     */
    public void onCancel() {
        flag = false;
    }

    /**
     * 发送
     */
    public void onStart() {
        flag = true;
    }

    private String getTimeString(String time) {
        StringBuilder stringBuilder = new StringBuilder();
        String hhs = "00";
        String mms = "00";
        String sss = "00";
        int hh = getH(time);
        int mm = getM(time);
        int ss = getS(time) + 1;
        if (ss >= 60) {
            ss = 00;
            mm++;
        }
        if (mm >= 60) {
            mm = 00;
            hh++;
        }
        if (hh >= 24) {
            ss = 00;
            mm = 00;
            hh = 00;
        }

        if (hh < 10 && hh != -1) {
            hhs = "0" + String.valueOf(hh);
        } else {
            hhs = String.valueOf(hh);
        }

        stringBuilder.append(hhs + ":");

        if (mm < 10 && mm != -1) {
            mms = "0" + String.valueOf(mm);
        } else {
            mms = String.valueOf(mm);
        }
        stringBuilder.append(mms + ":");

        if (ss < 10 && ss != -1) {
            sss = "0" + String.valueOf(ss);
        } else {
            sss = String.valueOf(ss);
        }
        stringBuilder.append(sss);
        return stringBuilder.toString();
    }

    private int getH(String time) {
        if (TextUtils.isEmpty(time))
            return -1;

        String[] split = time.split(":");
        if (split.length <= 0)
            return -1;

        int hh = 0;
        try {
            hh = Integer.valueOf(split[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hh;
    }

    private int getM(String time) {
        if (TextUtils.isEmpty(time))
            return -1;

        String[] split = time.split(":");
        if (split.length <= 0)
            return -1;

        int mm = 0;
        try {
            mm = Integer.valueOf(split[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mm;
    }

    private int getS(String time) {
        if (TextUtils.isEmpty(time))
            return -1;

        String[] split = time.split(":");
        if (split.length <= 0)
            return -1;

        int ss = 0;
        try {
            ss = Integer.valueOf(split[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ss;
    }

    /**
     * 对比两个时间的差
     *
     * @param time1
     * @param time2
     * @return
     */
    public boolean comparisonTime(String time1, CharSequence time2) {
        if (TextUtils.isEmpty(time1) || TextUtils.isEmpty(time2)) {
            return true;
        }
        String timeStr = time2.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long parse1;
        long parse2;
        long i = 0;
        try {
            parse1 = sdf.parse(time1).getTime();
            parse2 = sdf.parse(timeStr).getTime();
            i = Math.abs(parse1 - parse2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return i > 3000;
    }
}
