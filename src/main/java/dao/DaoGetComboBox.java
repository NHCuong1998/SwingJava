package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DatabaseConnect;
import modal.ComboItem;
import modal.ResultsMessage;

public class DaoGetComboBox {
	ResultsMessage rsmess = new ResultsMessage();
	
	public List<ComboItem> getCB(boolean getall, String param, String userLoginID) {
		List<ComboItem> listCB = new ArrayList<ComboItem>();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_getCB(?,?,?)}")
			)
		{
			cs.setBoolean(1, getall);
			cs.setString(2, param);
			cs.setString(3, userLoginID);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				listCB.add(new ComboItem(resultSet.getString("id"), resultSet.getString("name")));
			}	
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return listCB;
	}
}
