

import classesSuperHero.Equipe;
import classesSuperHero.SuperHero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SuperHeroTest {
    private SuperHero superher1;
    private SuperHero superher2;
    private Equipe avengers;
    private Equipe justiceLeague;

    /**
     * Constructeur de la classe-test TestSuperhero
     */
    public SuperHeroTest() {
    }

    /**
     * Met en place les engagements avant chaque test.
     */
    @BeforeEach
    void setUp() {
        avengers = new Equipe("Avengers");
        justiceLeague = new Equipe("Justice League");

        superher1 = new SuperHero("Iron Man", 1, avengers); // Héros déjà dans une équipe
        superher2 = new SuperHero("thor", 2); // Héros sans équipe
    }

    /**
     * Supprime les engagements après chaque test.
     */
    @AfterEach
    void tearDown() {
        // Nettoyage après chaque test (si nécessaire)
    }

    /**
     * Vérifie que l'affichage des infos inclut le bon format avec équipe.
     */
    @Test
    void testAfficherInfos() {
        assertEquals("Superhéros : Iron Man | Niveau : 1 | Équipe : Avengers", superher1.afficherInfos());
        assertEquals("Superhéros : thor | Niveau : 2 | Équipe : Aucune équipe", superher2.afficherInfos());
    }

    /**
     * Teste l'amélioration du niveau d'un super-héros.
     */
    @Test
    void testAmeliorer() {
        superher1.ameliorer(3);
        assertEquals(4, superher1.getNiveau()); // 1 + 3 = 4

        superher2.ameliorer(2);
        assertEquals(4, superher2.getNiveau()); // 2 + 2 = 4
    }

}
