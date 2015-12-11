package com.amou.traditionalsongs.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amou.traditionalsongs.Mobile;
import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.activities.MainActivity;
import com.amou.traditionalsongs.adapters.AreaAdapter;
import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.utilities.Keys;

import java.util.ArrayList;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class AreasFragment extends BaseFragment {

    private ListView listView;
    private View progressBar;
    private View textViewEmpty;
    private RegionPojo selectedRegion = null;
    private ArrayList<AreasPojo> items = null;
    private AreaAdapter adapter = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_area, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.listView);
        progressBar = getView().findViewById(R.id.progressBar);
        textViewEmpty = getView().findViewById(R.id.textViewEmpty);

        if (getArguments() != null && getArguments().containsKey(Keys.REGION_PARAM.toString())) {
            selectedRegion = (RegionPojo) getArguments().getSerializable(Keys.REGION_PARAM.toString());
            loadAreas(selectedRegion);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    private void loadAreas(final RegionPojo region)

    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                items = Mobile.getDb().getAreas(region.getId());


                if (items.size() == 0) {
                    noAreas();
                }
                else
                {
                    adapter = new AreaAdapter(getApplicationContext(), items);
                    setAdapter();
                }
            }
        }
        ).start();
    }


    private void noAreas() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textViewEmpty.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setAdapter()
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textViewEmpty.setVisibility(View.GONE);
                listView.setAdapter(adapter);
            }
        });
    }

}
