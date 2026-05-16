package com.example.projetandroid.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "matiere")
public class Matiere {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;
    private String ue;
    private String professeur;
    private double volumeHoraire;

    public Matiere(String nom, String ue, String professeur, double volumeHoraire) {
        this.nom = nom;
        this.ue = ue;
        this.professeur = professeur;
        this.volumeHoraire = volumeHoraire;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public String getUe() { return ue; }
    public String getProfesseur() { return professeur; }
    public double getVolumeHoraire() { return volumeHoraire; }

    public void setNom(String nom) { this.nom = nom; }
    public void setUe(String ue) { this.ue = ue; }
    public void setProfesseur(String professeur) { this.professeur = professeur; }
    public void setVolumeHoraire(double volumeHoraire) { this.volumeHoraire = volumeHoraire; }
}