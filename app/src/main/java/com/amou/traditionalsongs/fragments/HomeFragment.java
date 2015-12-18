package com.amou.traditionalsongs.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.activities.MainActivity;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class HomeFragment  extends BaseFragment<MainActivity>{


    private View buttonPhone, buttonEmail1, buttonEmail2, buttonSite, buttonFacebook, buttonYoutube;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pActivity.setTitleText(getString(R.string.home));

        buttonPhone = getView().findViewById(R.id.buttonPhone);
        buttonEmail1 = getView().findViewById(R.id.buttonEmail1);
        buttonEmail2 = getView().findViewById(R.id.buttonEmail2);
        buttonSite = getView().findViewById(R.id.buttonSite);
        buttonFacebook = getView().findViewById(R.id.buttonFacebook);
        buttonYoutube = getView().findViewById(R.id.buttonYoutube);

        buttonEmail1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:makedonesthermis@gmail.com");
                intent.setData(uri);
                startActivity(intent);
            }
        });

        buttonEmail2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:gigeneismakedonesthermis@yahoo.gr");
                intent.setData(uri);
                startActivity(intent);
            }
        });

        buttonPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:2310487621"));
                startActivity(callIntent);
            }
        });

        buttonSite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://makedonesthermis.blogspot.gr"));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });

        buttonFacebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent go = null;
                try {
                    getApplicationContext().getPackageManager().getPackageInfo(
                            "com.facebook.katana", 0);
                    go = new Intent(Intent.ACTION_VIEW, Uri
                            .parse("fb://page/400455910019260"));
                } catch (Exception e) {
                    go = new Intent(Intent.ACTION_VIEW, Uri
                            .parse("https://www.facebook.com/gigeneismakedonesthermis"));
                }


                go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(go);
            }
        });

        buttonYoutube.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.youtube.com/channel/UCxFowalO8qhf-wXjrB86VsA"));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });


    }
}
