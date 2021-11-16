package cz.vse.java.model;

import java.util.HashMap;
import java.util.Map;


import java.util.Map;
import java.util.Properties;

public class Uzivatel {

	private String jmeno;

	private String email;

	private String telefon;

	private Map<String, Produkt> produkty;

	public Uzivatel(String jmeno, String email, String telefon)
	{
		this.jmeno = jmeno;
		this.email = email;
		this.telefon = telefon;

		produkty = new HashMap<String, Produkt>();
	}

	public String getJmeno() {
		return jmeno;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void addProdukt(Produkt produkt) {
		produkty.put(produkt.getCislo(), produkt);
	}

	public Produkt getProdukt(String cislo)
	{
		if(produkty.containsKey(cislo)) {
			return (Produkt) produkty.get(cislo);
		}
		else {return null;}
	}

	public Map getProdukty() {
		return produkty;
	}

}
