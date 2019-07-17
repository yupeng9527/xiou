package com.example.rikao.view.beas;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rikao.R;

public abstract class BeasActivity extends AppCompatActivity {
    public abstract int initLayout();
    public abstract void initFind();
    public abstract void initData();
    public abstract void initListen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initFind();
        initData();
        initListen();
    }
}
