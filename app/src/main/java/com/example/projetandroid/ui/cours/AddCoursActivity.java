package com.example.projetandroid.ui.cours;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        coursViewModel =
                new ViewModelProvider(this)
                        .get(CoursViewModel.class);

        chargerMatieres();

        btnAjouter.setOnClickListener(
                v -> ajouterCours()
        );
    }

    private void ajouterCours() {

        String date =
                editDate.getText().toString().trim();

        String heure =
                editHeure.getText().toString().trim();

        String contenu =
                editContenu.getText().toString().trim();

        // Vérification champs vides

        if (date.isEmpty()
                || heure.isEmpty()
                || contenu.isEmpty()) {

            Toast.makeText(
                    this,
                    "Remplis tous les champs",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        int duree;

        try {

            duree =
                    Integer.parseInt(
                            editDuree.getText()
                                    .toString()
                    );

        } catch (Exception e) {

            Toast.makeText(
                    this,
                    "Durée invalide",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (duree <= 0) {

            Toast.makeText(
                    this,
                    "La durée doit être > 0",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // matière choisie

        int position =
                spinnerMatiere
                        .getSelectedItemPosition();

        int matiereId =
                matiereIds.get(position);

        // Exemple temporaire volume total

        int volumeTotal = 36;

        Integer heuresEffectuees =
                coursViewModel
                        .getTotalHeuresByMatiere(
                                matiereId
                        );

        if (heuresEffectuees == null) {

            heuresEffectuees = 0;
        }

        int heuresRestantes =
                volumeTotal - heuresEffectuees;

        // Vérification dépassement

        if ((heuresEffectuees + duree)
                > volumeTotal) {

            Toast.makeText(
                    this,
                    "Volume horaire dépassé",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Création du cours

        Cours cours =
                new Cours(
                        matiereId,
                        date,
                        heure,
                        duree,
                        contenu
                );

        coursViewModel.insert(cours);

        Toast.makeText(
                this,
                "Cours ajouté\nHeures restantes : "
                        + (heuresRestantes - duree)
                        + "h",
                Toast.LENGTH_LONG
        ).show();

        viderChamps();
    }

    private void viderChamps() {

        editDate.setText("");

        editHeure.setText("");

        editDuree.setText("");

        editContenu.setText("");
    }

    private void chargerMatieres() {

        List<String> matieres =
                new ArrayList<>();

        // temporaire jusqu'au merge Git

        matieres.add("Java");
        matieres.add("Maths");

        matiereIds.add(1);
        matiereIds.add(2);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
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