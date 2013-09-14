package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by USER on 6/9/2556.
 */
public class SameProcessTimerService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        Toast.makeText(this, "Timer done", Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
