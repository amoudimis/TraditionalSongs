package com.amou.traditionalsongs.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.fragments.MenuFragment;
import com.amou.traditionalsongs.pojos.RegionPojo;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class MainActivity extends AppCompatActivity {

    private MenuFragment menu;
    private BaseFragment current_fragment = null;
    private TextView textViewTitle = null;
    private RegionPojo selected_region = null;
    private DrawerLayout mDrawerLayout = null;
    private FrameLayout menuView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);

        textViewTitle = (TextView) toolbar.findViewById(R.id.textViewTitle);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuView = (FrameLayout) findViewById(R.id.frame_menu);

        createMenu();
        switchFragment(FragmentTypes.HOME);


    }


    public void createMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        menu = new MenuFragment();
        fragmentManager.beginTransaction().replace(R.id.frame_menu, menu).commit();

    }


    public void switchFragment(FragmentTypes type) {
        current_fragment = type.getFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, current_fragment).commit();
    }

    public void setTitleText(String text)
    {
        textViewTitle.setText(text);
    }


    public void setRegion(RegionPojo region)
    {
        selected_region = region;
        setTitleText(selected_region.getName());
        mDrawerLayout.closeDrawer(menuView);
    }

}
