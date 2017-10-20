package com.cvnavi.app.ui.customize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.cvnavi.app.R;

/**
 * Created by wangshy on 17/7/17.
 */

@SuppressLint("AppCompatCustomView")
public class AlarmTextView extends TextView {

    private int mTextDrawableTop = 0;
    private int mTextDrawableRight = 0;
    private int mTextDrawableBottom = 0;
    private int mTextDrawableLift = 0;


    public AlarmTextView(Context context) {
        super(context);
    }

    public AlarmTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AlarmTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setmTextDrawableLift(int mTextDrawableLift) {
        if (this.mTextDrawableLift == mTextDrawableLift)
            return;
        this.mTextDrawableLift = mTextDrawableLift;
        if (mTextDrawableLift == 0) {
            setTextColor(ColorStateList.valueOf(0xffffffff));
            setCompoundDrawablesWithIntrinsicBounds(R.mipmap.alarm, mTextDrawableTop, mTextDrawableRight, mTextDrawableBottom);
        } else if (mTextDrawableLift == 1) {
            setTextColor(ColorStateList.valueOf(0xffFD7500));
            setCompoundDrawablesWithIntrinsicBounds(R.mipmap.alarm1, mTextDrawableTop, mTextDrawableRight, mTextDrawableBottom);
        }
    }

    public void setmTextDrawableTop(int mTextDrawableTop) {
        this.mTextDrawableTop = mTextDrawableTop;
        setCompoundDrawablesWithIntrinsicBounds(mTextDrawableLift, mTextDrawableTop, mTextDrawableRight, mTextDrawableBottom);
    }

    public void setmTextDrawableRight(int mTextDrawableRight) {
        this.mTextDrawableRight = mTextDrawableRight;
        setCompoundDrawablesWithIntrinsicBounds(mTextDrawableLift, mTextDrawableTop, mTextDrawableRight, mTextDrawableBottom);
    }

    public void setmTextDrawableBottom(int mTextDrawableBottom) {
        this.mTextDrawableBottom = mTextDrawableBottom;
        setCompoundDrawablesWithIntrinsicBounds(mTextDrawableLift, mTextDrawableTop, mTextDrawableRight, mTextDrawableBottom);
    }
}
