package com.xmh.colorfulviewpager.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by mengh on 2016/2/22 022.
 */
public class BaseActivity extends AppCompatActivity {

    /**第一次点击返回的时间*/
    private long clickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //region 隐藏魅族手机导航栏
        if(Build.BRAND.equals("Meizu")){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
        //endregion
    }

}
