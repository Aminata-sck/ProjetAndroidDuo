package com.example.projetandroid.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projetandroid.data.entity.Cours;
import com.example.projetandroid.repository.CoursRepository;

import java.util.List;

public class CoursViewModel extends AndroidViewModel {

    private final CoursRepository repository;
    private final LiveData<List<Cours>> allCours;

    public CoursViewModel(@NonNull Application application) {
        super(application);
        repository = new CoursRepository(application);
        allCours = repository.getAllCours();
    }

    public void insert(Cours cours) {
        repository.insert(cours);
    }

    public void update(Cours cours) {
        repository.update(cours);
    }

    public void delete(Cours cours) {
        repository.delete(cours);
    }

    public LiveData<List<Cours>> getAllCours() {
        return allCours;
    }
}