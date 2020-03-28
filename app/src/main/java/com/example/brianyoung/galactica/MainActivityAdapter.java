package com.example.brianyoung.galactica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {

    private ArrayList<Planet> mPlanets;
    private RecyclerViewClickListener mListener;

    public MainActivityAdapter(ArrayList<Planet> planets, RecyclerViewClickListener listener) {
        mPlanets = planets;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class MainActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView planetName;
        public ImageView planetPic;
        private RecyclerViewClickListener mListener;

        public MainActivityViewHolder(View v, RecyclerViewClickListener listener) {

            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            planetName = v.findViewById(R.id.planetNameList);
            planetPic = v.findViewById(R.id.planetPicList);

        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public MainActivityAdapter.MainActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_adapter, parent, false);
        return new MainActivityViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder holder, int position) {
        Planet planet = mPlanets.get(position);
        holder.planetName.setText(planet.getName());
        
        int picture = holder.itemView.getContext().getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        holder.planetPic.setImageResource(picture);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

}

