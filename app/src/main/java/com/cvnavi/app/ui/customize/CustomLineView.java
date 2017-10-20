package com.cvnavi.app.ui.customize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.cvnavi.app.R;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/14 09:17
 * version:
 * Depict:
 */

public class CustomLineView extends View {
    private boolean left=false;
    private boolean right=false;
    private boolean top=false;
    private boolean bottom=false;

    public CustomLineView(Context context) {
        super(context);
    }

    public CustomLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getArrts(context,attrs);
    }

    public CustomLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getArrts(context,attrs);
    }

    public CustomLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        getArrts(context,attrs);
    }

    private void getArrts(Context context,AttributeSet artts){
        TypedArray td = context.obtainStyledAttributes(artts, R.styleable.DivView);
        left = td.getBoolean(R.styleable.DivView_direction_left, false);
        right = td.getBoolean(R.styleable.DivView_direction_right, false);
        top = td.getBoolean(R.styleable.DivView_direction_top, false);
        bottom = td.getBoolean(R.styleable.DivView_direction_bottom, false);
        td.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float mWidth = getWidth();
        float mHeight = getHeight();

        Paint paintCircle=new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(false);
        paintCircle.setStrokeWidth((float) 1.0);
        paintCircle.setARGB(225,220,249,29);

        float One_X=0;
        float One_Y=0;
        float Tow_X=0;
        float Tow_Y=0;
        if(right){
            One_X=mWidth;
            Tow_X=0;
        }
        if(left){
            One_X=0;
            Tow_X=mWidth;
        }
        if(top){
            One_Y=0;
            Tow_Y=mHeight;
        }
        if(bottom){
            One_Y=mHeight;
            Tow_Y=0;
        }
        canvas.drawLine(One_X,One_Y,Tow_X,Tow_Y,paintCircle);
    }
}
