package com.example.c.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    MediaPlayer mp = null;
    String path;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekBar);

/*
* 01-25 15:50:57.383  24709-25671/com.example.c.mediaplayer W/dalvikvm﹕ threadid=11: thread exiting with uncaught exception (group=0x41cb8da0)
01-25 15:50:57.423  24709-25671/com.example.c.mediaplayer E/AndroidRuntime﹕ FATAL EXCEPTION: Thread-23506
    Process: com.example.c.mediaplayer, PID: 24709
    java.lang.IllegalStateException
            at android.media.MediaPlayer.isPlaying(Native Method)
            at com.example.c.mediaplayer.MainActivity$1$1.run(MainActivity.java:53)
            at java.lang.Thread.run(Thread.java:841)
01-25 15:50:57.453  24709-24709/com.example.c.mediaplayer W/MediaPlayer﹕ mediaplayer went away with unhandled events
01-25 15:52:13.473  26887-26887/com.example.c.mediaplayer W/ApplicationPackageManager﹕ getCSCPackageItemText()*/
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    while(mp != null) {
                        if (mp.isPlaying()) {
                            seekBar.setProgress(mp.getCurrentPosition());
                        }
                    }
                }catch (Exception e){
                    seekBar.setProgress(0);
                }

            }
        }).start();

        path = Environment.getExternalStorageDirectory().toString();
        path += "/Samsung/Music/Over_the_horizon.mp3";

        Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();

                try {
                    mp.setDataSource(path);
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                seekBar.setMax(mp.getDuration());
                mp.start();
            }
        });

        Button btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp != null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(mp!=null)
                    mp.pause();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(mp != null) {
                    mp.seekTo(seekBar.getProgress());
                    mp.start();
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
