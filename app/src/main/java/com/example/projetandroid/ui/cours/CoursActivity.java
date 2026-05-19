package com.example.projetandroid.ui.cours;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetandroid.R;
import com.example.projetandroid.viewmodel.CoursViewModel;

public class CoursActivity extends AppCompatActivity {

    private TextView txtHeuresEffectuees;
    private TextView txtHeuresRestantes;
    private ProgressBar progressHeures;

    private CoursViewModel coursViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        txtHeuresEffectuees =
                findViewById(R.id.txtHeuresEffectuees);

        txtHeuresRestantes =
                findViewById(R.id.txtHeuresRestantes);

        progressHeures =
                findViewById(R.id.progressHeures);

        coursViewModel =
                new ViewModelProvider(this)
                        .get(CoursViewModel.class);

        int volumeTotal = 36;

        // Matière exemple (Java = id 1)
        int matiereId = 1;

        // récupérer vraie valeur depuis Room
        int heuresEffectuees =
                coursViewModel.getTotalHeuresByMatiere(
                        matiereId
                );

        int heuresRestantes =
                volumeTotal - heuresEffectuees;

        txtHeuresEffectuees.setText(
                "Heures effectuées : "
                        + heuresEffectuees + " h"
        );

        txtHeuresRestantes.setText(
                "Heures restantes : "
                        + heuresRestantes + " h"
        );

        progressHeures.setMax(volumeTotal);

        progressHeures.setProgress(
                heuresEffectuees
        );
    }
}