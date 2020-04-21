package com.example.brianyoung.galactica;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class NotesEntity {
    @PrimaryKey
    @NonNull
    @SerializedName("Planet name")
    @Expose
    private String planetName;
    private String notes;


    @NonNull
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(@NonNull String planetName) {
        this.planetName = planetName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

