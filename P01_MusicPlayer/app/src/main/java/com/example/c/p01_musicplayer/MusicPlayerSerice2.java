package com.example.c.p01_musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by c on 2015-02-01.
 */
public class MusicPlayerSerice2 extends Service {
    public class LocalBinder2 extends Binder{
        public MusicPlayerSerice2 getService(){
            return MusicPlayerSerice2.this;
        }
    }

    private LocalBinder2 mLocalBinder2 = new LocalBinder2();

    @Override
    public IBinder onBind(Intent intent) {
        return mLocalBinder2;
    }
}
