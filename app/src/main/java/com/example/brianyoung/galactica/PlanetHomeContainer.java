package com.example.brianyoung.galactica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlanetHomeContainer extends AppCompatActivity {
    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_home_container);

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
