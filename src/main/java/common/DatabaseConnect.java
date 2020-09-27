package common;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DatabaseConnect {
	
	
	private static Connection con = null;
	
	public static String getUrl() {
		String url = null;
		try (
				InputStream inStream = DatabaseConnect.class.getClassLoader().getResourceAsStream("sqlConfig.properties");
			)
		{
			var properties = new Properties();
			properties.load(inStream);
			url = properties.getProperty("url")
				+ properties.getProperty("servername") 
				+ "; databasename=" + properties.getProperty("databasename")
				+ "; username=" + properties.getProperty("username") 
				+ "; password=" + properties.getProperty("password") +";";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	public static Connection getConnection() {
		try{
			
			con = DriverManager.getConnection(getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
