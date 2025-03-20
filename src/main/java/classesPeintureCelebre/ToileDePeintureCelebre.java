package classesPeintureCelebre;

public class ToileDePeintureCelebre {

    private String nom;
    private String artiste;
    private int anneeCreation;
    private String description;
    private CollectionArt collection; // Association 0..1 à 0..1

    // Constructeur
    public ToileDePeintureCelebre(String nom, String artiste, int anneeCreation, String description) {
        this.nom = nom;
        this.artiste = artiste;
        this.anneeCreation = anneeCreation;
        this.description = description;
        this.collection = null; // Initialement aucune collection assignée
    }

    public CollectionArt getCollection() { return collection; }

    public void setCollection(CollectionArt collection) {
        this.collection = collection;
        if (!collection.getToiles().contains(this)) {
            collection.ajouterToile(this); // Évite la redondance dans la liste
        }
    }

    // Getter pour le nom de la toile
    public String getNom() {
        return nom;
    }

    // Setter pour le nom de la toile
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour l'artiste
    public String getArtiste() {
        return artiste;
    }

    // Setter pour l'artiste
    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    // Getter pour l'année de création
    public int getAnneeCreation() {
        return anneeCreation;
    }

    // Setter pour l'année de création
    public void setAnneeCreation(int anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    // Getter pour la description
    public String getDescription() {
        return description;
    }

    // Setter pour la description
    public void setDescription(String description) {
        this.description = description;
    }

    // Méthode pour afficher les détails de la toile
    public String obtenirDetails() {
        return "Nom : " + nom + ", Artiste : " + artiste;
    }

    private String formatToileInfo(ToileDePeintureCelebre toile) {
        return "Nom : " + toile.getNom() + ", Artiste : " + toile.getArtiste();
    }

}