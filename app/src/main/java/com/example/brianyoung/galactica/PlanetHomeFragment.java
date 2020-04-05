package com.example.brianyoung.galactica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetHomeFragment extends Fragment {

    public static final String ARG_PLANET_NAME_FRAGMENT = "Setting what planet we are clicking";

    // TODO: Rename and change types of parameters
    private Planet planet;
    private Button btnShowVideo;
    private ImageView clickableImage;
    private TextView planetName;

    public PlanetHomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //receiving the bundle arguments from the activity this fragment is associated with (in this case it is associated with PlanetHomeEntry)
    if(getArguments().containsKey(ARG_PLANET_NAME_FRAGMENT)){
            planet = Planet.getPlanet(getArguments().getString(ARG_PLANET_NAME_FRAGMENT));
            this.getActivity().setTitle(planet.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planet_home, container, false);

        //set the planet's name
        planetName = v.findViewById(R.id.planetName);
        planetName.setText(planet.getName());

        //set the planet's picture
        clickableImage = v.findViewById(R.id.clickableImage);
        int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        clickableImage.setImageResource(picture);


        //set the show video button
        btnShowVideo = v.findViewById(R.id.btnShowVideo);
        btnShowVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Intent code to go to PlanetVideoFragment


            }
        });

        return v;
    }
}
