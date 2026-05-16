package com.example.projetandroid.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetandroid.data.entity.Matiere;

import java.util.List;

@Dao
public interface MatiereDao {

    @Insert
    void insert(Matiere m);

    @Update
    void update(Matiere m);

    @Delete
    void delete(Matiere m);

    @Query("SELECT * FROM matiere")
    List<Matiere> getAll();

    @Query("SELECT * FROM matiere WHERE id = :id")
    Matiere getById(int id);

    @Query("SELECT * FROM matiere WHERE nom LIKE '%' || :search || '%'")
    List<Matiere> search(String search);
}