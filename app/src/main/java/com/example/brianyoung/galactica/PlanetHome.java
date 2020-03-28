package com.example.brianyoung.galactica;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlanetHome extends Fragment {

    private static final String ARG_PLANET_NAME = "param1";

    // TODO: Rename and change types of parameters
    private Planet planet;
    private Button btnShowVideo, btnMoreInfo;
    private ImageView clickableImage;
    private TextView planetName;


    public PlanetHome() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get arguments from activity
        if(getArguments().containsKey(ARG_PLANET_NAME)){ //receiving the bundle arguments from the activity this fragment is associated with
            planet = Planet.getPlanet(getArguments().getString(ARG_PLANET_NAME));
            this.getActivity().setTitle(planet.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planet_home, container, false);

        //TODO: Initialise the fragment's UI elements by finding them in the fragment layout
        btnShowVideo = v.findViewById(R.id.btnShowVideo);
        planetName = v.findViewById(R.id.planetName);
        btnMoreInfo = v.findViewById(R.id.btnMoreInfo);
        clickableImage = v.findViewById(R.id.clickableImage);

        //TODO: Display the details of the selected City using the fragment's UI elements
        btnShowVideo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Intent code to go to activity 3



            }
        });



        return v;
    }

    //method to go to activity 3 (show video)
//    public void launchShowVideo(Planet planet, int position){
//        Intent intent = new Intent(this, //activity3.class);
//        intent.putExtra()
//
//    }

}
