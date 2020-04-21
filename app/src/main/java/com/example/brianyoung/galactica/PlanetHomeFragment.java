package com.example.brianyoung.galactica;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

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
    private Button btnAPI;
    private ImageView clickableImage;
    private TextView planetName, briefDesc;


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

        //set the planet's description
        briefDesc = v.findViewById(R.id.briefDesc);
        briefDesc.setText(planet.getDescription());

        return v;
    }






}
