import classesPeintureCelebre.CollectionArt;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestNouvelleCollection {


    @Test
    public void TestNouvelleCollection() {
        CollectionArt collection = new CollectionArt("Musée d'Orsay");
        // Vérifie que la liste des toiles n'est pas nulle
        assertNotNull(collection.getToiles());
        // Vérifie que la taille de la collection est bien 0
        assertEquals(0, collection.getToiles().size());
    }
}


