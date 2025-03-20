package fusion;

import interfaces.IObservateur;


/**
 * 📌 Les musées doivent être informés lorsqu’un super-héros protège une œuvre précieuse.
 * */
public class MuseeObservateur implements IObservateur {
    private String nom;

    public MuseeObservateur(String nom) {
        this.nom = nom;
    }

    @Override
    public void miseAJour(String message) {
        System.out.println("🏛 [Musée " + nom + "] ALERTE : " + message);
    }
}