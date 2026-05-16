package com.example.projetandroid.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projetandroid.data.dao.CoursDao;
import com.example.projetandroid.data.dao.MatiereDao;
import com.example.projetandroid.data.entity.Cours;
import com.example.projetandroid.data.entity.Matiere;

@Database(entities = {Matiere.class, Cours.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract MatiereDao matiereDao();
    public abstract CoursDao coursDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "cahier_texte_db"
                    ).allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}