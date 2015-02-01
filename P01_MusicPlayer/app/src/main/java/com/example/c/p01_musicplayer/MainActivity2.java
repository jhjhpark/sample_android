package com.example.c.p01_musicplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by c on 2015-02-01.
 */
public class MainActivity2 extends ActionBarActivity {
    MusicPlayerSerice2 mPlayerSerice2;
    boolean mBound = false;

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicPlayerSerice2.LocalBinder2 binder2 = (MusicPlayerSerice2.LocalBinder2)service;
            mPlayerSerice2 = binder2.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent  = new Intent(MainActivity2.this, MusicPlayerSerice2.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound)
                    mPlayerSerice2.play();
            }
        });
        Button btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound)
                    mPlayerSerice2.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBound){
            unbindService(mConnection);
            mBound = false;
        }
    }
}
