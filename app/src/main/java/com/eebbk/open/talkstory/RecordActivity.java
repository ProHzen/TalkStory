package com.eebbk.open.talkstory;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/27 16:08
 * Email:  369013520@qq.com
 */

public class RecordActivity extends RxAppBaseActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.more_appbar_layout)
    AppBarLayout mMoreAppbarLayout;

    @BindView(R.id.tabs)
    PagerSlidingTabStrip mTabs;

    @BindView(R.id.container)
    FrameLayout mContainer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.pager)
    ViewPager mPager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    public void initView(Bundle state) {
        mPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(mPager);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(mToolbar);
    }

    public class MyAdapter extends FragmentPagerAdapter {

        private String[] titles = {getString(R.string.tab_title_record),
                getString(R.string.tab_title_saved_recordings)};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RecordFragment.newInstance(null);
                case 1:
                    return FileViewerFragment.newInstance(null);
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
