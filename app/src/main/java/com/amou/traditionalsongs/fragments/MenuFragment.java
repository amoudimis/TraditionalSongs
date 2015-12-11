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
import android.widget.Toast;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.activities.MainActivity;
import com.amou.traditionalsongs.adapters.RegionAdapter;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.pojos.RegionPojo;

import java.util.ArrayList;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class MenuFragment extends Fragment{

    private MainActivity activity = null;
    private ListView listView;
    private RegionAdapter adapter = null;
    private ArrayList<RegionPojo> items = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (MainActivity) getActivity();

        listView = (ListView) getView().findViewById(R.id.listView);
        items = Mobile.getDb().getRegions();
        adapter = new RegionAdapter(getActivity(),items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("", "" + position);
                activity.setRegion(FragmentTypes.AREAS,adapter.getItem(position));
            }
        });

    }
}
