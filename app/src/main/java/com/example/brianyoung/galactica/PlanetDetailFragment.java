package com.example.brianyoung.galactica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.brianyoung.galactica.PlanetHomeFragment.ARG_PLANET_NAME;

public class PlanetDetailFragment extends Fragment {
    public static final String ARG_PLANET_NAME_DETAIL = "Setting what planet we are clicking";

    // TODO: Rename and change types of parameters
    private Planet planet;
    private Button btnQuizPlanet;
    private ImageView planetImageDetail;
    private TextView planetNameDetail, planetDescDetail;

    public PlanetDetailFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get arguments from activity
        if(getArguments().containsKey(ARG_PLANET_NAME)){
            planet = Planet.getPlanet(getArguments().getString(ARG_PLANET_NAME));
            this.getActivity().setTitle(planet.getName());

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planet_detail, container, false);

        //set the planet's name
        planetNameDetail = v.findViewById(R.id.planetNameDetail);
        planetNameDetail.setText(planet.getName());

        //set the planet's picture
        planetImageDetail = v.findViewById(R.id.planetImageDetail);
        int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        planetImageDetail.setImageResource(picture);

        //set the description text
        planetDescDetail = v.findViewById(R.id.planetDescDetail);
        planetDescDetail.setText(planet.getDescription());

        //set the quiz button
        btnQuizPlanet = v.findViewById(R.id.btnQuizPlanet);
        btnQuizPlanet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Intent code to go to quiz fragment


            }
        });

        return v;
    }
}
