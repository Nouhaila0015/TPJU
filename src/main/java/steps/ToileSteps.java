package steps;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class ToileSteps {
    private String nom;
    private String artiste;
    private int anneeCreation;
    private String nomCollection;

    @Given("une toile {string} de {string} créée en {int}")
    public void une_toile_creee(String nom, String artiste, int annee) {
        this.nom = nom;
        this.artiste = artiste;
        this.anneeCreation = annee;
    }

    @When("l’utilisateur l’ajoute à la collection {string}")
    public void utilisateur_ajoute_collection(String collection) {
        this.nomCollection = collection;
    }

    @Then("la toile doit être associée à la collection")
    public void verification_association() {
        assertNotNull(nomCollection, "La toile n'a pas été ajoutée à une collection.");
    }

    @When("l’utilisateur consulte les détails")
    public void utilisateur_consulte_details() {
        // Simulation d'affichage des détails
        System.out.println("Nom: " + nom + ", Artiste: " + artiste + ", Année: " + anneeCreation);
    }

    @Then("le système affiche {string}")
    public void verification_affichage(String expectedMessage) {
        String actualMessage = "Nom: " + nom + ", Artiste: " + artiste + ", Année: " + anneeCreation;
        assertEquals(expectedMessage, actualMessage);
    }
}