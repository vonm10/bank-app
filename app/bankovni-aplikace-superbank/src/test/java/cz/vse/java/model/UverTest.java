package cz.vse.java.model;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UverTest extends TestCase {

    Date date = new Date(44431);
    Uver uver = new Uver("1",10,date,1,0.2f);

    /*  public void testGetSplatnost() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        assertEquals("2021-08-23", dateFormat.format(uver.getSplatnost()));
    } */

    public void testGetSplatka() {
        assertEquals(1, uver.getSplatka());
    }

    public void testGetUrok() {
        assertEquals(0.2f, uver.getUrok());
    }
}