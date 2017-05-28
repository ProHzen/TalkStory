package com.eebbk.open.talkstory;

import android.app.Application;

import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/28 16:46
 * Email:  369013520@qq.com
 */

public class AppManager extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initRelam();
        XLog.init(LogLevel.ALL);
    }

    private void initRelam() {
        Realm.init(this);
        RealmConfiguration config = new  RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
