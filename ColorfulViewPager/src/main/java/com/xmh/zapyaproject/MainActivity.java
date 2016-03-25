package com.xmh.colorfulviewpager;

import android.content.Intent;
import android.os.Bundle;

import com.xmh.colorfulviewpager.activity.CoverPageActivity;
import com.xmh.colorfulviewpager.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_cover_page)
    void onCoverPageClick(){
        startActivity(new Intent(this,CoverPageActivity.class));
    }
}
