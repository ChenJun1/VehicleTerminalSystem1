package com.cvnavi.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/14 10:32
 * version:
 * Depict:
 */

public class Test extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tire_pessure);
    }


    private void showDialog(){

//        SweetAlertDialog alertDialog=new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE);
//        alertDialog.setConfirmButtonShow(false);
//        alertDialog.setTitleText("您已超时，请减速慢行！");
//        alertDialog.show();

        showPOP();
    }

    private void showPOP(){
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_text_information_pop, null);
        TextView title= (TextView) contentView.findViewById(R.id.pop_title_tv);
        TextView conten= (TextView) contentView.findViewById(R.id.pop_content_tv);
        TextView form= (TextView) contentView.findViewById(R.id.pop_form_tv);
        TextView date= (TextView) contentView.findViewById(R.id.pop_date_tv);
        Button  button=(Button) contentView.findViewById(R.id.pop_determine_bt);
        final PopupWindow popupWindow = new PopupWindow(contentView);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER,0,0);
    }

    public void test2(){
        System.nanoTime();
        System.exit(0);

    }
}
