package week2.Les2.P2;

import java.util.ArrayList;

public class Reiziger {
	private ArrayList<OVChipkaart> alleOVChipkaarten = new ArrayList<OVChipkaart>();
	private int reizigerId;
	private String voorletter;
	private String tussenvoegsel;
	private String achternaam;
	private String gbdatum;
	
	
	public void voegOVChipkaartToe(OVChipkaart kaart) {
		alleOVChipkaarten.add(kaart);
	}
	
	public ArrayList<OVChipkaart> getKaarten(){
		return alleOVChipkaarten;
	}

	public String getGBdatum() {
		return gbdatum;
	}

	public void setGBdatum(String gbdatum) {
		this.gbdatum = gbdatum;
	}

	public int getReizigerId() {
		return reizigerId;
	}

	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}

	public String getVoorletter() {
		return voorletter;
	}

	public void setVoorletter(String voorletter) {
		this.voorletter = voorletter;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(String gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	

}
