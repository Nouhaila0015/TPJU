package fusions;

import classesPeintureCelebre.ToileDePeintureCelebre;
import classesSuperHero.SuperHero;
import fusion.ProtectionOeuvre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtectionOeuvreTest {//gère l’assignation des super-héros à la protection des œuvres.
    private ProtectionOeuvre protection;
    private SuperHero ironMan;
    private ToileDePeintureCelebre leCri;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        protection = new ProtectionOeuvre();
        ironMan = new SuperHero("Iron Man", 200);
        leCri = new ToileDePeintureCelebre("Le Cri", "Munch", 1893, "Expressionisme puissant");
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture la sortie console
    }

    @Test
    void testAssignerProtection() { //Vérifie que l'assignation d’un super-héros à une œuvre fonctionne bien.
        protection.assignerProtection(ironMan, leCri);
        String expectedOutput = "🛡️ Iron Man protège désormais Le Cri !\n🔔 [Système de Protection] Protection assignée : Le Cri par Iron Man";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim(), "Le message d'assignation de protection doit être correct.");
    }

    @Test
    void testAfficherProtections() { //Vérifie l'affichage des protections en listant les œuvres protégées.
        // Affectation d'une protection
        protection.assignerProtection(ironMan, leCri);

        // Réinitialisation du tampon de sortie
        outputStreamCaptor.reset();

        // Exécution de la méthode à tester
        protection.afficherProtections();

        // Définition de la sortie attendue
        String expectedOutput = "Liste des oeuvres protégées : Le Cri est protégé par Iron Man";

        // Capture the output for verification
        String actualOutput = outputStreamCaptor.toString().trim();

        // Print debug info to a different stream to avoid interference
        System.err.println("🔍 Sortie réelle capturée : " + actualOutput);

        // Vérification stricte
        assertEquals(expectedOutput, actualOutput,
                "L'affichage des protections doit être correct.");
    }





}
