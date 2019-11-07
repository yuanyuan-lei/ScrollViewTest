package com.cycle.example.scrollviewtest;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleCardView extends FrameLayout {

    private Context mContext;

    private TextView mTextView;
    private ImageView mImageView;
    private LinearLayout mContainer;
    private CardView mCard;

    private ObjectAnimator animatorX;
    private ObjectAnimator animatorY;



    public SingleCardView(@NonNull Context context, String cardName, int iconId, int backgroundId) {

        super(context);
        mContext = context;
        init(cardName, iconId, backgroundId);
    }

    private void init(String cardName, int iconId, int backgroundId) {

        LayoutInflater.from(mContext).inflate(R.layout.single_card, this, true);
        mImageView = (ImageView) findViewById(R.id.card_icon);
        mTextView = (TextView) findViewById(R.id.card_name);
        mContainer = (LinearLayout) findViewById(R.id.card_background);
        mCard = (CardView) findViewById(R.id.card);

        if (iconId != 0 && backgroundId != 0) {

            mImageView.setImageResource(iconId);
            mTextView.setText(cardName);
            mContainer.setBackgroundResource(backgroundId);
        }

        setFocusable(true);

        setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                Log.d("SingleCardView", "onFocusChange");
                playAnimation(hasFocus);
            }
        });

    }

    private void playAnimation(boolean b) {

        ObjectAnimator animatorX;
        ObjectAnimator animatorY;

        if (b) {

            animatorX = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 1.2f);
            animatorY = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 1.2f);
            mCard.setCardElevation(8.0f);
            mTextView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {

            animatorX = ObjectAnimator.ofFloat(this, "scaleX", 1.2f, 1.0f);
            animatorY = ObjectAnimator.ofFloat(this, "scaleY", 1.2f, 1.0f);
            mCard.setCardElevation(0.0f);
            mTextView.setTypeface(Typeface.DEFAULT);
        }

        animatorX.start();
        animatorY.start();
    }
}
