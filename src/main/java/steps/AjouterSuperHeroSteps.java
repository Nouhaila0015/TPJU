package steps;

import classes.Equipe;
import classes.SuperHero;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AjouterSuperHeroSteps {
    private Equipe equipe;
    private SuperHero hero;
    private String message;

    @Given("une équipe {string} existe")
    public void uneEquipeExiste(String nomEquipe) {
        equipe = new Equipe(nomEquipe);
    }

    @Given("une équipe {string} avec le super-héros {string}")
    public void uneEquipeAvecSuperHero(String nomEquipe, String nomHero) {
        equipe = new Equipe(nomEquipe);
        hero = new SuperHero(nomHero, 100);
        equipe.ajouterSuperHero(hero);
    }

    @When("j'ajoute {string} à l'équipe")
    public void jAjouteSuperHero(String nomHero) {
        hero = new SuperHero(nomHero, 100);
        if (equipe.getListeSuperHeros().contains(hero.getNom())) {
            message = "Erreur : " + nomHero + " est déjà dans l'équipe " + equipe.getNomEquipe() + " !";
        } else {
            equipe.ajouterSuperHero(hero);
            message = nomHero + " a été ajouté à l'équipe " + equipe.getNomEquipe() + " !";
        }
    }

    @Then("la confirmation {string} doit s'afficher")
    public void laConfirmationDoitSAfficher(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

    @Then("un message d'erreur {string} doit s'afficher")
    public void unMessageDErreurDoitSAfficher(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

    @Then("la liste des super-héros de l'équipe doit contenir {string}")
    public void laListeDesSuperHerosDoitContenir(String nomHero) {
        assertTrue(equipe.getListeSuperHeros().contains(nomHero));
    }

    @Then("la liste des super-héros de l'équipe doit contenir {string} une seule fois")
    public void laListeDesSuperHerosDoitContenirUneSeuleFois(String nomHero) {
        long count = equipe.getListeSuperHeros().stream().filter(h -> h.equals(nomHero)).count();
        assertEquals(1, count);
    }
}
