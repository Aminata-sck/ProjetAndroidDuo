package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.ui.cours.CoursActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCours=findViewById(R.id.btnCours);

        btnCours.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            CoursActivity.class
                    );

            startActivity(intent);

        });

    }
}