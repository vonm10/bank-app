package cz.vse.java;

/**
 * Třída ...
 *
 * Během chodu aplikace třída vypisuje...
 *
 * @author Matyáš Vondra
 * @author Jaroslava Ludrinská
 * @author Patrik Novák
 * @version 25-01-2021
 */

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import cz.vse.java.model.Uzivatel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonFileManager {

	private static final String fileName = "save.json";

	private Gson gson = new Gson();

	/**
	 * Metoda save bere jako parametr class Uzivatel
	 *
	 * Uzivatele nahrává do save.json
	 */
	public void save(Uzivatel uzivatel) throws Exception{
		String json = gson.toJson(uzivatel);
		try {
			Files.write(Paths.get(fileName), json.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metoda load
	 *
	 * načítá uživatele z save.json do třídy Uzivatel
	 */
	public Uzivatel load() throws Exception{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fileName));

			Uzivatel uzivatel = gson.fromJson(reader, Uzivatel.class);
			return uzivatel;


		} catch (IOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
