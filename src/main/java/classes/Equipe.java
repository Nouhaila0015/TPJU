package classes;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nomEquipe;
    private List<SuperHero> heros; // Liste des super-héros

    // Constructeur
    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.heros = new ArrayList<>(); // Initialisation de la liste
    }

    // Getter et Setter pour le nom de l'équipe
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    // Ajouter un super-héros à l'équipe
    public void ajouterSuperHero(SuperHero hero) {
        if (hero != null && !heros.contains(hero)) { // Vérifie si le héros est déjà dans l'équipe
            heros.add(hero);
            hero.setEquipe(this);
            System.out.println(hero.getNom() + " a été ajouté à l'équipe " + nomEquipe + " !");
        } else {
            System.out.println("Erreur : Le héros est déjà dans l'équipe !");
        }
    }


    // Supprimer un super-héros de l'équipe
    public void supprimerSuperHero(SuperHero hero) {
        if (heros.contains(hero)) {
            heros.remove(hero);
            System.out.println(hero.getNom() + " a été retiré de l'équipe " + nomEquipe + " !");
        } else {
            System.out.println("Ce héros n'est pas dans l'équipe !");
        }
    }

    // Obtenir la liste des noms des super-héros
    public List<String> getListeSuperHeros() {
        List<String> noms = new ArrayList<>();
        for (SuperHero hero : heros) {
            noms.add(hero.getNom());
        }
        return noms;
    }

    // Afficher les super-héros de l'équipe
    public String afficherEquipe() {
        if (heros.isEmpty()) {
            return "L'équipe " + nomEquipe + " n'a pas encore de super-héros.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Équipe : ").append(nomEquipe).append("\nSuper-Héros :\n");

        for (SuperHero hero : heros) {
            sb.append("- ").append(hero.afficherInfos()).append("\n");
        }

        return sb.toString().trim(); // Trim pour éviter les sauts de ligne en trop
    }

}
