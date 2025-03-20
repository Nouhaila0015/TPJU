package fusions;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import fusion.MissionSuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testMissionNonAccomplieInitialement() {
        assertFalse(mission.isMissionReussie(), "La mission ne devrait pas être accomplie au départ.");
    }

    @Test
    void testAccomplirMission() {
        mission.accomplirMission();
        assertTrue(mission.isMissionReussie(), "La mission devrait être marquée comme réussie après accomplissement.");
    }

    @Test
    void testAfficherInfos() {
        String expectedAvant = "📜 Mission : Batman protège La Joconde | Succès : ❌";
        assertEquals(expectedAvant, mission.afficherInfos(), "Le détail de la mission doit correspondre avant accomplissement.");

        mission.accomplirMission();

        String expectedApres = "📜 Mission : Batman protège La Joconde | Succès : ✅";
        assertEquals(expectedApres, mission.afficherInfos(), "Le détail de la mission doit correspondre après accomplissement.");
    }
}
