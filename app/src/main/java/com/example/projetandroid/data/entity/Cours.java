package com.example.projetandroid.data.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "cours",
        foreignKeys = @ForeignKey(
                entity = Matiere.class,
                parentColumns = "id",
                childColumns = "matiereId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("matiereId")}
)
public class Cours {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int matiereId;

    private String dateCours;

    private String heureDebut;

    private int duree;

    private String contenu;

    public Cours(int matiereId, String dateCours, String heureDebut, int duree, String contenu) {
        this.matiereId = matiereId;
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(int matiereId) {
        this.matiereId = matiereId;
    }

    public String getDateCours() {
        return dateCours;
    }

    public void setDateCours(String dateCours) {
        this.dateCours = dateCours;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}