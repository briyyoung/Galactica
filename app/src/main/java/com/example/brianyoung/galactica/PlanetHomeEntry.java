package com.example.brianyoung.galactica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlanetHomeEntry extends AppCompatActivity {
    public static final String ARG_PLANET_NAME = "";
    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_home_entry);

        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }

        //extract argument (planet.getName) from intent from MainActivity
        Intent intent = getIntent();
        String planetName = intent.getStringExtra(MainActivity.MESSAGE);

        if(mTwoPane){
            //Activate fragment PlanetHomeFragment
            Bundle argumentsHome = new Bundle();
            argumentsHome.putString(PlanetHomeFragment.ARG_PLANET_NAME_FRAGMENT, planetName);
            PlanetHomeFragment homeFragment = new PlanetHomeFragment();
            homeFragment.setArguments(argumentsHome);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_container, homeFragment)
                    .commit();

            //Activate fragment planetdetails
            Bundle argumentsDetail = new Bundle();
            argumentsDetail.putString(PlanetDetailFragment.ARG_PLANET_NAME_DETAIL, planetName);
            PlanetDetailFragment detailFragment = new PlanetDetailFragment();
            detailFragment.setArguments(argumentsDetail);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, detailFragment)
                    .commit();

        } else {
            //Activate planetHome
            launchPlanetHome(planetName);
        }

    }

    public void launchPlanetHome(String planetname){
        Intent intent = new Intent(this, PlanetHomeActivity.class);
        intent.putExtra(PlanetHomeActivity.ARG_PLANET_NAME, planetname);
        startActivity(intent);
        finish();
    }

}

