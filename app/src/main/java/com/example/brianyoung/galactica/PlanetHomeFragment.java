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

    public static final String ARG_PLANET_NAME = "Setting what planet we are clicking";

    // TODO: Rename and change types of parameters
    private Planet planet;
    private Button btnShowVideo, btnMoreInfo;
    private ImageView clickableImage;
    private TextView planetName;
    private boolean mTwoPane;
    private View.OnClickListener moreInfoListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Planet planet = (Planet) view.getTag();
        if(mTwoPane) {
            //Intent code to go to PlanetDetailFragment
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PlanetDetailFragment detailFragment = new PlanetDetailFragment();

            //Using Bundle to send data
            Bundle bundle = new Bundle();
            bundle.putString(PlanetHomeFragment.ARG_PLANET_NAME, planet.getName());
            detailFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.detail_container, detailFragment);
            fragmentTransaction.commit();
        } else {
            Context context = view.getContext();
            Intent intent = new Intent(context, PlanetDetailContainer.class);
            intent.putExtra(PlanetHomeFragment.ARG_PLANET_NAME, planet.getName());
            context.startActivity(intent);
            }
        }
    };

    public PlanetHomeFragment() {

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
        View v = inflater.inflate(R.layout.fragment_planet_home, container, false);

        //set the planet's name
        planetName = v.findViewById(R.id.planetName);
        planetName.setText(planet.getName());

        //set the planet's picture
        clickableImage = v.findViewById(R.id.clickableImage);
        int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        clickableImage.setImageResource(picture);

        //set the more info button
        btnMoreInfo = v.findViewById(R.id.btnMoreInfo);
        btnMoreInfo.setTag(planet);
        btnMoreInfo.setOnClickListener(moreInfoListener);

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
