package com.example.projetandroid.ui.cours;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetandroid.R;
import com.example.projetandroid.data.entity.Cours;
import com.example.projetandroid.viewmodel.CoursViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddCoursActivity extends AppCompatActivity {

    private Spinner spinnerMatiere;
    private EditText editDate, editHeure, editDuree, editContenu;
    private Button btnAjouter;

    private CoursViewModel coursViewModel;

    private List<Integer> matiereIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cours);

        spinnerMatiere = findViewById(R.id.spinnerMatiere);
        editDate = findViewById(R.id.editDate);
        editHeure = findViewById(R.id.editHeure);
        editDuree = findViewById(R.id.editDuree);
        editContenu = findViewById(R.id.editContenu);
        btnAjouter = findViewById(R.id.btnAjouter);

        coursViewModel = new ViewModelProvider(this).get(CoursViewModel.class);

        // Charger matières
        chargerMatieres();

        btnAjouter.setOnClickListener(v -> ajouterCours());
    }

    private void ajouterCours() {

        String date = editDate.getText().toString();
        String heure = editHeure.getText().toString();
        String contenu = editContenu.getText().toString();

        // VALIDATION CHAMPS
        if (date.isEmpty() || heure.isEmpty() || contenu.isEmpty()) {
            Toast.makeText(this, "Remplis tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        int duree;

        try {
            duree = Integer.parseInt(editDuree.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Durée invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        if (duree <= 0) {
            Toast.makeText(this, "Durée invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        // Récupérer matière sélectionnée
        int position = spinnerMatiere.getSelectedItemPosition();
        int matiereId = matiereIds.get(position);

        // ✅ VÉRIFICATION DÉPASSEMENT HORAIRE

        int volumeTotal = 36;

        int heuresEffectuees = 0;

        int heuresRestantes = volumeTotal - heuresEffectuees;

        if (heuresEffectuees + duree > volumeTotal) {

            Toast.makeText(
                    this,
                    "Volume horaire dépassé",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // CRÉATION DU COURS
        Cours cours = new Cours(
                matiereId,
                date,
                heure,
                duree,
                contenu
        );

        // INSERTION ROOM
        coursViewModel.insert(cours);

        Toast.makeText(this,
                "Cours ajouté avec succès",
                Toast.LENGTH_SHORT).show();

        // Vider champs
        editDate.setText("");
        editHeure.setText("");
        editDuree.setText("");
        editContenu.setText("");
    }

    // VERSION SIMPLE TEMPORAIRE
    private void chargerMatieres() {

        List<String> matieres = new ArrayList<>();

        matieres.add("Java");
        matieres.add("Maths");

        matiereIds.add(1);
        matiereIds.add(2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                matieres
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerMatiere.setAdapter(adapter);
    }
}