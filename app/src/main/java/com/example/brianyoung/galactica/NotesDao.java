package com.example.brianyoung.galactica;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM NotesEntity")
    List<NotesEntity> getNotes();

    @Insert
    void insert(NotesEntity notes);

    @Update
    void update(NotesEntity repos);

    @Delete
    void delete(NotesEntity...notes);
}
