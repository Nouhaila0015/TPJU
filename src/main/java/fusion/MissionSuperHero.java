package fusion;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import interfaces.IComposantArt;

/**
 * 📌 Les super-héros ont des missions pour récupérer et protéger des œuvres d’art.
 * */
public class MissionSuperHero implements IComposantArt {
    private SuperHero hero;
    private ToileDePeintureCelebre oeuvre;
    private boolean missionReussie;

    public MissionSuperHero(SuperHero hero, ToileDePeintureCelebre oeuvre) {
        this.hero = hero;
        this.oeuvre = oeuvre;
        this.missionReussie = false;
    }

    public void accomplirMission() {
        System.out.println("🦸‍♂️ " + hero.getNom() + " est en mission pour récupérer " + oeuvre.getNom() + "...");
        missionReussie = true;
        System.out.println("✅ Mission accomplie ! " + hero.getNom() + " a sécurisé " + oeuvre.getNom());
    }

    @Override
    public String afficherDetails() {
        return "📜 Mission : " + hero.getNom() + " protège " + oeuvre.getNom() + " | Succès : " + (missionReussie ? "✅" : "❌");
    }

    public boolean isMissionReussie() {
        return missionReussie;
    }
}