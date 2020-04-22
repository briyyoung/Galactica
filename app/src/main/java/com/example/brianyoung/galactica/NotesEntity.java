package com.example.brianyoung.galactica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NotesEntity {
    @PrimaryKey
    public int id;
    public String notesContent;

    NotesEntity(int id, String notesContent) {
        this.id = id;
        this.notesContent = notesContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotesContent() {
        return notesContent;
    }

    public void setNotesContent(String notesContent) {
        this.notesContent = notesContent;
    }





}

