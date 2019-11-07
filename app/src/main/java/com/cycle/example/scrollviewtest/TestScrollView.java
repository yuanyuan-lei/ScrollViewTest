package com.cycle.example.scrollviewtest;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

public class TestScrollView extends LinearLayout {

    private final static String TAG = "TestScrollView";

    private DataList mDataList;
    private Context mContext;

    private SingleCardView mCurrCardView;

    public TestScrollView(@NonNull Context context) {

        super(context);
        mContext = context;
        mDataList = new DataList(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        init();
    }

    private void init() {

        int index = 0;

        for (ItemInfo info : mDataList) {

            addChildView(getSingleCardView(info), index);
            Log.d(TAG, getChildAt(index) + "isFocused: " + getChildAt(index).isFocused());
            index++;
        }
        getChildAt(0).requestFocus();
    }

    private void addChildView(SingleCardView view, int index) {

        addView(view, index);
    }

    private SingleCardView getSingleCardView(ItemInfo info) {

        return new SingleCardView(mContext, info.getItemName(), info.getItemIconId(), info.getItemBackgroundId());
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        Log.d(TAG, "dispatchKeyEvent");

        if (mCurrCardView == null) {

            mCurrCardView = (SingleCardView) getFocusedChild();
        }

        if (event.getAction() == KeyEvent.ACTION_UP) {

            if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {

                if (mCurrCardView == getFocusedChild()) {

                    // animation
                    playBorderAnimation(mCurrCardView);
                    Log.d(TAG, "focus down." + " focused view: " + mCurrCardView + " . ==");
                } else {

                    mCurrCardView = (SingleCardView) getFocusedChild();
                }

            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void playBorderAnimation(View view) {

        view.clearAnimation();

        Animation rotateAnimation = new RotateAnimation(5, -5, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(150);
        Animation scaleAnimation = new ScaleAnimation(0.8f, 1f, 0.8f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(150);
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);

        view.startAnimation(set);

    }
}
