package week2.Les2.P2;

import java.util.ArrayList;

public class OVChipkaart {
	private int kaartNummer;
	private String geldigTot;
	private int klasse;
	private int saldo;
	private int reizigerID;
	private ArrayList<Product> alleProducten = new ArrayList<Product>();

	public int getKaartNummer() {
		return kaartNummer;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public ArrayList<Product> getAlleProducten() {
		return alleProducten;
	}

	public void setAlleProducten(ArrayList<Product> alleProducten) {
		this.alleProducten = alleProducten;
		
	}
	public String toString() {
		return "Kaartnummer: " + kaartNummer + ", geldig tot: " + geldigTot + ", klasse: " + klasse + " , saldo: " + saldo;
	}
}