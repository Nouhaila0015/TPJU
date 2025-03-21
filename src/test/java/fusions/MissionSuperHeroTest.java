package fusions;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import fusion.MissionSuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//gère la mission de protection et de récupération d’une œuvre d’art par un super-héros.
public class MissionSuperHeroTest {
    private MissionSuperHero mission;
    private SuperHero batman;
    private ToileDePeintureCelebre monaLisa;

    @BeforeEach
    void setUp() {
        batman = new SuperHero("Batman", 100);
        monaLisa = new ToileDePeintureCelebre("La Joconde", "Léonard de Vinci", 1503, "Mystérieux sourire");
        mission = new MissionSuperHero(batman, monaLisa);
    }

    //Vérifie qu’une mission n’est pas accomplie à la création.
    @Test
    void testMissionNonAccomplieInitialement() {
        assertFalse(mission.isMissionReussie(), "La mission ne devrait pas être accomplie au départ.");
    }

    //Vérifie que la mission est bien marquée comme réussie après son exécution.
    @Test
    void testAccomplirMission() {//
        mission.accomplirMission();
        assertTrue(mission.isMissionReussie(), "La mission devrait être marquée comme réussie après accomplissement.");
    }

    //Vérifie l’affichage des informations avant et après l’accomplissement.
    @Test
    void testAfficherInfos() {//
        String expectedAvant = "📜 Mission : Batman protège La Joconde | Succès : ❌";
        assertEquals(expectedAvant, mission.afficherInfos(), "Le détail de la mission doit correspondre avant accomplissement.");

        mission.accomplirMission();

        String expectedApres = "📜 Mission : Batman protège La Joconde | Succès : ✅";
        assertEquals(expectedApres, mission.afficherInfos(), "Le détail de la mission doit correspondre après accomplissement.");
    }
}
