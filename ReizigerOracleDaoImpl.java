package week2.Les2.P2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

	@Override
	public List<Reiziger> findAll() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		List<Reiziger> reizigerLijst = new ArrayList<Reiziger>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM reiziger";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reiziger reiziger = new Reiziger();
				reiziger.setReizigerId(rs.getInt("REIZIGERID"));
				reiziger.setVoorletter(rs.getString("VOORLETTERS"));
				reiziger.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
				reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
				reiziger.setGbdatum(rs.getString("GEBOORTEDATUM"));
				reizigerLijst.add(reiziger);
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
		return reizigerLijst;
	}

	@Override
	public Reiziger save(Reiziger reiziger) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;

		String sql = "insert into reiziger values (" + reiziger.getReizigerId() + "," + "'" + reiziger.getVoorletter()
				+ "'" + "," + "'" + reiziger.getTussenvoegsel() + "'" + "," + "'" + reiziger.getAchternaam() + "'" + ","
				+ "'" + reiziger.getGbdatum() + "'" + ")";

		try {

			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Insert voltooid voor reiziger met achternaam: " + reiziger.getAchternaam());

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
	public Reiziger update(Reiziger reiziger) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;

		if (reiziger == null)
			throw new IllegalArgumentException("Reiziger mag niet null zijn!");

		String sql = "update reiziger set VOORLETTERS=" + "'" + reiziger.getVoorletter() + "'," + "TUSSENVOEGSEL=" + "'"
				+ reiziger.getTussenvoegsel() + "'," + "ACHTERNAAM=" + "'" + reiziger.getAchternaam() + "',"
				+ "GEBOORTEDATUM=" + "'" + reiziger.getGBdatum() + "'" + "WHERE reizigerid=" + reiziger.getReizigerId();

		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out.println("Update succesvol verwerkt voor de reiziger met reizigerID: " + reiziger.getReizigerId());
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
		return reiziger;
	}

	@Override
	public boolean delete(Reiziger reiziger) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement statement = null;
		boolean Resultaat = false;

		if (reiziger == null)
			throw new IllegalArgumentException("reiziger mag niet null zijn");
		try {
			String sql = "delete from reiziger where REIZIGERID=" + reiziger.getReizigerId();
			System.out.print("SQL : " + sql);
			statement = con.prepareStatement(sql);
			statement.execute(sql);
			System.out.println("Reiziger succesvol verwijderd met de reizigersID: " + reiziger.getReizigerId());
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
	public List<Reiziger> findByGBdatum(String GBdatum) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		List<Reiziger> reizigerLijst = new ArrayList<Reiziger>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM reiziger where GEBOORTEDATUM = '" + GBdatum + "' ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reiziger reiziger = new Reiziger();
				reiziger.setReizigerId(rs.getInt("REIZIGERID"));
				reiziger.setVoorletter(rs.getString("VOORLETTERS"));
				reiziger.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
				reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
				reiziger.setGbdatum(rs.getString("GEBOORTEDATUM"));
				reizigerLijst.add(reiziger);
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
		return reizigerLijst;
	}
}