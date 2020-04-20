package com.example.brianyoung.galactica;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE = "This is from MainActivity";
    private static final String TAG = "";
    private RecyclerView mainActivityView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ActionBar actionBar;
    Button btnMusic;
    Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000839")));



        //button for playing and stopping music
        final MediaPlayer player = MediaPlayer.create(this, R.raw.phase); //creating mediaplayer
        btnMusic = findViewById(R.id.btnMusic);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!player.isPlaying()){
                    player.start();
                    btnMusic.setText("Click to stop music!");
                } else {
                    player.pause();
                    Log.d(TAG, "onClick: stopPlayer initiated!");
                    btnMusic.setText("Click to play music!");
                }
            }
        });


        //setting the recycler view for the restaurants list
        mainActivityView = findViewById(R.id.mainActivityView);
        mainActivityView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 3);
        mainActivityView.setLayoutManager(mLayoutManager);
        MainActivityAdapter.RecyclerViewClickListener listener = new MainActivityAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Planet planet = Planet.getPlanets().get(position);

                //make intent that would pass in name to planethomeentry
                Intent intent = new Intent(MainActivity.this, PlanetHomeEntry.class);
                intent.putExtra(MESSAGE, planet.getName());
                startActivity(intent);
            }
        };

        //add feedback button to direct to feedback page
        btnFeedback = findViewById(R.id.btnAboutPage);
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        mAdapter = new MainActivityAdapter(Planet.getPlanets(), listener);
        mainActivityView.setAdapter(mAdapter);
    }


}
