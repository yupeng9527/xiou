package com.example.rikao.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.rikao.R;
import com.example.rikao.view.beas.BeasActivity;

public class MainActivity extends BeasActivity {
    private FragmentManager manager;
    private com.example.rikao.view.fragment.Fragment fragment;
    private com.example.rikao.view.fragment.Fragment1 fragment1;
    private com.example.rikao.view.fragment.Fragment2 fragment2;
    private com.example.rikao.view.fragment.Fragment3 fragment3;
    private com.example.rikao.view.fragment.Fragment4 fragment4;
    private RadioGroup group;


    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initFind() {
    fragment = new com.example.rikao.view.fragment.Fragment();
    fragment1 = new com.example.rikao.view.fragment.Fragment1();
    fragment2 = new com.example.rikao.view.fragment.Fragment2();
    fragment3 = new com.example.rikao.view.fragment.Fragment3();
    fragment4 = new com.example.rikao.view.fragment.Fragment4();
        group = findViewById(R.id.group);
    }

    @Override
    public void initData() {
    manager = getSupportFragmentManager();
    manager.beginTransaction()
            .add(R.id.frag,fragment)
            .add(R.id.frag,fragment1)
            .add(R.id.frag,fragment2)
            .add(R.id.frag,fragment3)
            .add(R.id.frag,fragment4)
            .show(fragment)
            .hide(fragment1)
            .hide(fragment2)
            .hide(fragment3)
            .hide(fragment4)
            .commit();

    }

    @Override
    public void initListen() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.but:
                        transaction.show(fragment)
                                .hide(fragment1)
                                .hide(fragment2)
                                .hide(fragment3)
                                .hide(fragment4);
                        break;
                    case R.id.but1:
                        transaction.show(fragment1)
                                .hide(fragment)
                                .hide(fragment2)
                                .hide(fragment3)
                                .hide(fragment4);
                        break;
                    case R.id.but2:
                        transaction.show(fragment2)
                                .hide(fragment1)
                                .hide(fragment)
                                .hide(fragment3)
                                .hide(fragment4);
                        break;
                    case R.id.but3:
                        transaction.show(fragment3)
                                .hide(fragment1)
                                .hide(fragment2)
                                .hide(fragment)
                                .hide(fragment4);
                        break;
                    case R.id.but4:
                        transaction.show(fragment4)
                                .hide(fragment1)
                                .hide(fragment2)
                                .hide(fragment3)
                                .hide(fragment);
                        break;
                }
                transaction.commit();
            }
        });
    }


}
