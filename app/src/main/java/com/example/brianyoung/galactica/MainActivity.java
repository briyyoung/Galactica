package com.example.brianyoung.galactica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE = "This is from MainActivity";
    private RecyclerView mainActivityView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the recycler view for the restaurants list
        mainActivityView = findViewById(R.id.mainActivityView);
        mainActivityView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 3);
        mainActivityView.setLayoutManager(mLayoutManager);
        MainActivityAdapter.RecyclerViewClickListener listener = new MainActivityAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Planet planet = Planet.getPlanets().get(position);

                Bundle bundle = new Bundle();
                bundle.putString(PlanetHomeFragment.ARG_PLANET_NAME, planet.getName());

                Intent intent = new Intent(MainActivity.this, PlanetHomeEntry.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        mAdapter = new MainActivityAdapter(Planet.getPlanets(), listener);
        mainActivityView.setAdapter(mAdapter);
    }
}
