package com.example.projetandroid.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetandroid.data.entity.Cours;

import java.util.List;

@Dao
public interface CoursDao {

    @Insert
    void insert(Cours cours);

    @Update
    void update(Cours cours);

    @Delete
    void delete(Cours cours);

    @Query("SELECT * FROM cours")
    LiveData<List<Cours>> getAllCours();

    @Query("SELECT * FROM cours WHERE matiereId = :id")
    LiveData<List<Cours>> getCoursByMatiere(int id);

    @Query("SELECT SUM(duree) FROM cours WHERE matiereId = :id")
    Integer getTotalHeuresByMatiere(int id);
}