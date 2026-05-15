package com.example.projetandroid.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.projetandroid.data.dao.CoursDao;
import com.example.projetandroid.data.database.AppDatabase;
import com.example.projetandroid.data.entity.Cours;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoursRepository {

    private final CoursDao coursDao;
    private final LiveData<List<Cours>> allCours;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CoursRepository(Application application) {

        AppDatabase database = AppDatabase.getInstance(application);
        coursDao = database.coursDao();

        allCours = coursDao.getAllCours();
    }

    public void insert(Cours cours) {
        executorService.execute(() -> coursDao.insert(cours));
    }

    public void update(Cours cours) {
        executorService.execute(() -> coursDao.update(cours));
    }

    public void delete(Cours cours) {
        executorService.execute(() -> coursDao.delete(cours));
    }

    public LiveData<List<Cours>> getAllCours() {
        return allCours;
    }

    public LiveData<List<Cours>> getCoursByMatiere(int matiereId) {
        return coursDao.getCoursByMatiere(matiereId);
    }
}