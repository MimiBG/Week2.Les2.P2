package week2.Les2.P2;

import java.sql.SQLException;
import java.util.List;


public interface OVChipkaartDao {
	public List<OVChipkaart> findAll() throws ClassNotFoundException, SQLException;
	
	public List<OVChipkaart> findByKaartNummer(int nummer) throws ClassNotFoundException, SQLException;
	
	public OVChipkaart save(OVChipkaart kaart) throws ClassNotFoundException, SQLException;
	
	public OVChipkaart update(OVChipkaart kaart ) throws ClassNotFoundException, SQLException;
	
	public boolean delete(OVChipkaart kaart) throws ClassNotFoundException, SQLException;
	
	public void updateKaart (int kaartnummer, int nwkaartnummer, String geldigtot, int klasse, int saldo) throws ClassNotFoundException, SQLException;
}