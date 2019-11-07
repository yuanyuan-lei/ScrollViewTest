package com.cycle.example.scrollviewtest;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private HorizontalScrollView mScrollView;
    private TestScrollView mTestScrollView;

    private float mCurrDownPosX = 0;
    private float mCurrDownPosY = 0;
    private int mDeltaX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScrollView = (HorizontalScrollView) findViewById(R.id.scroll_view);

        mScrollView.removeAllViewsInLayout();
        mTestScrollView = new TestScrollView(getApplicationContext());
        mScrollView.addView(mTestScrollView);

    }
}
