package com.example.brianyoung.galactica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivityAddition extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_addition);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(PlanetHome.ARG_PLANET_NAME, getIntent().getStringExtra(PlanetHome.ARG_PLANET_NAME));
            PlanetHome fragment = new PlanetHome();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.planet_home_container, fragment)
                    .commit();

        }
    }
    }

