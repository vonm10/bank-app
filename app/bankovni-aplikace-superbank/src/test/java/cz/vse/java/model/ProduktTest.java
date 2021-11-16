package cz.vse.java.model;

import junit.framework.TestCase;

public class ProduktTest extends TestCase {

    Produkt produkt = new Produkt("1",10);

    public void testGetCislo() {
        assertEquals("1",produkt.getCislo());
    }

    public void testGetZustatek() {
        assertEquals(10,produkt.getZustatek());
    }

    public void testSetZustatek() {
        produkt.setZustatek(2);
        assertEquals(12,produkt.getZustatek());
    }

    public void testGetTypProduktu() {
        assertEquals("",produkt.getTypProduktu());
    }

    public void testGetHistorie() {
        produkt.pridatTransakci("prevod",3);
        assertEquals("3", produkt.getHistorie().get("prevod"));
    }

    public void testPridatTransakci() {
        produkt.pridatTransakci("prevod",3);

        assertTrue(produkt.getHistorie().containsKey("prevod"));
        assertFalse(produkt.getHistorie().containsKey("platba"));
    }
}