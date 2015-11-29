package com.xmh.frameanimationimageviewdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAnim= (ImageView) findViewById(R.id.iv_anim);

        AnimationDrawable animationDrawable= (AnimationDrawable) ivAnim.getDrawable();
        animationDrawable.start();
    }

}
