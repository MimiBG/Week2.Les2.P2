package week2.Les2.P2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {
	

	@Override
	public List<OVChipkaart> findAll() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		List<OVChipkaart> kaartenLijst = new ArrayList<OVChipkaart>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM OV_CHIPKAART";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				OVChipkaart kaart = new OVChipkaart();
				kaart.setGeldigTot(rs.getString("GELDIGTOT"));
				kaart.setKaartNummer(rs.getInt("KAARTNUMMER"));
				kaart.setKlasse(rs.getInt("KLASSE"));
				kaart.setSaldo(rs.getInt("SALDO"));
				kaart.setReizigerID(rs.getInt("REIZIGERID"));
				
				kaartenLijst.add(kaart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return kaartenLijst;
	}

	@Override
	public OVChipkaart save(OVChipkaart kaart) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;

		String sql = "insert into OV_CHIPKAART values (" + kaart.getKaartNummer() + "," + "'" + kaart.getGeldigTot()
				+ "'" + "," + "'" + kaart.getKlasse() + "'" + "," + "'" + kaart.getSaldo() + "'" + ","
				+ "'" + kaart.getReizigerID() + "'" + ")";

		try {

			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Insert voltooid voor kaart met reizigerID: " + kaart.getReizigerID());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public OVChipkaart update(OVChipkaart kaart) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;
		if (kaart == null)
			throw new IllegalArgumentException("kaart mag niet null zijn");

		
		String sql = "update OV_CHIPKAART SET GELDIGTOT =" + "'" + kaart.getGeldigTot() + "'" + "WHERE KAARTNUMMER=" + kaart.getKaartNummer() ;
		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Update succesvol verwerkt voor kaart met reizigerID: " + kaart.getKaartNummer());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return kaart;
	}

	@Override
	public boolean delete(OVChipkaart kaart) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;
		boolean Resultaat = false;

		if (kaart == null)
			throw new IllegalArgumentException("reiziger mag niet null zijn");
		try {
			String sql = "delete from OV_CHIPKAART where REIZIGERID=" + kaart.getReizigerID();
			System.out.print("SQL : " + sql);
			statement = con.prepareStatement(sql);
			statement.execute(sql);
			System.out.println("Kaart succesvol verwijder met reizigersID: " + kaart.getReizigerID());
			Resultaat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Resultaat;
	}

	@Override
	public List<OVChipkaart> findByKaartNummer(int kaartnummer) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		List<OVChipkaart> kaartLijst = new ArrayList<OVChipkaart>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM OV_CHIPKAART where KAARTNUMMER = '" + kaartnummer + "' ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				OVChipkaart kaart = new OVChipkaart();
				kaart.setGeldigTot(rs.getString("GELDIGTOT"));
				kaart.setKaartNummer(rs.getInt("KAARTNUMMER"));
				kaart.setKlasse(rs.getInt("KLASSE"));
				kaart.setSaldo(rs.getInt("SALDO"));
				kaart.setReizigerID(rs.getInt("REIZIGERID"));
				kaartLijst.add(kaart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return kaartLijst;
	}

	@Override
	public void updateKaart(int kaartnummer, int nwkaartnummer, String ngeldigtot, int nklasse, int nsaldo) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;
		
		

		String sql = "update OV_CHIPKAART set KAARTNUMMER=" + nwkaartnummer + "," + "GELDIGTOT=" + "'"
				+ ngeldigtot + "'," + "KLASSE=" + nklasse + ","
				+ "SALDO=" + nsaldo + "WHERE KAARTNUMMER=" + kaartnummer;
		
		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Update succesvol verwerkt voor kaart met kaartnummer: " + kaartnummer);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
