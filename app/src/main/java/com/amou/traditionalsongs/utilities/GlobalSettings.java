package com.amou.traditionalsongs.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.amou.traditionalsongs.Mobile;

/**
 * Created by dimitrios on 4/12/2015.
 */

public class GlobalSettings {

    public static SharedPreferences getSharedPreferences() {
        SharedPreferences prefs = Mobile.getMasterContext().getSharedPreferences("com.amou.traditional", Context.MODE_PRIVATE);
        return prefs;
    }

//    public static boolean getAutoLoginEnable() {
//
//        return getSharedPreferences().getBoolean("auto_login", false);
//    }
//
//    public static void setAutoLoginEnable(boolean enable, AccountPojo profile) {
//
//        Editor editor = getSharedPreferences().edit();
//        editor.putBoolean("auto_login", enable);
//        editor.putString("user_id", profile.getUserID() + "");
//
//        // if(enable)
//        // {
//        editor.putString("email", profile.getEmail());
//        editor.putString("password", profile.getPassword());
//        // }
//
//        editor.commit();
//
//    }

    public static boolean isFirstLaunch() {

        return getSharedPreferences().getBoolean("first_launch", true);
    }

    public static void firstLaunchComplete()
    {
        setFirstLaunchValue(false);
    }

    public static void setFirstLaunchValue(boolean value)
    {
        Editor editor = getSharedPreferences().edit();
        editor.putBoolean("first_launch", value);
        editor.commit();
    }


}