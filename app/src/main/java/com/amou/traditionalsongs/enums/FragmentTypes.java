package com.amou.traditionalsongs.enums;

import com.amou.traditionalsongs.fragments.AreasFragment;
import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.fragments.HomeFragment;
import com.amou.traditionalsongs.fragments.RegionsFragment;
import com.amou.traditionalsongs.fragments.SongsFragment;

/**
 * Created by dimitrios on 10/12/2015.
 */
public enum FragmentTypes {

    HOME (1),
    REGIONS (2),
    AREAS (3),
    SONGS(4);

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
            case 3:
                return new AreasFragment();
            case 4:
                return new SongsFragment();
        }

        return null;
    }
}
