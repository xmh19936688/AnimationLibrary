package com.xmh.animingoujianwithtransition;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MainFragment fragment= new MainFragment();
        transaction.replace(R.id.fl_fragment,fragment);
        transaction.commit();
    }
}
