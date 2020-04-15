package com.example.brianyoung.galactica;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetHomeActivity extends AppCompatActivity {
    public static final String ARG_PLANET_NAME = " ";
    private Planet planet;
    private Button btnAPI, btnMoreInfo;
    private ImageView clickableImage;
    private TextView planetName, briefDesc;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_home_activity);

        Intent intent = getIntent();
        planet = Planet.getPlanet(intent.getStringExtra(ARG_PLANET_NAME));

        //set the planet's name
        planetName = findViewById(R.id.planetName);
        planetName.setText(planet.getName());

        //set the planet's description
        briefDesc = findViewById(R.id.briefDesc);
        briefDesc.setText(planet.getDescription());

        //set the planet's picture
        clickableImage = findViewById(R.id.clickableImage);
        int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        clickableImage.setImageResource(picture);

        //set the more info button
        btnMoreInfo = findViewById(R.id.btnMoreInfo);
        btnMoreInfo.setTag(planet);
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetailActivity(planet.getName());
            }
        });

        //set the share button
        shareButton = findViewById(R.id.btnShares);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi This is Planet " + planet.getName() +" ,I learn this using Galatica App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, ""+planet.getDescription());
                startActivity(Intent.createChooser(shareIntent, "Share to "));
            }
        });


//        //**set the API button
//        btnAPI = findViewById(R.id.btnShowVideo);
//        btnAPI.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) { launchPlanetAPIActivity(planet.getName());
//
//            }
//        });


    }

    public void launchDetailActivity(String planetName){ //Will launch detail class
        Intent intent = new Intent(this, PlanetDetail.class);
        intent.putExtra(PlanetDetail.ARG_PLANET_DETAIL_NAME, planetName);
        startActivity(intent);
    }

//    public void launchPlanetAPIActivity(String planetName){
//        Intent intent = new Intent(this, PlanetAPIActivity.class);
//        intent.putExtra(PlanetAPIActivity.ARG_API_ACTIVITY, planetName);
//        startActivity(intent);
//    }
}
