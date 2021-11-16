package cz.vse.java.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Uver extends Produkt {

	private Date splatnost;

	private int splatka;

	private float urok;

	public Uver (String cislo, int zustatek, Date splatnost, int splatka, float urok)
	{
		super(cislo, zustatek);
		this.splatnost = splatnost;
		this.splatka = splatka;
		this.urok = urok;

		typProduktu = "Úvěr";
	}

	public String getSplatnost()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strSplatnost = dateFormat.format(splatnost);
		return strSplatnost;
	}

	public int getSplatka() {
		return splatka;
	}

	public float getUrok() {
		return urok;
	}

}
