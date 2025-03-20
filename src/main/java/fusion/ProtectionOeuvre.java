package fusion;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import interfaces.IObservateur;

import java.util.HashMap;
import java.util.Map;

/**
 * 📌 Un super-héros peut être affecté à la protection d’une œuvre d’art dans un musée.
 * */
public class ProtectionOeuvre implements IObservateur {
    private Map<ToileDePeintureCelebre, SuperHero> protectionMap;

    public ProtectionOeuvre() {
        this.protectionMap = new HashMap<>();
    }

    public void assignerProtection(SuperHero hero, ToileDePeintureCelebre oeuvre) {
        protectionMap.put(oeuvre, hero);
        System.out.println("🛡️ " + hero.getNom() + " protège désormais " + oeuvre.getNom() + " !");
        miseAJour("Protection assignée : " + oeuvre.getNom() + " par " + hero.getNom());
    }

    @Override
    public void miseAJour(String message) {
        System.out.println("🔔 [Système de Protection] " + message);
    }

    public void afficherProtections() {
        StringBuilder sb = new StringBuilder("Liste des oeuvres protégées : ");

        boolean first = true;
        for (Map.Entry<ToileDePeintureCelebre, SuperHero> entry : protectionMap.entrySet()) {
            if (!first) {
                sb.append(", ");
            } else {
                first = false;
            }
            sb.append(entry.getKey().getNom()).append(" est protégé par ").append(entry.getValue().getNom());
        }

        System.out.print(sb.toString());
    }
}