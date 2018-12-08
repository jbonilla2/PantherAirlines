package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String PATH = "jdbc:mysql://localhost:3306/airline_reservation";
	private static final String URL = "jdbc:mysql://localhost:3306/airline_reservation";
	private static final String usernameDB = "Jarieny";
	private static final String passwordDB = "CIS3270"; 

	
	public static Connection connect() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, usernameDB, passwordDB);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	

}
