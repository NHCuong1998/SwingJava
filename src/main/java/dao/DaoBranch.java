package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import common.DatabaseConnect;
import entity.Branch;
import entity.Position;
import modal.ResultsMessage;

public class DaoBranch {
	
	ResultsMessage rsmess = new ResultsMessage();
	List<Branch> list = new ArrayList<Branch>();
	
	public Branch getfromId(String id) {
		Branch bra = new Branch();
		String sql = "SELECT * FROM branch WHERE id ='"+ id + "'";
		try (
				Connection con = DatabaseConnect.getConnection();
				var stmt = con.createStatement();
				var resultSet = stmt.executeQuery(sql);
				)
		{
			resultSet.next();
			bra.setId(resultSet.getString("id"));
			bra.setName(resultSet.getNString("name"));
			bra.setStatus(resultSet.getBoolean("status"));
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return bra;
	}
	
	public List<Branch> getall(String userLoginID, boolean getall) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_branch(?,?)}")
			)
		{
			cs.setString(1, userLoginID);
			cs.setBoolean(2, getall);
			cs.executeQuery();
			ResultSet resultSet = cs.getResultSet();
			while(resultSet.next()) {
				list.add(new Branch(resultSet.getString("id"), resultSet.getString("name"), resultSet.getBoolean("status")));
			}	
		} catch (Exception e) {
			
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return list;
	}
	
	public ResultsMessage insert(Branch branch) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_branch_insert(?,?,?)}")
			)
		{
			cs.setString(1, branch.getId());
			cs.setString(2, branch.getName());
			cs.setBoolean(3, branch.getStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}

	public ResultsMessage update(Branch branch) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_branch_update(?,?,?)}")
			)
		{
			cs.setString(1, branch.getId());
			cs.setString(2, branch.getName());
			cs.setBoolean(3, branch.getStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}

	public ResultsMessage delete(String id) {
		
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_branch_delete(?,?)}")
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
