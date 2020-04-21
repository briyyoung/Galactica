package com.example.brianyoung.galactica;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {NotesEntity.class}, version = 1)
    public abstract class NotesDatabase extends RoomDatabase {
        public abstract NotesDao getNotesDao();

    }
