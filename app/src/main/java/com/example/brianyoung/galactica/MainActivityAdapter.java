package com.example.brianyoung.galactica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {

    private ArrayList<Planet> mPlanets;
    private LayoutInflater mInflater;
    //private ItemClickListener mListener;
    private RecyclerViewClickListener mListener;

    public MainActivityAdapter(ArrayList<Planet> planets, RecyclerViewClickListener listener) {
        //mInflater = LayoutInflater.from(context);
        mPlanets = planets;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class MainActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView planetName;
        private RecyclerViewClickListener mListener;

        public MainActivityViewHolder(View v, RecyclerViewClickListener listener) {

            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            planetName = v.findViewById(R.id.planetNameList);

        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    // inflates the cell layout from xml when needed
//    @Override
//    @NonNull
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.activity_main_adapter, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Planet planet = mPlanets.get(position);
//        holder.planetNameList.setText(planet.getName());
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return mPlanets.size();
//    }
//
//    // stores and recycles views as they are scrolled off screen
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public TextView planetNameList;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            planetNameList = itemView.findViewById(R.id.planetNameList);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mListener != null) mListener.onItemClick(view, getAdapterPosition());
//        }
//    }
//
//    // allows clicks events to be caught
//    void setClickListener(ItemClickListener itemClickListener) {
//        this.mListener = itemClickListener;
//    }
//
//    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }

    @Override
    public MainActivityAdapter.MainActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_adapter, parent, false);
        return new MainActivityViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder holder, int position) {
        Planet planet = mPlanets.get(position);
        holder.planetName.setText(planet.getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

}

