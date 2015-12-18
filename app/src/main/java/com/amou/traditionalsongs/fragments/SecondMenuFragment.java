package com.amou.traditionalsongs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.activities.MainActivity;
import com.amou.traditionalsongs.activities.SongsActivity;
import com.amou.traditionalsongs.adapters.AreaAdapter;
import com.amou.traditionalsongs.adapters.AreaMenuAdapter;
import com.amou.traditionalsongs.adapters.RegionAdapter;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.utilities.Keys;

import java.util.ArrayList;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class SecondMenuFragment extends Fragment {

    //Views
    private TextView textViewRegion;
    private ListView listView;

    //Objects
    private SongsActivity activity = null;
    private AreaMenuAdapter adapter = null;
    private ArrayList<AreasPojo> items = null;
    private RegionPojo selectedRegion = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (SongsActivity) getActivity();

        listView = (ListView) getView().findViewById(R.id.listView);
        textViewRegion = (TextView) getView().findViewById(R.id.textViewRegion);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activity.setNewArea(adapter.getItem(position));
            }
        });

        selectedRegion = (RegionPojo) getArguments().getSerializable(Keys.REGION_PARAM.toString());
        textViewRegion.setText(selectedRegion.getName());
        loadAreas(selectedRegion);

    }



    private void loadAreas(RegionPojo region) {
        items = Mobile.getDb().getAreas(region.getId());
        adapter = new AreaMenuAdapter(getActivity(), items);
        listView.setAdapter(adapter);
    }

}
