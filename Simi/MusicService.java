package com.imagine.hp.beatit;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by hp on 6/25/2017.
 */
public class MusicService extends Service implements MediaPlayer.OnCompletionListener{
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"i am on my music service",Toast.LENGTH_LONG).show();
        mp=MediaPlayer.create(this,R.raw.a);
        mp.setOnCompletionListener(this);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isPlaying())
        {
            mp.start();
        }


            return START_STICKY;
        }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying())
        {
            mp.stop();
        }
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }
}
