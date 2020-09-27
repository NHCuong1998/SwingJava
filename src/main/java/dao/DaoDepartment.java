package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import common.DatabaseConnect;
import entity.Department;
import entity.Position;
import modal.DepartmentGet;
import modal.ResultsMessage;

public class DaoDepartment {
	ResultsMessage rsmess = new ResultsMessage();
	List<Department> list = new ArrayList<Department>();
	
	public Department getfromId(String id) {
		Department dep = new Department();
		String sql = "SELECT * FROM Department WHERE id ='"+ id + "'";
		try (
				Connection con = DatabaseConnect.getConnection();
				var stmt = con.createStatement();
				var resultSet = stmt.executeQuery(sql);
				)
		{
			resultSet.next();
			dep.setId(resultSet.getString("id"));
			dep.setName(resultSet.getNString("name"));
			dep.setBranch_id(resultSet.getString("branch_id"));
			dep.setStatus(resultSet.getBoolean("status"));
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return dep;
	}
	
	public List<Department> getAll(String userLogin, boolean getall) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_department(?,?)}")
				)
		{
			cs.setString(1, userLogin);
			cs.setBoolean(2, getall);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				list.add(new Department(resultSet.getString("id"), resultSet.getNString("name"), resultSet.getString("branch_id"), resultSet.getBoolean("status")));
			}
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return list;
	}

	public List<Department> getFromBranch(String branch_id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_departmentFromBranch(?)}")
				)
		{
			cs.setString(1, branch_id);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				list.add(new Department(resultSet.getString("id"), resultSet.getNString("name"), resultSet.getString("branch_id"), resultSet.getBoolean("status")));
			}
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return list;
	}
	
	public ResultsMessage insert(Department obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_department_insert(?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getBranch_id());
			cs.setBoolean(4, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Department obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_department_update(?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getBranch_id());
			cs.setBoolean(4, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_department_delete(?,?)}")
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
