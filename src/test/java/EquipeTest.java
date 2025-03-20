
import classesSuperHero.Equipe;
import classesSuperHero.SuperHero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EquipeTest {
    private Equipe avengers;
    private Equipe justiceLeague;
    private SuperHero ironMan;
    private SuperHero thor;

    /**
     * Met en place les engagements avant chaque test.
     */
    @BeforeEach
    void setUp() {
        avengers = new Equipe("Avengers");
        justiceLeague = new Equipe("Justice League");

        ironMan = new SuperHero("Iron Man", 10);
        thor = new SuperHero("Thor", 12);
    }

    /**
     * Supprime les engagements après chaque test.
     */
    @AfterEach
    void tearDown() {
        // Nettoyage après chaque test (si nécessaire)
    }

    /**
     * Teste l'ajout d'un super-héros à une équipe.
     */
    @Test
    void testAjouterSuperHero() {
        avengers.ajouterSuperHero(ironMan);
        avengers.ajouterSuperHero(thor);

        List<String> nomsHeros = avengers.getListeSuperHeros();

        assertEquals(2, nomsHeros.size());
        assertTrue(nomsHeros.contains("Iron Man"));
        assertTrue(nomsHeros.contains("Thor"));
    }

    /**
     * Teste l'affichage de l'équipe avec des super-héros.
     */
    @Test
    void testAfficherEquipe() {
        avengers.ajouterSuperHero(ironMan);
        avengers.ajouterSuperHero(thor);

        String expected = """
            Équipe : Avengers
            Super-Héros :
            - Superhéros : Iron Man | Niveau : 10 | Équipe : Avengers
            - Superhéros : Thor | Niveau : 12 | Équipe : Avengers
            """.trim(); // Trim pour éviter les problèmes d'espaces

        String actual = avengers.afficherEquipe().trim(); // Trim pour éviter les erreurs d'affichage

        assertEquals(expected, actual, "L'affichage de l'équipe ne correspond pas !");
    }


    @Test
    void testAjouterSuperHeroNull() {
        Equipe equipe = new Equipe("Avengers");
        equipe.ajouterSuperHero(null);

        assertEquals(0, equipe.getListeSuperHeros().size(), "L'équipe ne doit pas accepter un super-héros null");
    }

    @Test
    void testAjouterSuperHeroDuplique() {
        Equipe equipe = new Equipe("Avengers");
        SuperHero ironMan = new SuperHero("Iron Man", 10);

        equipe.ajouterSuperHero(ironMan);
        equipe.ajouterSuperHero(ironMan); // Tentative d'ajout en double

        assertEquals(1, equipe.getListeSuperHeros().size(), "Un héros ne doit pas être ajouté en double !");
    }


    @Test
    void testChangerEquipeSuperHero() {
        Equipe avengers = new Equipe("Avengers");
        Equipe justiceLeague = new Equipe("Justice League");
        SuperHero batman = new SuperHero("Batman", 20);

        avengers.ajouterSuperHero(batman);
        batman.setEquipe(justiceLeague); // Batman change d'équipe

        assertEquals(justiceLeague, batman.getEquipe(), "Le super-héros doit appartenir à la nouvelle équipe");
        assertFalse(avengers.getListeSuperHeros().contains("Batman"), "L'ancienne équipe ne doit plus contenir le héros");
        assertTrue(justiceLeague.getListeSuperHeros().contains("Batman"), "La nouvelle équipe doit contenir le héros");
    }


}
