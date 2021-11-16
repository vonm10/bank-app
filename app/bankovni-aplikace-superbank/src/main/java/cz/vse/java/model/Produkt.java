package cz.vse.java.model;

import java.util.HashMap;
import java.util.Map;


import java.util.Map;

public class Produkt {
	protected String typProduktu;

	private String cislo;

	private int zustatek;

	protected Map historie;

	public Produkt(String cislo, int zustatek)
	{
		this.typProduktu = typProduktu;
		this.cislo = cislo;
		this.zustatek = zustatek;

		historie = new HashMap<String, String>();
		typProduktu = "";
	}

	public String getCislo() {
		return cislo;
	}

	public int getZustatek() {
		return zustatek;
	}

	public void setZustatek(int castka) {
		zustatek = zustatek + castka;

	}

	public String getTypProduktu() {
		return typProduktu;
	}

	public Map getHistorie() {
		return historie;
	}
	public void pridatTransakci(String nazev, int castka)
	{
		historie.put(nazev, String.valueOf(castka));
	}

}
