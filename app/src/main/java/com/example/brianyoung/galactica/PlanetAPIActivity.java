package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brianyoung.galactica.Entities.Body;

public class PlanetAPIActivity extends AppCompatActivity {
    public static final String ARG_API_ACTIVITY = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_api);

        //This will only be called when it detects that it is not a wide screen
        //so it will just call the API Fragment and put it in the small_api_container
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(PlanetAPIFragment.ARG_PLANET_NAME_API, getIntent().getStringExtra(ARG_API_ACTIVITY));

            //TODO: Create new fragment, add detail data and display it in its container
            PlanetAPIFragment fragment = new PlanetAPIFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.small_api_container, fragment).commit();
        }
    }


}

