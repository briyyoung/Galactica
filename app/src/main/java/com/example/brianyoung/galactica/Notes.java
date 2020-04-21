package com.example.brianyoung.galactica;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputLayout;

public class Notes extends AppCompatActivity {
    //declare adapter variables
    RecyclerView rvNotes;
    NotesAdapter notesAdapter;
    NotesDatabase mDb;
    public static final String ARG_NOTES = " ";
    private TextInputLayout textFieldNotes;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        textFieldNotes = findViewById(R.id.textFieldNotes);
        btnSubmit = findViewById(R.id.btnSubmit);

        //Create database
        mDb = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes-database").build();

//        //Getting user's notes
//        String userTypeNotes = String.valueOf(textFieldNotes.getEditText().getText());

        //submit the notes button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert notes by executing AsyncTask
                new StoreUserNotes().execute();
                System.out.println("AsyncTask works!");
            }
        });

    }

    private class StoreUserNotes extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... ids) {
            //to save notes
            String userTypeNotes = String.valueOf(textFieldNotes.getEditText().getText());

            //Get notes first
            NotesEntity currentNotes = mDb.getNotesDao().getNotes();

            //if statement here to see whether we need to update or insert
            if(currentNotes == null){
                mDb.getNotesDao().insert(new NotesEntity(1, userTypeNotes));
                System.out.println("New notes is inserted!");
            } else {
                mDb.getNotesDao().update(new NotesEntity(1, userTypeNotes));
                System.out.println("Notes is updated!");
            }

            return null;
        }

//        @Override
//        protected void onPostExecute(NotesEntity notesEntity) {
//            //What will happen after successfully saving notes
//            System.out.println("Notes is saved!");
//        }
    }
}
