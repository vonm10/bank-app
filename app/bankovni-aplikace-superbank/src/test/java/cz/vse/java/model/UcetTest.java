package cz.vse.java.model;

import junit.framework.TestCase;

public class UcetTest extends TestCase {

    Ucet ucet = new Ucet("1",10,"2","0003","3312");

    public void testGetPredcisli() {
        assertEquals("2",ucet.getPredcisli());
    }

    public void testGetIBAN() {
        assertEquals("0003",ucet.getIBAN());
    }

    public void testGetKodBanky() {
        assertEquals("3312",ucet.getKodBanky());
    }
}