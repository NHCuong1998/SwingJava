package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.Position;
import modal.ResultsMessage;

public class DaoPosition {
	ResultsMessage rsmess = new ResultsMessage();
	List<Position> list = new ArrayList<Position>();
	
	public Position getFromId(String id) {
		Position pos = new Position();
		String sql = "SELECT * FROM Position WHERE id ='"+ id + "'";
		try (
				Connection con = DatabaseConnect.getConnection();
				var stmt = con.createStatement();
				var resultSet = stmt.executeQuery(sql);
				)
		{
			resultSet.next();
			pos.setId(resultSet.getString("id"));
			pos.setName(resultSet.getNString("name"));
			pos.setStatus(resultSet.getBoolean("status"));
			pos.setListBranch(resultSet.getString("listBranch"));
			pos.setListDepartment(resultSet.getString("listDepartment"));
			pos.setBranch_id(resultSet.getString("branch_id"));
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return pos;
	}
	
	public List<Position> getAll(String userLoginId, boolean getall) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_position(?,?)}")
				)
		{
			cs.setString(1, userLoginId);
			cs.setBoolean(2, getall);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				list.add(new Position(resultSet.getString("id"), resultSet.getString("name"), resultSet.getBoolean("status"), resultSet.getString("listBranch"),
						resultSet.getString("listDepartment"), resultSet.getString("branch_id")));
			}
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		
		return list;
	}
	
	public ResultsMessage insert(Position obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_position_insert(?,?,?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setBoolean(3, obj.isStatus());
			cs.setString(4, obj.getListBranch());
			cs.setString(5, obj.getListDepartment());
			cs.setNString(6, obj.getBranch_id());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Position obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_position_update(?,?,?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setBoolean(3, obj.isStatus());
			cs.setString(4, obj.getListBranch());
			cs.setString(5, obj.getListDepartment());
			cs.setNString(6, obj.getBranch_id());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_position_delete(?,?)}")
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
