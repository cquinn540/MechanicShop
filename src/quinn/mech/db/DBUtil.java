package quinn.mech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Adapted from pg. 519 of "Murach's Beginning Java with Eclipse" by Joel Murach and Michael Urban
// published by Mike Murach and Associates, Fresno CA.
public class DBUtil {
	private static Connection conn;
	
	private DBUtil() {}
	
	public static synchronized Connection getConnection() {
		if (conn != null) {
			return conn;
		}
		else {
			try {
				String url = "jdbc:mysql://localhost/mechanicshop";
				String username = "Colin";
				String password = "ics311";
				
				// post JDBC 4.0 uses automatic driver loading
				conn = DriverManager.getConnection(url, username, password);
				return conn;
			} catch (SQLException e) {
				for (Throwable t : e) {
					System.out.println(t);
				}
				return null;
			}
		}
	}
	
	public static synchronized void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
