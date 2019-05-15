package week2.Les2.P2;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private int prijs;
	private ArrayList<OVChipkaart> alleReizigers = new ArrayList<OVChipkaart>();
	
	public Product(int pNummer, String pNaam, String b, int pr) {
		productNummer = pNummer;
		productNaam = pNaam;
		beschrijving = b;
		prijs = pr;
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public int getPrijs() {
		return prijs;
	}

	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}

	public ArrayList<OVChipkaart> getAlleReizigers() {
		return alleReizigers;
	}

	public void setAlleReizigers(ArrayList<OVChipkaart> alleReizigers) {
		this.alleReizigers = alleReizigers;
	}
	
	

}