package com.eebbk.open.talkstory;

import android.os.Bundle;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/27 15:02
 * Email:  369013520@qq.com
 */

public abstract class RxAppBaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);

        initView(savedInstanceState);
        StatusBarCompat.compat(this);
        initToolBar();
        StatusBarCompat.compat(this);
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle state);

    public abstract void initToolBar();
}
