package com.example.c.p01_musicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by c on 2015-02-08.
 */
public class MediaPlayerSQLiteHandler {
    MediaPlayerSQLiteOpenHelper mHelper;
    SQLiteDatabase mDB;

    public MediaPlayerSQLiteHandler(Context context) {
        mHelper = new MediaPlayerSQLiteOpenHelper(context, "playinfo.sqlite", null, 1);
    }

    public void close(){
        mHelper.close();
    }

    public long insert(String filename){
        ContentValues values = new ContentValues();
        values.put("filename", filename);
        values.put("playtime", 0);

        mDB = mHelper.getWritableDatabase();
        return mDB.insert("playinfo", null, values);
    }

    public void update(int id, int playtime){
        ContentValues values = new ContentValues();
        values.put("playtime", playtime);

        mDB = mHelper.getWritableDatabase();
        mDB.update("playinfo", values, "id = ?", new String[]{""+id});
    }

    public int getPlayTime(int id){
        mDB = mHelper.getReadableDatabase();

        String sql = "select * from playinfo where id="+id;
        Cursor c = mDB.rawQuery(sql, null);

        c.moveToFirst();
        return c.getInt(c.getColumnIndex("playtime"));
    }

}
