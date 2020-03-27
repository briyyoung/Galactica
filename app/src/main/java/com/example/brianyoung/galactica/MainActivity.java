package com.example.brianyoung.galactica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

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

//        //Right now, getPlanets only consist of planet's name
//        ArrayList<Planet> planetArrayList = Planet.getPlanets();

        //setting the recycler view for the restaurants list
        mainActivityView = findViewById(R.id.mainActivityView);
        mainActivityView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,3);
        mainActivityView.setLayoutManager(mLayoutManager);
        MainActivityAdapter.RecyclerViewClickListener listener = new MainActivityAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);
            }
        };

        mAdapter = new MainActivityAdapter(Planet.getPlanets(),listener);
        mainActivityView.setAdapter(mAdapter);

    }

//    @Override
//    public void onItemClick(View view, int position) {
//        launchDetailActivity(position);
//    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, PlanetHome.class);
        intent.putExtra(MESSAGE, position);
        startActivity(intent);
    }
}
