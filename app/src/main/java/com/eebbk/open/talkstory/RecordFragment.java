package com.eebbk.open.talkstory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 10:04
 * Email:  369013520@qq.com
 */

public class RecordFragment extends RxLazyFragment {

    private static final String TAG = RecordFragment.class.getSimpleName();

    @BindView(R.id.btn_record)
    FloatingActionButton mBtnRecord;

    @BindView(R.id.chronometer)
    Chronometer mChronometer;

    @BindView(R.id.record_progressbar)
    ProgressBar mRecordProgressbar;

    @BindView(R.id.btn_pause)
    Button mBtnPause;

    @BindView(R.id.recording_status_text)
    TextView mRecordingStatusText;
    Unbinder unbinder;

    long timeWhenPaused = 0;

    private boolean mStartRecording;
    private boolean mPauseRecording;

    private int mRecordPromptCount = 0;
    private TextView mRecordingPrompt;

    public static RecordFragment newInstance(Bundle bundle) {
        RecordFragment recordFragment = new RecordFragment();
        recordFragment.setArguments(bundle);
        return recordFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_record;
    }

    @Override
    public void lazyLoad() {

    }

    @Override
    public void onVisible() {

    }

    @Override
    public void finishCreateView(Bundle state) {
        mBtnRecord.setColorNormal(getResources().getColor(R.color.primary));
        mBtnRecord.setColorPressed(getResources().getColor(R.color.primary_dark));
        mBtnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecord(mStartRecording);
                mStartRecording = !mStartRecording;
            }
        });

        mBtnPause.setVisibility(View.GONE);
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPauseRecord(mPauseRecording);
                mPauseRecording = !mPauseRecording;
            }
        });
    }

    private void onRecord(boolean recording) {

    }

    private void onPauseRecord(boolean recording) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
