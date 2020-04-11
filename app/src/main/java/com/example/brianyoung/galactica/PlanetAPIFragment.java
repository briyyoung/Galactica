package com.example.brianyoung.galactica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brianyoung.galactica.Entities.Body;
import com.example.brianyoung.galactica.Entities.PlanetInterface;
import com.example.brianyoung.galactica.Entities.SolarSystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;
import static com.example.brianyoung.galactica.PlanetHomeFragment.ARG_PLANET_NAME_FRAGMENT;

public class PlanetAPIFragment extends Fragment {
    public static final String ARG_PLANET_NAME_API = "Setting what planet we are clicking";

    // TODO: Rename and change types of parameters
    private Planet planet;
    private Body planetBody;
    private TextView bodyNameValue, bodyMoonValue, bodyDateValue;
    private ImageView bodyImage;

    public PlanetAPIFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //receiving the bundle arguments from the activity this fragment is associated with (in this case it is associated with PlanetHomeEntry)
        if(getArguments().containsKey(ARG_PLANET_NAME_FRAGMENT)){
            //to set our own planet class
            planet = Planet.getPlanet(getArguments().getString(ARG_PLANET_NAME_FRAGMENT));

            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.le-systeme-solaire.net")
                    .addConverterFactory(GsonConverterFactory.create()).build();

            //Get service and call object for the request
            PlanetInterface planetInterface = retrofit.create(PlanetInterface.class);
            Call<SolarSystem> solarSystemCall = planetInterface.getPlanetAttributes(planet.getName());

            solarSystemCall.enqueue(new Callback<SolarSystem>() {
                @Override
                public void onResponse(Call<SolarSystem> call, Response<SolarSystem> response) {
                    Log.d(TAG,"onResponse: SUCCESS");
                    List<Body> solarSystemList = response.body().getBodies();

                    for(Body chosenPlanet : solarSystemList){
                        //to set the Body class from API
                        if(chosenPlanet.getEnglishName().equals(getArguments().getString(ARG_PLANET_NAME_FRAGMENT))){
                            planetBody = chosenPlanet;
                            break;
                        }
                    }
                    update();
                    PlanetAPIFragment.this.getActivity().setTitle(planetBody.getEnglishName());
                }

                @Override
                public void onFailure(Call<SolarSystem> call, Throwable t) {
                    Log.d(TAG, "onFailure: FAILURE");
                }
            });
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planet_api, container, false);
        update();
        return v;
    }

    private void update(){
        View v = getView();
        if(planetBody != null){
            ((TextView) v.findViewById(R.id.bodyNameValueActivity)).setText(planetBody.getEnglishName());
            ((TextView) v.findViewById(R.id.bodyDateValueActivity)).setText(planetBody.getDiscoveryDate());

            bodyImage = v.findViewById(R.id.bodyImageActivity);
            int picture = getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
            bodyImage.setImageResource(picture);

            //Need to work on moon later
//            ((TextView) v.findViewById(R.id.bodyMoonValue)).setText(Objects.getMoons());
        }
    }

}
