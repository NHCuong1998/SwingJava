package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.SystemInfo;
import entity.SystemRegex;

public class DaoSystemInfo {
	public static int get(String name) {
		int result = 0;
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call getSystemInfoByName(?)}")
				)
		{
			cs.setString(1, name);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			rs.next();
			result = rs.getInt("value");
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
	
	public String getSysRegex(String name, String inputName, String value) {
		String error="";
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_regex(?)}")
			)
		{
			cs.setString(1, name);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			rs.next();
			
			if(rs.getString("value") != null )
				error = Pattern.matches(rs.getString("value"), value) ? "" : inputName + " " + rs.getString("title") +"\n";
			
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return error;
	}
}
