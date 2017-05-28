package com.eebbk.open.talkstory;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 9:26
 * Email:  369013520@qq.com
 */

public class RecordInfo extends RealmObject implements Parcelable{

    private String mName;
    private String mFilePath;
    private int mId;
    private int mLength;
    private long mTime;

    public RecordInfo() {
    }


    protected RecordInfo(Parcel in) {
        mName = in.readString();
        mFilePath = in.readString();
        mId = in.readInt();
        mLength = in.readInt();
        mTime = in.readLong();
    }

    public static final Creator<RecordInfo> CREATOR = new Creator<RecordInfo>() {
        @Override
        public RecordInfo createFromParcel(Parcel in) {
            return new RecordInfo(in);
        }

        @Override
        public RecordInfo[] newArray(int size) {
            return new RecordInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mFilePath);
        dest.writeInt(mId);
        dest.writeInt(mLength);
        dest.writeLong(mTime);
    }

    public String getName() {
        return mName;
    }

    public RecordInfo setName(String name) {
        mName = name;
        return this;
    }

    public String getFilePath() {
        return mFilePath;
    }

    public RecordInfo setFilePath(String filePath) {
        mFilePath = filePath;
        return this;
    }

    public int getId() {
        return mId;
    }

    public RecordInfo setId(int id) {
        mId = id;
        return this;
    }

    public int getLength() {
        return mLength;
    }

    public RecordInfo setLength(int length) {
        mLength = length;
        return this;
    }

    public long getTime() {
        return mTime;
    }

    public RecordInfo setTime(long time) {
        mTime = time;
        return this;
    }
}
