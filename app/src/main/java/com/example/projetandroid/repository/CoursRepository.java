package com.example.projetandroid.repository;

import android.content.Context;

import com.example.projetandroid.data.database.AppDatabase;
import com.example.projetandroid.data.entity.Cours;

import java.util.List;

public class CoursRepository {

    private AppDatabase db;

    public CoursRepository(Context context) {
        db = AppDatabase.getInstance(context);
    }

    public void insert(Cours c) { db.coursDao().insert(c); }
    public void update(Cours c) { db.coursDao().update(c); }
    public void delete(Cours c) { db.coursDao().delete(c); }

    public List<Cours> getAll() { return db.coursDao().getAll(); }

    public List<Cours> getByMatiere(int id) {
        return db.coursDao().getByMatiere(id);
    }
}