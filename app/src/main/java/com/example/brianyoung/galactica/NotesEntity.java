package com.example.brianyoung.galactica;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NotesEntity {
    @PrimaryKey
    @NonNull
    public String planetName;
    public String notesContent;

    NotesEntity(String planetName, String notesContent) {
        this.planetName = planetName;
        this.notesContent = notesContent;
    }

    public String getPlanetNameID() {
        return planetName;
    }

    public void setPlanetNameID(String planetName) {
        this.planetName = planetName;
    }

    public String getNotesContent() {
        return notesContent;
    }

    public void setNotesContent(String notesContent) {
        this.notesContent = notesContent;
    }





}

