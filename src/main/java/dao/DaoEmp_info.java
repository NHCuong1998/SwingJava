package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.Emp_info;
import modal.ResultsMessage;

public class DaoEmp_info {
	ResultsMessage rsmess = new ResultsMessage();
	
	public ResultsMessage insert(Emp_info obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_emp_info_insert(?,?,?,?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getEmployee_id());
			cs.setString(2, obj.getAddress());
			cs.setString(3, obj.getEducation());
			cs.setString(4, obj.getSpecialize());
			cs.setString(5, obj.getPhone());
			cs.setString(6, obj.getEmail());
			cs.setTimestamp(7, obj.getDatejoin());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Emp_info obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_emp_info_update(?,?,?,?,?,?,?)}")
			)
		{
			
			cs.setString(1, obj.getEmployee_id());
			cs.setString(2, obj.getAddress());
			cs.setString(3, obj.getEducation());
			cs.setString(4, obj.getSpecialize());
			cs.setString(5, obj.getPhone());
			cs.setString(6, obj.getEmail());
			cs.setTimestamp(7, obj.getDatejoin());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_emp_info_delete(?)}")
			)
		{
			cs.setString(1, id);
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}

}
