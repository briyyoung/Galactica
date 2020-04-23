package com.example.brianyoung.galactica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    public ArrayList<Planet> notesPlanet;
    public RecyclerViewClickListener notesListener;

    public NotesAdapter(ArrayList<Planet> planets, RecyclerViewClickListener listener) {
        notesPlanet = planets;
        notesListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView planetNameNotes;
        public ImageView planetPicNotes;
        private RecyclerViewClickListener notesListener;

        public NotesViewHolder(View v, RecyclerViewClickListener listener) {

            super(v);
            notesListener = listener;
            v.setOnClickListener(this);
            planetNameNotes = v.findViewById(R.id.planetNameNotes);
            planetPicNotes = v.findViewById(R.id.planetPicNotes);

        }

        @Override
        public void onClick(View view) {
            notesListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notes_adapter, parent, false);
        return new NotesViewHolder(v, notesListener);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.NotesViewHolder holder, int position) {
        Planet planet = notesPlanet.get(position);
        holder.planetNameNotes.setText(planet.getName());

        int picture = holder.itemView.getContext().getResources().getIdentifier("pic_" + planet.getPicture(),"drawable","com.example.brianyoung.galactica");
        holder.planetPicNotes.setImageResource(picture);
    }

    @Override
    public int getItemCount() {
        return notesPlanet.size();
    }
}
