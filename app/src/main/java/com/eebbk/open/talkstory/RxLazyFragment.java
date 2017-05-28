package com.eebbk.open.talkstory;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/27 15:18
 * Email:  369013520@qq.com
 */

public abstract class RxLazyFragment extends RxFragment {

    private View mParentView;

    private FragmentActivity mFragmentActivity;

    private LayoutInflater mInflater;

    protected boolean isPrepared;

    protected boolean isVisible;

    protected abstract int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflater = inflater;
        mParentView = mInflater.inflate(getLayoutResId(), container, false);
        mFragmentActivity = getSupportActivity();
        return mParentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        finishCreateView(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mFragmentActivity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentActivity = null;
    }

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    public ActionBar getSupportActionBar() {
        return getSupportActivity().getActionBar();
    }

    public Context getApplicationContext() {
        return mFragmentActivity == null ? (getActivity() == null ? null : getActivity().getApplicationContext()): mFragmentActivity.getApplicationContext();
    }

    protected LayoutInflater getLayoutInflate() {
        return mInflater;
    }

    protected View getParentView() {
        return mParentView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onInvisible(){
        lazyLoad();
    }

    public abstract void lazyLoad();

    public abstract void onVisible();

    public abstract void finishCreateView(Bundle state);

    public <T extends View> T $(int id) {
        return (T) mParentView.findViewById(id);
    }
}
