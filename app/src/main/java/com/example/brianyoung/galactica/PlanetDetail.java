package com.example.brianyoung.galactica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//The Detail class will simply be a class that holds the container to DetailFragment. Hence, this class's function is only to direct the user to the detailfragment class
public class PlanetDetail extends AppCompatActivity {
    public static final String ARG_PLANET_DETAIL_NAME = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(PlanetDetailFragment.ARG_PLANET_NAME_DETAIL, getIntent().getStringExtra(ARG_PLANET_DETAIL_NAME));

            //TODO: Create new fragment, add detail data and display it in its container
            PlanetDetailFragment fragment = new PlanetDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.detail_container, fragment).commit();
        }

    }
}
