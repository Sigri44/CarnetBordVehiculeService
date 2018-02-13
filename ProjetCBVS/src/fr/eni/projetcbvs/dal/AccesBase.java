package fr.eni.projetcbvs.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesBase {
	
	private static AccesBase instance;
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	
	static{
		try{
			Class.forName(Settings.getProperty("driverdb"));
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(urldb, userdb, passworddb);
		return con;
	}

}
