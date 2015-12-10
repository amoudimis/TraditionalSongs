package com.amou.traditionalsongs.enums;

import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.fragments.HomeFragment;
import com.amou.traditionalsongs.fragments.RegionsFragment;

/**
 * Created by dimitrios on 10/12/2015.
 */
public enum FragmentTypes {

    HOME (1),
    REGIONS (2);

    private int id;
    FragmentTypes(int id) {
        this.id = id;

    }

    public BaseFragment getFragment()
    {
        switch (id)
        {
            case 1:
                return new HomeFragment();
            case 2:
                return new RegionsFragment();
        }

        return null;
    }
}
