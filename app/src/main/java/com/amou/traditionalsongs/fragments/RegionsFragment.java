package com.amou.traditionalsongs.fragments;

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
public class RegionsFragment  extends BaseFragment<MainActivity>{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_regions, container, false);
    }
}
