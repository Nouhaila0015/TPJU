import classesPeintureCelebre.CollectionArt;
import classesPeintureCelebre.ToileDePeintureCelebre;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectionArtTest {
    @Test
    public void testAjoutToile() {
        CollectionArt collection = new CollectionArt("Louvre");
        ToileDePeintureCelebre toile = new ToileDePeintureCelebre("La Joconde", "Léonard de Vinci", 1503, "Portrait emblématique.");

        collection.ajouterToile(toile);
        assertEquals(1, collection.getToiles().size());
        assertEquals(collection, toile.getCollection());
    }

}