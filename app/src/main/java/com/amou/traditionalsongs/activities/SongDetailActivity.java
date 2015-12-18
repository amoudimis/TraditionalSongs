package com.amou.traditionalsongs.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.listeners.TextLinkClickListener;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.pojos.SongDetailsPojo;
import com.amou.traditionalsongs.pojos.SongPojo;
import com.amou.traditionalsongs.utilities.Keys;
import com.amou.traditionalsongs.views.LinkEnabledTextView;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class SongDetailActivity extends AppCompatActivity{

    //Views
    private LinkEnabledTextView textViewLink;
    private View buttonBack;

    //Object
    private RegionPojo selectedRegion;
    private AreasPojo selectedArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);

        buttonBack = toolbar.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewLink = (LinkEnabledTextView) findViewById(R.id.textViewLink);

        Bundle data = getIntent().getExtras();
        SongPojo song = null;
        if( data.containsKey(Keys.REGION_PARAM.toString()) && data.containsKey(Keys.AREA_PARAM.toString()) && data.containsKey(Keys.SONG_PARAM.toString()))
        {
            selectedArea = (AreasPojo) data.getSerializable(Keys.AREA_PARAM.toString());
            selectedRegion = (RegionPojo) data.getSerializable(Keys.REGION_PARAM.toString());
            song = (SongPojo) data.getSerializable(Keys.SONG_PARAM.toString());
        }

        SongDetailsPojo pojo = Mobile.getDb().geSongById(song.getId());
        textViewLink.gatherLinksForText(pojo.getLyrics());

        textViewLink.setOnTextLinkClickListener(new TextLinkClickListener() {
            @Override
            public void onTextLinkClick(View view, String clickedString) {
                Log.e("patithike re", "clickedString");
            }
        });


        MovementMethod m = textViewLink.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (textViewLink.getLinksClickable()) {
                textViewLink.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
