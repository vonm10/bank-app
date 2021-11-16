package cz.vse.java.model;

import junit.framework.TestCase;

public class UzivatelTest extends TestCase {

    Uzivatel uzivatel = new Uzivatel("Jmeno", "Email", "Telefon");

    public void testGetJmeno() {
        assertEquals("Jmeno", uzivatel.getJmeno());
    }

    public void testGetEmail() {
        assertEquals("Email", uzivatel.getEmail());
    }

    public void testGetTelefon() {
        assertEquals("Telefon", uzivatel.getTelefon());
    }

    public void testAddProdukt() {
        Produkt produkt = new Produkt("1",10);
        uzivatel.addProdukt(produkt);

        assertTrue(uzivatel.getProdukty().containsKey("1"));
        assertFalse(uzivatel.getProdukty().containsKey("2"));
    }

    public void testGetProdukt() {
        Produkt produkt = new Produkt("1",10);
        uzivatel.addProdukt(produkt);

        assertEquals(produkt, uzivatel.getProdukt("1"));
    }

    public void testGetProdukty() {
        Produkt produkt = new Produkt("1",10);
        uzivatel.addProdukt(produkt);

        assertTrue(uzivatel.getProdukty().containsKey("1"));
        assertFalse(uzivatel.getProdukty().containsKey("2"));
    }
}