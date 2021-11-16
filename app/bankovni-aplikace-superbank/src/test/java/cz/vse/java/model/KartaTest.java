package cz.vse.java.model;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KartaTest extends TestCase {

    Date date = new Date(44431);
    Karta karta = new Karta("1",10, date,"091");

   /* public void testGetPlatnost() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        assertEquals("2021-08-23", dateFormat.format(karta.getPlatnost()));
    } */

    public void testGetCVC() {
        assertEquals("091",karta.getCVC());
    }
}