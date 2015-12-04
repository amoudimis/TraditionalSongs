package com.amou.traditionalsongs;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amou.traditionalsongs.databases.DatabaseControl;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class Mobile extends Application{

    private static DatabaseControl db;
    private static Mobile instance = null;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = new DatabaseControl(instance);
        db.openGeneralDatabase();
        Log.e("", "mobile aplicdation");

    }

    public static DatabaseControl getDb() {
        return db;
    }

    public static void setDb(DatabaseControl db) {
        Mobile.db = db;
    }

    /**
     *
     * @return the application
     */
    public static Mobile get() {
        return instance;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        db.closeGeneralDatabase();
    }

    public static Context getMasterContext() {
        return Mobile.get().getApplicationContext();
    }
}
