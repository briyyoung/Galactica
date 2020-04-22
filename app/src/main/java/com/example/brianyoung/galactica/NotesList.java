package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotesList extends AppCompatActivity {
    public static final String MESSAGE = "This is from NotesList";
    private static final String TAG = "";
    private RecyclerView notesRecyclerView;
    private RecyclerView.Adapter notesAdapter;
    private RecyclerView.LayoutManager notesLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_recycler_view);

        //setting the recycler view for the notes list
        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setHasFixedSize(true);
        notesLayoutManager = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(notesLayoutManager);

        //launch Notes.class, where user can type notes
        NotesAdapter.RecyclerViewClickListener listener = new NotesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Planet planet = Planet.getPlanets().get(position);
                launchNotes(planet.getName());
            }
        };

        notesAdapter = new NotesAdapter(Planet.getPlanets(), listener);
        notesRecyclerView.setAdapter(notesAdapter);
    }

    //the method to launch notes class
    private void launchNotes(String planetName) {
        Intent intent = new Intent(NotesList.this, Notes.class);
        intent.putExtra(MESSAGE, planetName);
        startActivity(intent);
    }
}
