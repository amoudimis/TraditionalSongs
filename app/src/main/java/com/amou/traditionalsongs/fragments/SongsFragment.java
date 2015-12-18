package com.amou.traditionalsongs.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.activities.SongDetailActivity;
import com.amou.traditionalsongs.activities.SongsActivity;
import com.amou.traditionalsongs.adapters.SongsAdapter;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.pojos.SongPojo;
import com.amou.traditionalsongs.utilities.Keys;

import java.util.ArrayList;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class SongsFragment extends BaseFragment<SongsActivity> {

    //Views
    private View textViewEmpty;
    private ListView listView;

    //Objects
    private RegionPojo selectedRegion;
    private AreasPojo selectedArea;
    private ArrayList<SongPojo> items;
    private SongsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_songs, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textViewEmpty = getView().findViewById(R.id.textViewEmpty);
        listView = (ListView) getView().findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), SongDetailActivity.class);
                intent.putExtra(Keys.AREA_PARAM.toString(), selectedArea);
                intent.putExtra(Keys.REGION_PARAM.toString(), selectedRegion);
                intent.putExtra(Keys.SONG_PARAM.toString(), adapter.getItem(position));

                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
        });

        if( getArguments().containsKey(Keys.REGION_PARAM.toString()) && getArguments().containsKey(Keys.AREA_PARAM.toString()))
        {
            selectedArea = (AreasPojo) getArguments().getSerializable(Keys.AREA_PARAM.toString());
            selectedRegion = (RegionPojo) getArguments().getSerializable(Keys.REGION_PARAM.toString());
        }

        items = Mobile.getDb().getListOfSongsFromArea(selectedArea.getId());

        if(items.size()>0) {
            adapter = new SongsAdapter(getApplicationContext(), items);
            listView.setAdapter(adapter);
        }else{ noSongs();}

    }


    private void noSongs()
    {
        textViewEmpty.setVisibility(View.VISIBLE);
    }


}
