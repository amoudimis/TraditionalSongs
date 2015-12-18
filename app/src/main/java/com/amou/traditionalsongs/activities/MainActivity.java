package com.amou.traditionalsongs.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.fragments.MenuFragment;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.utilities.Keys;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class MainActivity extends AppCompatActivity {

    private MenuFragment menu;
    private BaseFragment currentFragment = null;
    private TextView textViewTitle = null;
    private RegionPojo selectedRegion = null;
    private DrawerLayout mDrawerLayout = null;
    private FrameLayout menuView = null;
    private View buttonDrawer, buttonHome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);

        textViewTitle = (TextView) toolbar.findViewById(R.id.textViewTitle);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuView = (FrameLayout) findViewById(R.id.frame_menu);

        buttonDrawer = toolbar.findViewById(R.id.buttonDrawer);
        buttonDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(menuView);
            }
        });

        buttonHome = toolbar.findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(FragmentTypes.HOME);
            }
        });



        createMenu();

        buttonHome.performClick();
    }


    public void createMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        menu = new MenuFragment();
        fragmentManager.beginTransaction().replace(R.id.frame_menu, menu).commit();

    }


    public void switchFragment(FragmentTypes type) {
        currentFragment = type.getFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, currentFragment).commit();
    }

    public void switchFragment(FragmentTypes type,Bundle data) {
        currentFragment = type.getFragment();
        currentFragment.setArguments(data);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, currentFragment).commit();
    }

    public void setTitleText(String text)
    {
        textViewTitle.setText(text);
    }


    public void setRegion(FragmentTypes type,RegionPojo region)
    {
        selectedRegion = region;
        setTitleText(selectedRegion.getName());
        Bundle params = new Bundle();
        params.putSerializable(Keys.REGION_PARAM.toString(),region);
        switchFragment(type,params);
        mDrawerLayout.closeDrawer(menuView);
    }

}
