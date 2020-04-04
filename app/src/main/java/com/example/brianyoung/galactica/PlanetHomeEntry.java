package com.example.brianyoung.galactica;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlanetHomeEntry extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_home_frame);

        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(PlanetHomeFragment.ARG_PLANET_NAME, getIntent().getStringExtra(PlanetHomeFragment.ARG_PLANET_NAME));
            PlanetHomeFragment fragment = new PlanetHomeFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.home_container, fragment)
                    .commit();
        }

    }
    }

