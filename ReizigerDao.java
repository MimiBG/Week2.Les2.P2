package week2.Les2.P2;

import java.sql.SQLException;
import java.util.List;


public interface ReizigerDao {
	public List<Reiziger> findAll() throws ClassNotFoundException, SQLException;
	
	public List<Reiziger> findByGBdatum(String GBdatum) throws ClassNotFoundException, SQLException;
	
	public Reiziger save(Reiziger reiziger) throws ClassNotFoundException, SQLException;
	
	public Reiziger update(Reiziger reiziger) throws ClassNotFoundException, SQLException;
	
	public boolean delete(Reiziger reiziger) throws ClassNotFoundException, SQLException;
}
