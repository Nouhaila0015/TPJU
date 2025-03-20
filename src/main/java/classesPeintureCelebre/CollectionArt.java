package classesPeintureCelebre;

import interfaces.IComposantArt;

import java.util.ArrayList;
import java.util.List;


public class CollectionArt implements IComposantArt {

    private String nomCollection;
    private List<ToileDePeintureCelebre> toiles; // Une collection peut contenir plusieurs toiles

    public CollectionArt(String nomCollection) {
        this.nomCollection = nomCollection;
        this.toiles = new ArrayList<>();
    }

    public String getNomCollection() {
        return nomCollection;
    }

    public List<ToileDePeintureCelebre> getToiles() {
        return toiles;
    }

    public void ajouterToile(ToileDePeintureCelebre toile) {
        if (!toiles.contains(toile)) {
            toiles.add(toile);
            toile.setCollection(this); // Synchronisation bidirectionnelle
        }
    }


    // Méthode collaborant avec ToileDePeintureCelebre
    @Override
    public String afficherInfos() {
        StringBuilder details = new StringBuilder("Collection : " + nomCollection + "\n");
        if (!toiles.isEmpty()) {
            for (ToileDePeintureCelebre toile : toiles) {
                details.append("Toile associée : ").append(toile.getNom()).append("\n");
                details.append("Artiste : ").append(toile.getArtiste()).append("\n");
                details.append("Année de création : ").append(toile.getAnneeCreation()).append("\n");
                details.append("Description : ").append(toile.getDescription()).append("\n");
            }
        } else {
            details.append("Aucune toile associée à cette collection.\n");
        }
        return details.toString();
    }
}