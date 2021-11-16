package cz.vse.java.model;

import cz.vse.java.JsonFileManager;
import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class AppTest extends TestCase {

    public void testGetUzivatel() throws Exception {
        App app = new App();

        assertEquals("Milan Pavel", app.getUzivatel().getJmeno());
        assertEquals("milapavo@gmail.com", app.getUzivatel().getEmail());
        assertEquals("+420 689 906 450", app.getUzivatel().getTelefon());
    }

    public void testNovaPlatba() throws Exception {
        App app = new App();
        Produkt produkt = new Produkt("1",10);

        assertFalse(app.novaPlatba(produkt,"123",11));
        assertTrue(app.novaPlatba(produkt,"123",8));
    }
}