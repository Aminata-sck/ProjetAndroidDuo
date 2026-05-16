package com.example.projetandroid.repository;

import android.content.Context;

import com.example.projetandroid.data.database.AppDatabase;
import com.example.projetandroid.data.entity.Matiere;

import java.util.List;

public class MatiereRepository {

    private AppDatabase db;

    public MatiereRepository(Context context) {
        db = AppDatabase.getInstance(context);
    }

    public void insert(Matiere m) { db.matiereDao().insert(m); }
    public void update(Matiere m) { db.matiereDao().update(m); }
    public void delete(Matiere m) { db.matiereDao().delete(m); }

    public List<Matiere> getAll() { return db.matiereDao().getAll(); }
}