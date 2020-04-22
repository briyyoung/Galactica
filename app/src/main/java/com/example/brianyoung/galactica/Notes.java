package com.example.brianyoung.galactica;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private Button btnSubmit, btnPreviousNotes;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        textFieldNotes = findViewById(R.id.textFieldNotes);
        btnSubmit = findViewById(R.id.btnSubmit);
        editText = findViewById(R.id.editText);
        btnPreviousNotes = findViewById(R.id.btnPreviousNotes);

        //Create database
        mDb = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes-database").build();

        //submit the notes button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert notes by executing AsyncTask
                new StoreUserNotes().execute();
                System.out.println("AsyncTask works!");
            }
        });

        //store saved notes button
        btnPreviousNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetUserNotes().execute();
                //Display the saved notes
                System.out.println("Previous notes is stored");
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
            if (currentNotes == null) {
                mDb.getNotesDao().insert(new NotesEntity(1, userTypeNotes));
                System.out.println("New notes is inserted!");
            } else {
                mDb.getNotesDao().update(new NotesEntity(1, userTypeNotes));
                System.out.println("Notes is updated!");
            }
            return null;
        }
    }

        private class GetUserNotes extends AsyncTask<Void, Void, NotesEntity> {
            @Override
            protected NotesEntity doInBackground(Void... voids) {
                //Get saved notes
                NotesEntity savedNotes = mDb.getNotesDao().getNotes();
                return savedNotes;
            }

            @Override
            protected void onPostExecute(NotesEntity notesEntity) {
                if (notesEntity.getNotesContent().trim().length() > 0) {
                    editText.setText(notesEntity.getNotesContent());
                    System.out.println("Notes is retrieved!");
                } else {
                    editText.setHint("You don't have any saved notes yet!");
                }
            }
        }
    }


