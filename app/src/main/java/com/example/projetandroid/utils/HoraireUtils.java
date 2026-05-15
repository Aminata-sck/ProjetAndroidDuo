package com.example.projetandroid.utils;

public class HoraireUtils {

    public static int calculerHeuresRestantes(int volumeTotal, int heuresEffectuees) {
        return volumeTotal - heuresEffectuees;
    }

    public static boolean verifierDepassement(int volumeTotal,
                                              int heuresEffectuees,
                                              int nouvelleDuree) {

        return (heuresEffectuees + nouvelleDuree) <= volumeTotal;
    }
}
