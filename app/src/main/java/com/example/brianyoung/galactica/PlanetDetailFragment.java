package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brianyoung.galactica.Entities.PlanetInterface;
import com.example.brianyoung.galactica.Entities.SolarSystem;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.brianyoung.galactica.PlanetHomeFragment.ARG_PLANET_NAME_FRAGMENT;

public class PlanetDetailFragment extends Fragment {
    public static final String ARG_PLANET_NAME_DETAIL = "Setting what planet we are clicking";
    private static final String TAG = "";

    // TODO: Rename and change types of parameters
    private SolarSystem solarSystem;
    private Planet planet;
    private Button btnQuizPlanet;
    private ImageView planetImageDetail;
    private TextView planetNameDetail;
    private TextView density, gravity, meanRadius, equaradius, dimension, eccentricity, discoveredBy, discoveryDate;
    private SpannableStringBuilder spannableStringBuilder;
    private String unit;
    public PlanetDetailFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get arguments from activity
        if(getArguments().containsKey(ARG_PLANET_NAME_FRAGMENT)){
            planet = Planet.getPlanet(getArguments().getString(ARG_PLANET_NAME_FRAGMENT));
            new GetSolarSystemTask().execute();
            Log.d(TAG, "onCreate: GETSOLARSYSTEMTASK EXECUTED");
        }
    }

    //Implenting API calls using ASYNC task
    private class GetSolarSystemTask extends AsyncTask<Void, Void, SolarSystem> {
        
        @Override
        protected SolarSystem doInBackground(Void... voids) { //Get list of coins
            try {
                Log.d(TAG, "doInBackground: SUCCESS");
                //Create Retrofit instance & parse the retrieved JSON using the GSON deserializer
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.le-systeme-solaire.net")
                        .addConverterFactory(GsonConverterFactory.create()).build();

                //Get service & call object for the request
                PlanetInterface planetInterface = retrofit.create(PlanetInterface.class);
                Call<SolarSystem> solarSystemCall = planetInterface.getPlanetAttributes(planet.getName());

                //execute network request
                Response<SolarSystem> solarSystemResponse = solarSystemCall.execute();
                SolarSystem solarSystemAPI = solarSystemResponse.body(); //gets planet object
                return solarSystemAPI;
            } catch (IOException e){
                Log.d(TAG, "onFailure: FAILURE");
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(SolarSystem solarSystemExecute){
            //Assign planet
            solarSystem = solarSystemExecute;
            Log.d(TAG, "onPostExecute: Solar system API connected");
            updateUi();
            Log.d(TAG, "onPostExecute: UI updated!");
            PlanetDetailFragment.this.getActivity().setTitle(solarSystem.getEnglishName()); //null??
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planet_detail, container, false);
        updateUi();
        return v;
    }

    private void updateUi(){
        View v = getView();

        if (solarSystem != null){
            //set the planet's name
            planetNameDetail = v.findViewById(R.id.planetNameDetail);
            planetNameDetail.setText(solarSystem.getEnglishName());

            //set the planet's picture
            planetImageDetail = v.findViewById(R.id.planetImageDetail);
            int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
            planetImageDetail.setImageResource(picture);

            //set the description text
            density = v.findViewById(R.id.density);
            density.setText(solarSystem.getDensity() + ""); //density
            gravity = v.findViewById(R.id.gravity);
            gravity.setText(solarSystem.getGravity() + ""); //gravity
            meanRadius = v.findViewById(R.id.meanRadius);
            meanRadius.setText(solarSystem.getMeanRadius() + ""); //meanRadius
            equaradius = v.findViewById(R.id.equaradius);
            equaradius.setText(solarSystem.getEquaRadius() + ""); //equaradius


            dimension = v.findViewById(R.id.dimension);
            if(solarSystem.getDimension().trim().length() > 0) {
                dimension.setText(solarSystem.getDimension()); //dimension
            } else {
                dimension.setText("N/A");
            }

            eccentricity = v.findViewById(R.id.eccentricity);
            eccentricity.setText(solarSystem.getEccentricity() + ""); //eccentricity

            discoveredBy = v.findViewById(R.id.discoveredBy);
            if(solarSystem.getDiscoveredBy().trim().length() > 0) {
                discoveredBy.setText(solarSystem.getDiscoveredBy()); //discoveredBy
            } else {
                discoveredBy.setText("N/A");
            }

            discoveryDate = v.findViewById(R.id.discoveryDate);
            if(solarSystem.getDiscoveryDate().trim().length() > 0) {
                discoveryDate.setText(solarSystem.getDiscoveryDate()); //discoveryDate
            } else {
                discoveryDate.setText("N/A");
            }


            //set the quiz button
            btnQuizPlanet = v.findViewById(R.id.btnQuizPlanet);
            btnQuizPlanet.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //Intent code to go to quiz fragment
                    launchPlanetQuiz(planet.getName());

                }
            });
        }

    }

    public void launchPlanetQuiz(String planetName){
        Intent intent = new Intent(PlanetDetailFragment.this.getActivity(),PlanetQuiz.class);
        intent.putExtra(PlanetQuiz.ARG_PLANET_QUIZ, planetName);
        startActivity(intent);
    }

}
