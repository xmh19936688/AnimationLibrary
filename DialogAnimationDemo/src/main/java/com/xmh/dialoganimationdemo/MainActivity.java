package com.xmh.dialoganimationdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShowAnimExit;
    Button btnShowAnimshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnShowAnimExit= (Button) findViewById(R.id.btn_show_anim_exit);
        btnShowAnimshow= (Button) findViewById(R.id.btn_show_anim_show);

        btnShowAnimExit.setOnClickListener(this);
        btnShowAnimshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_anim_exit:
                showDialogWithAnimExit();
                break;
            case R.id.btn_show_anim_show:
                showDialogWithAnimShow();
                break;
        }
    }

    private void showDialogWithAnimShow() {
        Dialog dialog = new Dialog(this,R.style.dialog_style);
        dialog.setContentView(R.layout.dialog_with_anim_show);
        dialog.setCanceledOnTouchOutside(true);//点击空白处消失
        final ImageView ivAnim= (ImageView) dialog.findViewById(R.id.iv_anim);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
                AnimationDrawable animDrawable = (AnimationDrawable) ivAnim.getDrawable();
                animDrawable.start();
            }
        });
        dialog.show();
    }

    private void showDialogWithAnimExit() {
        Dialog dialog = new Dialog(this,R.style.dialog_style_with_anim_exit);
        dialog.setContentView(R.layout.dialog_with_anim_exit);
        dialog.setCanceledOnTouchOutside(true);//点击空白处消失
        dialog.getWindow().setWindowAnimations(R.style.dialog_style_with_anim_exit);//dialog的动画要设置在window上
        dialog.show();
    }
}
