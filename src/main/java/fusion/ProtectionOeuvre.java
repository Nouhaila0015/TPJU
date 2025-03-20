package fusion;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;

import java.util.HashMap;
import java.util.Map;

public class ProtectionOeuvre {
    private Map<ToileDePeintureCelebre, SuperHero> protectionMap;

    public ProtectionOeuvre() {
        this.protectionMap = new HashMap<>();
    }

    public void assignerProtection(SuperHero hero, ToileDePeintureCelebre oeuvre) {
        protectionMap.put(oeuvre, hero);
        System.out.println("🛡️ " + hero.getNom() + " protège désormais " + oeuvre.getNom() + " !");
    }

    public void afficherProtections() {
        System.out.println("🔐 Liste des œuvres protégées :");
        for (Map.Entry<ToileDePeintureCelebre, SuperHero> entry : protectionMap.entrySet()) {
            System.out.println("🎨 " + entry.getKey().getNom() + " est protégé par 🦸‍♂️ " + entry.getValue().getNom());
        }
    }
}