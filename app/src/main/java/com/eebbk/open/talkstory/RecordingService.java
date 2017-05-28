package com.eebbk.open.talkstory;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.elvishew.xlog.XLog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 15:42
 * Email:  369013520@qq.com
 */

public class RecordingService extends Service{

    private static final String TAG = RecordingService.class.getSimpleName();
    private static final SimpleDateFormat mTimeFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());

    private String mFileName = null;
    private String mFilePath = null;

    private MediaRecorder mRecorder = null;

    private long mStartingTimeMills = 0;
    private long mElapsedMills = 0;
    private int mElapsedSeconds = 0;

    private onTimerChangedListener mOnTimerChangedListener = null;
    private Timer mTimer = null;
    private TimerTask mIncremenTimerTask = null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public interface OnTimerChangedListener {
        void onTimerChanged(int seconds);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startRecording();
        return START_STICKY;
    }

    private void setFileNameAndPath() {
        int count = 0;
        File file;
        do {
            count++;
            mFileName = getString(R.string.default_file_name) + "_" + () + ".mp4";
            mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            file = new File(mFilePath);
        } while (file.exists() && !file.isDirectory());
    }

    private void startRecording() {
        setFileNameAndPath();

        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mRecorder.setOutputFile(mFilePath);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        mRecorder.setAudioChannels(1);
        if (MySharedPreferences.getPrefHighQuality(this)) {
            mRecorder.setAudioSamplingRate(44100);
            mRecorder.setAudioEncodingBitRate(192000);
        }
        try {
            mRecorder.prepare();
            mRecorder.start();
            mStartingTimeMills = System.currentTimeMillis();
        } catch (IOException e) {
            XLog.e(TAG, " e = " + e.getMessage());
        }
    }


    @Override
    public void onDestroy() {
        if (mRecorder != null) {
            stopRecording();
        }
        super.onDestroy();
    }

    private void stopRecording() {
        mRecorder.stop();
        mElapsedMills = (System.currentTimeMillis() - mStartingTimeMills);
        mRecorder.release();

        if (mIncremenTimerTask != null) {
            mIncremenTimerTask = null;
        }

        mRecorder = null;

    }
}
