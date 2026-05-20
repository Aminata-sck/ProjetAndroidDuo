package com.example.projetandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.data.entity.Matiere;
import com.example.projetandroid.repository.MatiereRepository;

import java.util.ArrayList;
import java.util.List;

public class MatiereActivity extends AppCompatActivity {

    EditText etNom, etUe, etProf, etVolume;
    Button btnAjouter;
    ListView listView;

    MatiereRepository repo;
    MatiereAdapter adapter;
    List<Matiere> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);

        etNom = findViewById(R.id.etNom);
        etUe = findViewById(R.id.etUe);
        etProf = findViewById(R.id.etProf);
        etVolume = findViewById(R.id.etVolume);
        btnAjouter = findViewById(R.id.btnAjouter);
        listView = findViewById(R.id.listMatieres);

        repo = new MatiereRepository(getApplicationContext());

        adapter = new MatiereAdapter(this, list);
        listView.setAdapter(adapter);

        charger();

        btnAjouter.setOnClickListener(v -> {

            String nom = etNom.getText().toString();
            String ue = etUe.getText().toString();
            String prof = etProf.getText().toString();
            double volume = Double.parseDouble(etVolume.getText().toString());

            Matiere m = new Matiere(nom, ue, prof, volume);

            repo.insert(m);

            charger();
        });
    }

    private void charger() {
        list = repo.getAll();
        adapter.updateList(list);
    }
}