package cz.vse.java.model;


import cz.vse.java.JsonFileManager;

import java.util.Map;

public class App {

	private Uzivatel uzivatel;
	private Ucet ucet;
	private JsonFileManager jfm;

	public App() throws Exception {
		jfm = new JsonFileManager();
		uzivatel = jfm.load();
	}

	public Uzivatel getUzivatel() {
		return uzivatel;
	}

	public boolean novaPlatba(Produkt produkt, String cil, int castka) {
		if(produkt.getZustatek()>=castka)
		{
			produkt.setZustatek(-castka);
			return true;
		} else {return false;}
	}

}
