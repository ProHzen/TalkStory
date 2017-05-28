package com.eebbk.open.talkstory;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 10:04
 * Email:  369013520@qq.com
 */

public class RecordFragment extends RxLazyFragment {

    private static final String TAG = RecordFragment.class.getSimpleName();
    public static final String ARG_POSITION = "position";

    public static RecordFragment newInstance(Bundle bundle) {
        RecordFragment recordFragment = new RecordFragment();
        recordFragment.setArguments(bundle);
        return recordFragment;
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    public void lazyLoad() {

    }

    @Override
    public void onVisible() {

    }

    @Override
    public void finishCreateView(Bundle state) {

    }
}
