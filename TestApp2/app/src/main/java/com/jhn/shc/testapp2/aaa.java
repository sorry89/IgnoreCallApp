package com.jhn.shc.testapp2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class aaa extends Service {
    public aaa() {
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");





    }
}

