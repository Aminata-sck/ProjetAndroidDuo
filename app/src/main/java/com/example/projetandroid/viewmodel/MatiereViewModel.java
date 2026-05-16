package com.example.projetandroid.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.projetandroid.data.entity.Matiere;
import com.example.projetandroid.repository.MatiereRepository;

import java.util.List;

public class MatiereViewModel extends AndroidViewModel {

    private MatiereRepository repo;

    public MatiereViewModel(@NonNull Application application) {
        super(application);
        repo = new MatiereRepository(application);
    }

    public void insert(Matiere m) { repo.insert(m); }
    public void update(Matiere m) { repo.update(m); }
    public void delete(Matiere m) { repo.delete(m); }

    public List<Matiere> getAll() { return repo.getAll(); }
}