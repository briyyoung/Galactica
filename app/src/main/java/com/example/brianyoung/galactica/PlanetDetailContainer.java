package com.example.brianyoung.galactica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlanetDetailContainer extends AppCompatActivity {
    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_detail_container);



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
