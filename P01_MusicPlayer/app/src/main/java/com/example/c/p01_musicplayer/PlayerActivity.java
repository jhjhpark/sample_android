package com.example.c.p01_musicplayer;

import android.support.v4.app.Fragment;

/**
 * Created by c on 2015-02-08.
 */
public class PlayerActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PlayerFragment();
    }
}
