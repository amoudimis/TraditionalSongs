package com.amou.traditionalsongs.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.utilities.GlobalSettings;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class SpashActivity extends Activity {

    private ProgressDialog progressDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            progressDialog.dismiss();

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

                handler.sendEmptyMessageDelayed(0,2000);
            }
            else
            {

                handler.sendEmptyMessageDelayed(0,2000);
            }
        }
    };
}
