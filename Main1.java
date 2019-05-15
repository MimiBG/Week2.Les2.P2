package week2.Les2.P2;

import java.sql.SQLException;



public class Main1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		OVChipkaartOracleDaoImpl kaartDao = new OVChipkaartOracleDaoImpl();
		
		// Voeg kaart toe aan database
		System.out.println("Add kaart");
		OVChipkaart k1 = new OVChipkaart();
		k1.setKaartNummer(40000);
		k1.setGeldigTot("02-02-15");
		k1.setKlasse(1);
		k1.setSaldo(100);
		k1.setReizigerID(8);
		
		kaartDao.save(k1);
		
		OVChipkaart k2 = new OVChipkaart();
		k2.setKaartNummer(40001);
		k2.setGeldigTot("03-03-23");
		k2.setKlasse(2);
		k2.setSaldo(200);
		k2.setReizigerID(7);
		
		kaartDao.save(k2);
		
		System.out.println("Add kaart");
		
		System.out.println();
		
		
		// Haal alle kaarten op uit Database
		System.out.println("Haal alle kaarten op");
		for ( OVChipkaart kaart : kaartDao.findAll()) {
			System.out.println("KAART: [KAARTNUMMER: " + kaart.getKaartNummer()+ ", GELDIG TOT: " + kaart.getGeldigTot()+ "." + ", Klasse:" +  kaart.getKlasse()
											+ ", SALDO:" + kaart.getSaldo() +  ", ReizigerID: "+ kaart.getReizigerID()+ " ]");
		}
		
		System.out.println();

		
		//Zoek een kaart op basis van kaartnummer
		
		System.out.println("get kaart op basis van kaartnummer");
		
		for ( OVChipkaart kaart1 : kaartDao.findByKaartNummer(40000)) {
			System.out.println("KAART: [KAARTNUMMER: " + kaart1.getKaartNummer()+ ", GELDIG TOT: " + kaart1.getGeldigTot()+ "." + ", Klasse:" +  kaart1.getKlasse()
			+ ", SALDO:" + kaart1.getSaldo() +  ", ReizigerID: "+ kaart1.getReizigerID()+ " ]");
		}
		

		System.out.println();
		
		// Verwijder kaart op basis van ID
		System.out.println("verwijder kaart op basis van id");
		kaartDao.delete(k1);
		kaartDao.delete(k2);
		
		// Update kaart
		System.out.println("UPDATE kaart");
		kaartDao.updateKaart(40000, 40002, "03-03-93", 1, 1000);
	}

}