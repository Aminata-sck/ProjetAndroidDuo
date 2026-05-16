package com.example.projetandroid.data.dao;

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
    void insert(Cours c);

    @Update
    void update(Cours c);

    @Delete
    void delete(Cours c);

    @Query("SELECT * FROM cours")
    List<Cours> getAll();

    @Query("SELECT * FROM cours WHERE matiereId = :id")
    List<Cours> getByMatiere(int id);
}