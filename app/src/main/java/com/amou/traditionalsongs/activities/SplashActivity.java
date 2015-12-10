package com.amou.traditionalsongs.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.utilities.GlobalSettings;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class SplashActivity extends Activity {

    private ProgressDialog progressDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            progressDialog.dismiss();
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);

        new Thread(runnable).start();


    }




    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.e("", "runnable");

            if( GlobalSettings.isFirstLaunch() )
            {
                progressDialog.setMessage("Κατέβασμα όλων των δεδομένων");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.show();
                    }
                });


                Mobile.getDb().insertRegions();
                Mobile.getDb().insertAreas();

                GlobalSettings.firstLaunchComplete();

                handler.sendEmptyMessageDelayed(0, 2000);
            }
            else
            {

                handler.sendEmptyMessageDelayed(0,2000);
            }
        }
    };
}
