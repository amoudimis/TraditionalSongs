package com.amou.traditionalsongs.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.amou.traditionalsongs.R;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class SpashActivity extends AppCompatActivity {

    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what)
            {

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
