package com.xmh.animingoujian;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rl_input)RelativeLayout rlInput;
    @Bind(R.id.btn_go)Button btnGo;
    @Bind(R.id.et_gif)EditText etGif;

    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @OnClick(R.id.btn_go)
    void onGifClick(View view) {
        if(btnGo.getTag(R.id.btn_go)==null) {
            btnGo.setTag(R.id.btn_go, btnGo.getMeasuredWidth());
        }
        if(rlInput.getTag(R.id.rl_input)==null){
            rlInput.setTag(R.id.rl_input,rlInput.getMeasuredHeight());
        }
        if(etGif.getTag(R.id.et_gif)==null){
            etGif.setTag(R.id.et_gif,etGif.getMeasuredWidth());
        }
        final ValueAnimator btnSizeAnimator = ValueAnimator.ofInt((int)btnGo.getTag(R.id.btn_go),rlInput.getMeasuredWidth());
        btnSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = btnGo.getLayoutParams();
                layoutParams.width = (int) animation.getAnimatedValue();
                btnGo.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator etSizeAnimator = ValueAnimator.ofInt((int)etGif.getTag(R.id.et_gif),rlInput.getMeasuredWidth());
        etSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = etGif.getLayoutParams();
                layoutParams.width = (int) animation.getAnimatedValue();
                etGif.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator rlSizeAnimator = ValueAnimator.ofInt((int)rlInput.getTag(R.id.rl_input), (int)rlInput.getTag(R.id.rl_input) * 2);
        rlSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = rlInput.getLayoutParams();
                layoutParams.height = (int) animation.getAnimatedValue();
                rlInput.setLayoutParams(layoutParams);

            }
        });
        ValueAnimator etMarginAnimator = ValueAnimator.ofInt(0, btnGo.getMeasuredHeight());
        etMarginAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) etGif.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, (int) animation.getAnimatedValue());
                etGif.setLayoutParams(layoutParams);
            }
        });

        if(isOpen){
            btnSizeAnimator.reverse();
            etSizeAnimator.reverse();
            rlSizeAnimator.reverse();
            etMarginAnimator.reverse();
        }else{
            btnSizeAnimator.start();
            etSizeAnimator.start();
            rlSizeAnimator.start();
            etMarginAnimator.start();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) etGif.getLayoutParams();
            layoutParams.removeRule(RelativeLayout.LEFT_OF);
            etGif.setLayoutParams(layoutParams);
        }
        isOpen=!isOpen;
    }
}
