package fusion;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;

public class MissionSuperHero {
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
        missionReussie = true; // Supposons que la mission est toujours réussie pour simplifier
        System.out.println("✅ Mission accomplie ! " + hero.getNom() + " a sécurisé " + oeuvre.getNom());
    }

    public boolean isMissionReussie() {
        return missionReussie;
    }
}