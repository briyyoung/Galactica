package com.example.brianyoung.galactica;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class PlanetHomeFragment extends Fragment {

    public static final String ARG_PLANET_NAME_FRAGMENT = " ";
    private Planet planet;
    private Button btnNotes;
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
        //set the image click button
        clickableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        //set the planet's description
        briefDesc = v.findViewById(R.id.briefDesc);
        briefDesc.setText(planet.getDescription());

        //set the notes button
        btnNotes = v.findViewById(R.id.btnNotes);
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNotes();
            }
        });

        return v;
    }

    public void launchNotes(){
        Intent intent = new Intent(getActivity(), NotesList.class);
        startActivity(intent);
    }

    public void customDialog(){
        final Dialog mDialog = new Dialog(getContext());
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
