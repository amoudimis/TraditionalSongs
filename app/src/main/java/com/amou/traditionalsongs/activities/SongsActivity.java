package com.amou.traditionalsongs.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.enums.FragmentTypes;
import com.amou.traditionalsongs.fragments.BaseFragment;
import com.amou.traditionalsongs.fragments.MenuFragment;
import com.amou.traditionalsongs.fragments.SecondMenuFragment;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;
import com.amou.traditionalsongs.utilities.Keys;

/**
 * Created by dimitrios on 11/12/2015.
 */
public class SongsActivity extends AppCompatActivity {

    private SecondMenuFragment menu;
    private BaseFragment currentFragment = null;
    private TextView textViewTitle = null;
    private DrawerLayout mDrawerLayout = null;
    private FrameLayout menuView = null;
    private View buttonDrawer, buttonBack;

    private AreasPojo selectedArea = null;
    private RegionPojo selectedRegion = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);

        Bundle data = getIntent().getExtras();
        if( data.containsKey(Keys.REGION_PARAM.toString()) && data.containsKey(Keys.AREA_PARAM.toString()))
        {
            selectedArea = (AreasPojo) data.getSerializable(Keys.AREA_PARAM.toString());
            selectedRegion = (RegionPojo) data.getSerializable(Keys.REGION_PARAM.toString());
        }
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

        buttonBack = toolbar.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createMenu();
        setTitleText(selectedArea.getName());

        switchFragment(FragmentTypes.SONGS, getIntent().getExtras());

    }


    public void setNewArea(AreasPojo newArea)
    {
        selectedArea = newArea;
        Bundle data = new Bundle();
        data.putSerializable(Keys.AREA_PARAM.toString(), newArea);
        data.putSerializable(Keys.REGION_PARAM.toString(), selectedRegion);

        switchFragment(FragmentTypes.SONGS, data);
        mDrawerLayout.closeDrawer(menuView);
    }

    public void createMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        menu = new SecondMenuFragment();
        Bundle data = new Bundle();
        data.putSerializable(Keys.REGION_PARAM.toString(),selectedRegion);
        menu.setArguments(data);
        fragmentManager.beginTransaction().replace(R.id.frame_menu, menu).commit();
    }

    public void setTitleText(String text)
    {
        textViewTitle.setText(text);
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


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
