package com.example.projetandroid.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cours")
public class Cours {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int matiereId;
    private String dateCours;
    private String heureDebut;
    private double duree;
    private String contenu;

    public Cours(int matiereId, String dateCours, String heureDebut, double duree, String contenu) {
        this.matiereId = matiereId;
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.contenu = contenu;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMatiereId() { return matiereId; }
    public String getDateCours() { return dateCours; }
    public String getHeureDebut() { return heureDebut; }
    public double getDuree() { return duree; }
    public String getContenu() { return contenu; }

    public void setMatiereId(int matiereId) { this.matiereId = matiereId; }
    public void setDateCours(String dateCours) { this.dateCours = dateCours; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }
    public void setDuree(double duree) { this.duree = duree; }
    public void setContenu(String contenu) { this.contenu = contenu; }
}