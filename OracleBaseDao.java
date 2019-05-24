package Week2.Les2.P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@//localhost:8088/xe";
		String name = "MIMI";
		String password = "Albena-66";

		Connection con = DriverManager.getConnection(url, name, password);
		return con;
	}
}
