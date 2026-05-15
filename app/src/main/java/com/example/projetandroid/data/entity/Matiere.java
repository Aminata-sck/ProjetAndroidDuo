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
    private int volumeHoraire;

    // ✔ constructeur vide OBLIGATOIRE pour Room
    public Matiere() {
    }

    // ✔ GETTERS + SETTERS (OBLIGATOIRES)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUe() {
        return ue;
    }

    public void setUe(String ue) {
        this.ue = ue;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }
}