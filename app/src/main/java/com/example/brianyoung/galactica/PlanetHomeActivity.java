package com.example.brianyoung.galactica;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetHomeActivity extends AppCompatActivity {
    public static final String ARG_PLANET_NAME = " ";
    private static final String TAG = "";
    private Planet planet;
    private Button btnNotes, btnMoreInfo;
    private ImageView clickableImage;
    private TextView planetName, briefDesc;


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
        //set the image click button
        clickableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        //set the more info button
        btnMoreInfo = findViewById(R.id.btnMoreInfo);
        btnMoreInfo.setTag(planet);
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetailActivity(planet.getName());
            }
        });

        //set the notes button
        btnNotes = findViewById(R.id.btnNotes);
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNotes();
            }
        });

    }

    public void launchDetailActivity(String planetName){ //Will launch detail class
        Intent intent = new Intent(this, PlanetDetail.class);
        intent.putExtra(PlanetDetail.ARG_PLANET_DETAIL_NAME, planetName);
        startActivity(intent);
    }

    public void launchNotes(){
        Intent intent = new Intent(this, NotesList.class);
        startActivity(intent);
    }

    public void customDialog(){
        final Dialog mDialog = new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        ImageView image = mDialog.findViewById(R.id.realPic);
        int popupPic = getResources().getIdentifier("picture_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        image.setImageResource(popupPic);
        Log.d(TAG, "customDialog: popupPic received");

        mDialog.show();
    }

}
