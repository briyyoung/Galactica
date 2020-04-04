package com.example.brianyoung.galactica;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class PlanetDetailEntry extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_home_frame);

//        if (findViewById(R.id.home_container) != null) {
//            mTwoPane = true;
//        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(PlanetHomeFragment.ARG_PLANET_NAME, getIntent().getStringExtra(PlanetHomeFragment.ARG_PLANET_NAME));
            PlanetDetailFragment fragment = new PlanetDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, fragment)
                    .commit();
        }

    }
}



