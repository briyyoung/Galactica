package com.example.brianyoung.galactica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Notes extends AppCompatActivity {
    //declare adapter variables
    RecyclerView rvNotes;
    NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }
}
