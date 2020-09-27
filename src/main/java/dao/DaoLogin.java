package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.CurrentUser;
import entity.Position;
import modal.ResultsMessage;

public class DaoLogin {
	private ResultsMessage rsmess = new ResultsMessage();
	
	public CurrentUser getLogin(String username, String password) {
		CurrentUser user = new CurrentUser();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_login(?,?)}")
				)
		{
			cs.setString(1, username);
			cs.setString(2, password);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setAdmin(rs.getBoolean("isAdmin"));
				user.setBranchId(rs.getString("branchId"));
				user.setPositionId(rs.getString("positionId"));
				user.setListBranch(rs.getString("listBranch"));
				user.setListDepartment(rs.getString("listDepartment"));
				user.setListProject(rs.getString("listProject"));
			}
		} catch (Exception e) {
//			 JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return user;
	}
	
	public ResultsMessage changePassword(String id, String oldPassword, String newPassword) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_change_password(?,?,?)}")
			)
		{
			cs.setString(1, id);
			cs.setString(2, oldPassword);
			cs.setString(3, newPassword);
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
}
