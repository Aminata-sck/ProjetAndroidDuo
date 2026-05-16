package com.example.projetandroid.ui.cours;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetandroid.R;
import com.example.projetandroid.adapter.CoursAdapter;
import com.example.projetandroid.viewmodel.CoursViewModel;

public class ListCoursActivity extends AppCompatActivity {

    private RecyclerView recyclerCours;

    private CoursAdapter adapter;

    private CoursViewModel coursViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_cours);

        recyclerCours =
                findViewById(R.id.recyclerCours);

        recyclerCours.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerCours.setHasFixedSize(true);

        adapter = new CoursAdapter();

        recyclerCours.setAdapter(adapter);

        coursViewModel =
                new ViewModelProvider(this)
                        .get(CoursViewModel.class);


        // Suppression au clic long

        adapter.setOnItemLongClickListener(cours -> {

            coursViewModel.delete(cours);

        });


        // affichage automatique

        coursViewModel
                .getAllCours()
                .observe(this, cours -> {

                    adapter.setCoursList(cours);

                });

    }
}