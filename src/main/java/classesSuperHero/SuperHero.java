package classesSuperHero;

import interfaces.IComposantArt;

public class SuperHero implements IComposantArt {
    // Variables d'instance
    private String nom;
    private int niveau;
    private Equipe equipe; // Ajout de l'équipe du super-héros

    // Constructeur par défaut
    public SuperHero() {
        this.nom = "Superhéros inconnu";
        this.niveau = 1; // Niveau de base
        this.equipe = null; // Pas d'équipe par défaut
    }

    // Constructeur avec paramètres (sans équipe)
    public SuperHero(String nom, int niveau) {
        this.nom = nom;
        this.niveau = niveau;
        this.equipe = null; // Pas d'équipe par défaut
    }

    // Constructeur avec équipe
    public SuperHero(String nom, int niveau, Equipe equipe) {
        this.nom = nom;
        this.niveau = niveau;
        this.equipe = equipe;
        if (equipe != null) {
            equipe.ajouterSuperHero(this); // Ajouter le héros à l'équipe automatiquement
        }
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour niveau
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        if (niveau > 0) {
            this.niveau = niveau;
        } else {
            System.out.println("Le niveau ne peut pas être négatif !");
        }
    }

    // Getter et Setter pour l'équipe
    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe nouvelleEquipe) {
        if (this.equipe != null && this.equipe != nouvelleEquipe) {
            this.equipe.supprimerSuperHero(this); // Supprime le héros de l'ancienne équipe
        }
        this.equipe = nouvelleEquipe;
        if (nouvelleEquipe != null && !nouvelleEquipe.getListeSuperHeros().contains(this.getNom())) {
            nouvelleEquipe.ajouterSuperHero(this); // Ajoute à la nouvelle équipe
        }
    }

    /**
     * Méthode pour améliorer le super-héros (augmenter le niveau)
     */
    public void ameliorer(int newLevel) {
        if (newLevel > 0) {
            this.niveau += newLevel;
            System.out.println(nom + " s'est entraîné et s'est amélioré !");
            System.out.println("Nouveau niveau : " + this.niveau);
        } else {
            System.out.println("L'amélioration doit être positive !");
        }
    }

    /**
     * Affiche les informations du super-héros
     */
    @Override
    public String afficherInfos() {
        String equipeNom = (equipe != null) ? equipe.getNomEquipe() : "Aucune équipe";
        return "Superhéros : " + this.nom + " | Niveau : " + this.niveau + " | Équipe : " + equipeNom;
    }

}
