package com.example.projetandroid.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.projetandroid.data.database.AppDatabase;
import com.example.projetandroid.data.dao.CoursDao;
import com.example.projetandroid.data.entity.Cours;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoursRepository {

    private final CoursDao coursDao;
    private final LiveData<List<Cours>> allCours;

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    public CoursRepository(Application application) {

        AppDatabase db = AppDatabase.getInstance(application);

        coursDao = db.coursDao();

        allCours = coursDao.getAllCours();
    }

    public void insert(Cours c) {
        executor.execute(() -> coursDao.insert(c));
    }

    public void update(Cours c) {
        executor.execute(() -> coursDao.update(c));
    }

    public void delete(Cours c) {
        executor.execute(() -> coursDao.delete(c));
    }

    public LiveData<List<Cours>> getAllCours() {
        return allCours;
    }

    public LiveData<List<Cours>> getCoursByMatiere(int id) {
        return coursDao.getCoursByMatiere(id);
    }

    public Integer getTotalHeuresByMatiere(int id) {
        return coursDao.getTotalHeuresByMatiere(id);
    }
}