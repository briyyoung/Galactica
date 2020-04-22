package com.example.brianyoung.galactica;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NotesDao {
    //Select notes based on its planetName
    @Query("SELECT * FROM NotesEntity WHERE planetName = :planetName")
    NotesEntity getNotesByPlanetName(String planetName);

    @Insert
    void insert(NotesEntity... notes);

    @Update
    void update(NotesEntity... notes);

    @Delete
    void delete(NotesEntity...notes);
}
