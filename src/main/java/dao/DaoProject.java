package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.GetProject;
import entity.Position;
import entity.Project;
import entity.Project_branch;
import modal.ResultsMessage;

public class DaoProject {
	ResultsMessage rsmess = new ResultsMessage();
	List<GetProject> list = new ArrayList<GetProject>();
	
	public GetProject getGetProject(String id, boolean getall, String userLoginId){
		GetProject getPro = new GetProject();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_project(?,?,?,?,?,?,?,?,?,?)}")
			)
		{
			cs.setBoolean(1, false);
			cs.setString(2, id);
			cs.setBoolean(3, getall);
			cs.setString(4, null);
			cs.setString(5, null);
			cs.setString(6, null);
			cs.setNString(7, null);
			cs.setDate(8, null);
			cs.setDate(9, null);
			cs.setString(10, userLoginId);
			
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			rs.next();
			
			getPro.setId(rs.getString("id"));
			getPro.setName(rs.getString("name"));
			getPro.setDate(rs.getDate("datenew") == null ? null : rs.getDate("datenew").toLocalDate());
			getPro.setDescription(rs.getString("description"));
			getPro.setStatus(rs.getBoolean("status"));
			getPro.setType_name(rs.getString("type_name"));
			getPro.setDepartment_name(rs.getString("department_name"));
			getPro.setBranch_name(rs.getString("branch_name"));
			
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		return getPro;
	}
	
	public List<GetProject> getAllProject(boolean firtLoad, String id, boolean getall, String type_id, String department_id, String branch_id, String name, LocalDate date1, LocalDate date2, String userLoginId){
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_project(?,?,?,?,?,?,?,?,?,?)}")
			)
		{
			
			Date date01 = date1==null ? null : java.sql.Date.valueOf(date1);
			Date date02 = date2==null ? null : java.sql.Date.valueOf(date2);
			
			cs.setBoolean(1, firtLoad);
			cs.setString(2, id);
			cs.setBoolean(3, getall);
			cs.setString(4, type_id);
			cs.setString(5, department_id);
			cs.setString(6, branch_id);
			cs.setString(7, name);
			cs.setDate(8,(java.sql.Date) date01);
			cs.setDate(9,(java.sql.Date) date02);
			cs.setString(10, userLoginId);
			
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				list.add(new GetProject(rs.getString("id"), rs.getString("name"),  rs.getDate("datenew") == null ? null : rs.getDate("datenew").toLocalDate(), rs.getString("description"), rs.getBoolean("status"), 
						rs.getString("type_name"), rs.getString("department_name"), rs.getString("branch_name")));
				
			}
		} catch (Exception e) {
			e.getMessage();
//			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
			new ResultsMessage(-1,e.toString()).showMessage(null);
		}
	
		return list;
	}

	public Project getFromID(String id){
		Project project = new Project();
		String sql = "SELECT * FROM project WHERE id ='"+ id + "'";
		try (
				Connection con = DatabaseConnect.getConnection();
				var stmt = con.createStatement();
				var resultSet = stmt.executeQuery(sql);
				)
		{
			while(resultSet.next()) {
				project.setId(resultSet.getString("id"));
				project.setName(resultSet.getString("name"));
				project.setDepartment_id(resultSet.getString("department_id"));
				project.setDescription(resultSet.getString("description"));
				project.setPart(resultSet.getInt("part"));
				project.setProject_type_id(resultSet.getString("project_type_id"));
				project.setDatenew(resultSet.getDate("datenew") == null ? null : resultSet.getDate("datenew").toLocalDate());
				project.setStatus(resultSet.getBoolean("status"));
			}
			
		} catch (Exception e) {
			new ResultsMessage(-1,e.getMessage()).showMessage(null);
		}
		return project;
	}
	
	public List<Project_branch> getProjectBranch(String id){
		List<Project_branch> listPro = new ArrayList<Project_branch>();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_project_branch(?)}")
			)
		{
			
			cs.setString(1, id);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				listPro.add(new Project_branch(rs.getString("id"), rs.getNString("name_project"), rs.getNString("name_project_type"),
						rs.getNString("description"), rs.getDate("datenew") == null ? null : rs.getDate("datenew").toLocalDate()));
				
			}
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return listPro;
	}
	
	public ResultsMessage insert(Project obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_insert(?,?,?,?,?,?,?,?)}")
			)
		{
			Date date = java.sql.Date.valueOf(obj.getDatenew());
			
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getDepartment_id());
			cs.setString(4, obj.getDescription());
			cs.setInt(5, obj.getPart());
			cs.setString(6, obj.getProject_type_id());
			cs.setDate(7, (java.sql.Date) date);
			
			cs.setBoolean(8, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Project obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_update(?,?,?,?,?,?,?,?)}")
			)
		{
			
			Date date = java.sql.Date.valueOf(obj.getDatenew());
			
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getDepartment_id());
			cs.setString(4, obj.getDescription());
			cs.setInt(5, obj.getPart());
			cs.setString(6, obj.getProject_type_id());
			cs.setDate(7, (java.sql.Date) date);
			cs.setBoolean(8, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_project_delete(?,?)}")
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
