package com.cvnavi.app.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;

import com.cvnavi.app.R;
import com.cvnavi.app.ui.customize.SweetAlert.SweetAlertDialog;

public class DialogUtils {

    private static ProgressDialog progressDialog;
    private static SweetAlertDialog mSweetAlertDialog=null;

    /**
     * <p>
     * 描 述 ：按返回键返回关闭页面的确认提示框
     * <p>
     * ============================================================
     **/
    public static void getBackDialog(final Activity activity, String title, String messege) {
        Builder builder = new Builder(activity);

        builder.setTitle(title);
        builder.setMessage(messege);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                activity.finish();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    /**
     * 描 述 ：按返回键跳转到新Activity的确认提示框
     * ============================================================
     **/
    public static <T> void getGoActivityDialog(final Activity activity, final Class<T> target, String title, String messege) {
        Builder builder = new Builder(activity);
        builder.setTitle(title);
        builder.setMessage(messege);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent intent = new Intent(activity, target);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.nextact_movein, R.anim.nextact_moveout);
                activity.finish();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    /**
     * 作 者 : YX_Sun 创建日期 ： 2015-12-23 上午11:05:19
     * <p>
     * 描 述 ：获取信息提示对话框
     * <p>
     * ============================================================
     **/
    public static void showInfoDialog(Activity activity, String message) {
        showInfoDialog(activity, message, "提示", null, null);
    }

    public static void showInfoDialog(@NonNull Activity activity, @NonNull String message,
                                      @NonNull String titleStr, String positiveStr,
                                      DialogInterface.OnClickListener onPositiveClick) {
        Builder localBuilder = new Builder(activity);
        localBuilder.setTitle(titleStr);
        localBuilder.setMessage(message);
        if (TextUtils.isEmpty(positiveStr))
            positiveStr = UIUtils.getString(R.string.sure);
        if (onPositiveClick == null)
            onPositiveClick = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            };
        localBuilder.setPositiveButton(positiveStr, onPositiveClick);
        localBuilder.show();
    }

    /**
     * 显示确认提示框
     *
     * @param activity
     * @param message
     * @param onPositiveClick 点击确定后的事件
     */
    public static void showConfirmDialog(Activity activity, String message,
                                         @NonNull DialogInterface.OnClickListener onPositiveClick) {
        showConfirmDialog(activity, message, "提示", null, onPositiveClick, null);
    }

    public static void showConfirmDialog(@NonNull Activity activity, @NonNull String message,
                                         @NonNull String titleStr, String positiveStr,
                                         @NonNull DialogInterface.OnClickListener onPositiveClick,
                                         DialogInterface.OnClickListener onNegtiveClick) {
        Builder localBuilder = new Builder(activity);
        localBuilder.setTitle(titleStr);
        localBuilder.setMessage(message);
        if (TextUtils.isEmpty(positiveStr))
            positiveStr = UIUtils.getString(R.string.sure);
        localBuilder.setPositiveButton(positiveStr, onPositiveClick);
        if (onNegtiveClick == null)
            onNegtiveClick = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            };
        localBuilder.setNegativeButton(R.string.cancel, onNegtiveClick);
        localBuilder.show();
    }

    public static void createProgressDialog(@NonNull Activity activity, @NonNull String message,
                                            @NonNull String titleStr) {
        createProgressDialog(activity, message, titleStr, true);
    }

    public static void createProgressDialog(@NonNull Activity activity, @NonNull String message,
                                            @NonNull String titleStr, boolean isCancelable) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(titleStr);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCancelable);
        progressDialog.setIndeterminate(true);//设置滚动条的状态为滚动
        progressDialog.show();
    }

    public static void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.cancel();
            progressDialog = null;
        }
    }

    public static void setProgressMessage(String message) {
        if (progressDialog != null) {
            progressDialog.setMessage(message);
        }
    }

    /**
     * 等待Dialog
     * @param activity
     */
    public static void showSweetAlertDialog(Activity activity) {
            mSweetAlertDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
            mSweetAlertDialog.setTitleText("加载中...");
            mSweetAlertDialog.setCanceledOnTouchOutside(true);
            mSweetAlertDialog.show();
    }

    public static SweetAlertDialog getSweetAlertWarningDialog(Activity activity){
        SweetAlertDialog mSweetAlertDialog= new SweetAlertDialog(activity,SweetAlertDialog.WARNING_TYPE);
        mSweetAlertDialog .setTitleText("提示");
        mSweetAlertDialog .setContentText("确认操作！");
        mSweetAlertDialog .setConfirmText("确定");
        mSweetAlertDialog.setCancelText("取消");
        return mSweetAlertDialog;
    }

    public static void hideSweetAlertDialog() {
        if (null != mSweetAlertDialog) {
            mSweetAlertDialog.dismiss();
            mSweetAlertDialog=null;
        }
    }
}
