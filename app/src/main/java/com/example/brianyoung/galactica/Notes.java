package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.google.android.material.textfield.TextInputLayout;

public class Notes extends AppCompatActivity {
    NotesDatabase mDb;
    private TextInputLayout textFieldNotes;
    private Button btnSave, btnEditNotes;
    private EditText editText;
    private TextView planetNameWriteNotes;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        textFieldNotes = findViewById(R.id.textFieldNotes);
        btnSave = findViewById(R.id.btnSave);
        editText = findViewById(R.id.editText);
        btnEditNotes = findViewById(R.id.btnEditNotes);
        planetNameWriteNotes = findViewById(R.id.planetNameWriteNotes);
        btnShare = findViewById(R.id.btnShare);

        //extract argument (planet.getName) from the intent in NotesList.class
        Intent intent = getIntent();
        String planetName = intent.getStringExtra(NotesList.MESSAGE);
        planetNameWriteNotes.setText(planetName);

        //create the database
        mDb = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes-database").build();

        //submit notes button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert notes by executing AsyncTask
                new StoreUserNotes().execute(intent.getStringExtra(NotesList.MESSAGE));
                System.out.println("AsyncTask works!");
                Toast toast = Toast.makeText(getApplicationContext(), "Note has been saved", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        //store saved notes button
        btnEditNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetUserNotes().execute(intent.getStringExtra(NotesList.MESSAGE));
                //Display the saved notes
                System.out.println("Previous notes is stored");
            }
        });

        //share notes button
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ShareUserNotes().execute(intent.getStringExtra(NotesList.MESSAGE));
            }
        });

    }

    private class StoreUserNotes extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... ids) {
            //to save notes
            String userTypeNotes = String.valueOf(textFieldNotes.getEditText().getText());

            //get notes first
            NotesEntity currentNotes = mDb.getNotesDao().getNotesByPlanetName(ids[0]);

            //if statement here to see whether we need to update or insert
            if (currentNotes == null) {
                mDb.getNotesDao().insert(new NotesEntity(ids[0], userTypeNotes));
                System.out.println("New notes is inserted!");

            } else {
                mDb.getNotesDao().update(new NotesEntity(ids[0], userTypeNotes));
                System.out.println("Notes is updated!");

            }
            return null;
        }
    }

        private class GetUserNotes extends AsyncTask<String, Void, NotesEntity> {
            @Override
            protected NotesEntity doInBackground(String... ids) {
                //get saved notes
                NotesEntity savedNotes = mDb.getNotesDao().getNotesByPlanetName(ids[0]);
                return savedNotes;
            }

            @Override
            protected void onPostExecute(NotesEntity notesEntity) {
                if(notesEntity != null) {
                    if (notesEntity.getNotesContent().trim().length() > 0) {
                        editText.setText(notesEntity.getNotesContent());
                        System.out.println("Notes is retrieved!");
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "You don't have any saved notes yet!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "You don't have any saved notes yet!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        }

    private class ShareUserNotes extends AsyncTask<String, Void, NotesEntity> {
        @Override
        protected NotesEntity doInBackground(String... ids) {
            //get saved notes
            NotesEntity savedNotes = mDb.getNotesDao().getNotesByPlanetName(ids[0]);
            return savedNotes;
        }

        @Override
        protected void onPostExecute(NotesEntity notesEntity) {
            if(notesEntity != null) {
                if (notesEntity.getNotesContent().trim().length() > 0) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi This is my notes for Planet " + notesEntity.getPlanetNameID());
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "" + notesEntity.getNotesContent());
                    startActivity(Intent.createChooser(shareIntent, "Share to "));
                } else {
                    editText.setHint("You don't have any notes yet!");
                }
            } else {
                editText.setHint("You don't have any notes yet!");
            }
        }
    }
    }


