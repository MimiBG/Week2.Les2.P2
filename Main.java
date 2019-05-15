package week2.Les2.P2;

import java.sql.SQLException;



public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ReizigerOracleDaoImpl reizigerDao = new ReizigerOracleDaoImpl();

		// Voeg reiziger toe aan de database
		System.out.println("ADD reiziger");
		Reiziger reizigerStef = new Reiziger();
		reizigerStef.setReizigerId(7);
		reizigerStef.setAchternaam("Dam");
		reizigerStef.setVoorletter("S");
		reizigerStef.setTussenvoegsel(null);
		reizigerStef.setGbdatum("04-12-93");
		
		reizigerDao.save(reizigerStef);
		
		
		
		Reiziger reizigerAnn = new Reiziger();
		reizigerAnn.setReizigerId(8);
		reizigerAnn.setAchternaam("Beek");
		reizigerAnn.setVoorletter("A");
		reizigerAnn.setTussenvoegsel(null);
		reizigerAnn.setGbdatum("11-12-92");
		
		reizigerDao.save(reizigerAnn);
		
		System.out.println("ADD reiziger");
		
		System.out.println();
		
		// Haal alle reizigers op uit database
		System.out.println("Haal alle reizigers op");
		for ( Reiziger reiziger : reizigerDao.findAll()) {
			System.out.println("reiziger: [reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletter() + "." + reiziger.getAchternaam()
											+ ", Geboortedatum: "+ reiziger.getGBdatum() + " ]");
		}
		
		System.out.println();
		
		// Haal reiziger op basis van geboortedatum
		System.out.println("haal reiziger op basis van geboortedatum");
		
		for ( Reiziger reiziger1 : reizigerDao.findByGBdatum("02-03-92")) {
			System.out.println("reiziger: [reiziger Id: " + reiziger1.getReizigerId()+ ", Naam : " + reiziger1.getVoorletter() + "." + reiziger1.getAchternaam()
											+ ", Geboortedatum: "+ reiziger1.getGBdatum() + " ]");
		}
		
		System.out.println();
		
		// verwijder reiziger op basis van ID
		System.out.println("verwijder reiziger op basis van id");
		//reizigerDao.delete(reizigerStef);
		
		
		// Update gegevens van reiziger
		System.out.println("Update reiziger");
		reizigerStef.setVoorletter("S");
		reizigerStef.setTussenvoegsel(null);
		reizigerStef.setAchternaam("Dam");
		reizigerStef.setGBdatum("04-12-94");
		reizigerDao.update(reizigerStef);
		
		
		
		
	}

}