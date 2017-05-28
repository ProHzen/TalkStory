package com.eebbk.open.talkstory;

import android.os.Bundle;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 10:08
 * Email:  369013520@qq.com
 */

public class FileViewerFragment extends RxLazyFragment {


    public static FileViewerFragment newInstance(Bundle bundle) {
        FileViewerFragment fileViewerFragment = new FileViewerFragment();
        fileViewerFragment.setArguments(bundle);
        return fileViewerFragment;
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
