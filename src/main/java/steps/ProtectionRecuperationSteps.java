package steps;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import fusion.MissionSuperHero;
import fusion.MuseeObservateur;
import fusion.ProtectionOeuvre;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProtectionRecuperationSteps { //implémente chaque étape du scénario en Java.
    private SuperHero superHero;
    private ToileDePeintureCelebre oeuvre;
    private ProtectionOeuvre protection;
    private MissionSuperHero mission;
    private MuseeObservateur musee;
    private boolean missionReussie = false;
    private boolean oeuvreProtegee = false;
    private boolean alerteEnvoyee = false;

    @Given("un super-héros {string}")
    public void unSuperHeros(String nom) {
        superHero = new SuperHero(nom, 100);
    }

    @Given("une œuvre {string} créée par {string} en {string}")
    public void uneOeuvreCreee(String nom, String artiste, String annee) {
        oeuvre = new ToileDePeintureCelebre(nom, artiste, Integer.parseInt(annee), "Une œuvre précieuse.");
    }

    @When("on assigne {string} à la protection de {string}")
    public void onAssigneAProtection(String hero, String nomOeuvre) {
        protection = new ProtectionOeuvre();
        protection.assignerProtection(superHero, oeuvre);
        oeuvreProtegee = true;
    }

    @Then("l'œuvre {string} doit être protégée par {string}")
    public void loeuvreDoitEtreProtegee(String nomOeuvre, String hero) {
        assertTrue(oeuvreProtegee, "L'œuvre n'est pas protégée !");
    }

    @When("l'œuvre {string} est volée")
    public void loeuvreEstVolee(String nomOeuvre) {
        mission = new MissionSuperHero(superHero, oeuvre);
    }

    @Then("le super-héros {string} est alerté")
    public void leSuperHeroEstAlerte(String hero) {
        assertNotNull(mission, "Le super-héros n'a pas été informé du vol !");
    }

    @When("{string} récupère l'œuvre {string}")
    public void recupereOeuvre(String hero, String nomOeuvre) {
        mission.accomplirMission();
        missionReussie = mission.isMissionReussie();
    }

    @Then("la mission de récupération est marquée comme réussie")
    public void missionDeRecuperationReussie() {
        assertTrue(missionReussie, "La mission n'a pas été marquée comme réussie !");
    }

    @Then("l'œuvre {string} est à nouveau sécurisée")
    public void oeuvreAProtegee(String nomOeuvre) {
        assertTrue(oeuvreProtegee, "L'œuvre n'est pas à nouveau sécurisée !");
    }

    @Then("le musée {string} reçoit une notification")
    public void museeRecoitNotification(String museeNom) {
        musee = new MuseeObservateur(museeNom);
        musee.miseAJour(superHero.getNom() + " a récupéré " + oeuvre.getNom());
        alerteEnvoyee = true;
    }

    @Then("l’alerte indique que {string} a récupéré {string}")
    public void alerteIndiqueRecuperation(String hero, String nomOeuvre) {
        assertTrue(alerteEnvoyee, "L'alerte de récupération n'a pas été envoyée !");
    }
}
