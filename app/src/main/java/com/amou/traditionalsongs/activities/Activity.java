package com.amou.traditionalsongs.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class Activity extends AppCompatActivity{

    protected boolean isOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isOpen = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isOpen = false;
    }

}
