package cz.vse.java.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Karta extends Produkt {

	private Date platnost;

	private String CVC;

	public Karta (String cislo, int zustatek, Date platnost, String CVC)
	{
		super(cislo, zustatek);
		this.platnost = platnost;
		this.CVC = CVC;

		typProduktu = "Karta";
	}

	public String getPlatnost()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strPlatnost = dateFormat.format(platnost);
		return strPlatnost;
	}

	public String getCVC() {
		return CVC;
	}

}
