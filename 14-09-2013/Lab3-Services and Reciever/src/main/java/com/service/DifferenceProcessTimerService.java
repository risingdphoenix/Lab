package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by USER on 13/9/2556.
 */
public class DifferenceProcessTimerService extends Service {
    public static final String NOTIFICATION = "me.picnii.receiver.broadcast.notification";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        //Toast.makeText(this, "Timer done", Toast.LENGTH_SHORT).show();
        Intent data = new Intent(NOTIFICATION);
        data.putExtra("Text", "Timer done");
        sendBroadcast(data);
        return START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
