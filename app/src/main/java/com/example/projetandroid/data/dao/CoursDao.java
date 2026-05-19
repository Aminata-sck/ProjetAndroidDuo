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

    // Tous les cours (LiveData pour observer dans UI)
    @Query("SELECT * FROM cours ORDER BY id DESC")
    LiveData<List<Cours>> getAllCours();

    // Cours par matière
    @Query("SELECT * FROM cours WHERE matiereId = :matiereId")
    LiveData<List<Cours>> getCoursByMatiere(int matiereId);

    // Somme des heures
    @Query("SELECT SUM(duree) FROM cours WHERE matiereId = :matiereId")
    Integer getTotalHeuresByMatiere(int matiereId);
}