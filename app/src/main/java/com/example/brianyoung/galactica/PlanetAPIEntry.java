package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.brianyoung.galactica.PlanetDetail.ARG_PLANET_DETAIL_NAME;

public class PlanetAPIEntry extends AppCompatActivity {
    public static final String ARG_PLANET_API = "";
    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_api_entry);

//        if (findViewById(R.id.big_api_container) != null) {
//            mTwoPane = true;
//        }

        //extract argument (planet.getName) from intent from MainActivity
        Intent intent = getIntent();
        String planetName = intent.getStringExtra(MainActivity.MESSAGE);

        //If the home entry's mTwoPane indicates that it is a wide screen, the left side will be planet home, right side will be API content
        if(PlanetHomeEntry.mTwoPane){
            //Activate fragment PlanetAPIFragment
            Bundle argumentAPI = new Bundle();
            argumentAPI.putString(PlanetAPIFragment.ARG_PLANET_NAME_API, getIntent().getStringExtra(ARG_PLANET_DETAIL_NAME));
            PlanetAPIFragment apiFragment = new PlanetAPIFragment();
            apiFragment.setArguments(argumentAPI);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.big_api_container, apiFragment)
                    .commit();

            //Activate fragment PlanetHome (this is the exact same code as in PlanetHomeEntry)
            Bundle argumentsHome = new Bundle();
            argumentsHome.putString(PlanetHomeFragment.ARG_PLANET_NAME_FRAGMENT, planetName);
            PlanetHomeFragment homeFragment = new PlanetHomeFragment();
            homeFragment.setArguments(argumentsHome);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_container, homeFragment)
                    .commit();

        } else {
            //Activate planetAPIActivity if it's not a wide screen
            launchPlanetAPIActivity(planetName);
        }

    }

    public void launchPlanetAPIActivity(String planetname){
        Intent intent = new Intent(this, PlanetAPIActivity.class);
        intent.putExtra(PlanetAPIActivity.ARG_API_ACTIVITY, planetname);
        startActivity(intent);
        finish();
    }

}
