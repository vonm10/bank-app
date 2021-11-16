package cz.vse.java;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import cz.vse.java.model.Uzivatel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlFileManager {

    private static final String fileName = "BankovniAplikace.xml";

    private XStream xstream = new XStream(new DomDriver());

    /**
     * Metoda save bere jako parametr class Uzivatel
     *
     * Uzivatele nahrává do BankovniAplikace.xml
     */
    public void save(Uzivatel uzivatel) throws Exception{
        String xml = xstream.toXML(uzivatel);
        try {
            Files.write(Paths.get(fileName), xml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda load
     *
     * Uzivatele načítá z BankovniAplikace.xml do třídy Uzivatel
     */
    public Uzivatel load() throws Exception{
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            Uzivatel uzivatel = (Uzivatel) xstream.fromXML(reader);
            return uzivatel;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
