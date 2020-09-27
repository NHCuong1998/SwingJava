package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import common.DatabaseConnect;
import entity.Assignment1;
import entity.Position;
import entity.Project_type;
import modal.ResultsMessage;

public class DaoProject_type {
	ResultsMessage rsmess = new ResultsMessage();
	List<Project_type> list = new ArrayList<Project_type>();
	
	public Project_type getfromId(String id) {
		Project_type type = new Project_type();
		String sql = "SELECT * FROM project_type WHERE id ='"+ id + "'";
		try (
				Connection con = DatabaseConnect.getConnection();
				var stmt = con.createStatement();
				var resultSet = stmt.executeQuery(sql);
				)
		{
			resultSet.next();
			type.setId(resultSet.getString("id"));
			type.setName(resultSet.getNString("name"));
			type.setStatus(resultSet.getBoolean("status"));
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return type;
	}

	public List<Project_type> getall(boolean status) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_project_type(?)}")
				)
		{
			cs.setBoolean(1, status);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				list.add(new Project_type(resultSet.getString("id"), resultSet.getString("name"), resultSet.getBoolean("status")));
			}
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return list;
	}
	
	public ResultsMessage insert(Project_type obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_type_insert(?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setBoolean(3, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Project_type obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_type_update(?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setBoolean(3, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_type_delete(?,?)}")
			)
		{
			cs.setString(1, id);
			cs.registerOutParameter(2, Types.BIT); 
			cs.executeUpdate();
			
			
			if(cs.getBoolean(2)) {
				rsmess.setNum(1);
				rsmess.setMessage("Deleted!");
			}	
			else {
				rsmess.setNum(2);
				rsmess.setMessage("Set status is false!");
			}
            
		} catch (Exception e) {
			rsmess.setNum(-1);
			rsmess.setMessage(e.getMessage());
		}
		return rsmess;
	}
}
