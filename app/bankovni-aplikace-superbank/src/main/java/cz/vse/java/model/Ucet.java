package cz.vse.java.model;


import java.util.Map;

public class Ucet extends Produkt {
	private String predcisli;

	private String IBAN;

	private String kodBanky;

	public Ucet (String cislo, int zustatek, String predcisli, String IBAN, String kodBanky)
	{
		super(cislo, zustatek);
		this.predcisli = predcisli;
		this.IBAN = IBAN;
		this.kodBanky = kodBanky;

		typProduktu = "Účet";
	}

	public String getPredcisli() {
		return predcisli;
	}

	public String getIBAN() {
		return IBAN;
	}

	public String getKodBanky() {
		return kodBanky;
	}

}
