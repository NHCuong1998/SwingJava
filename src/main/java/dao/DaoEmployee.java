package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.DatabaseConnect;
import entity.Employee;
import modal.EmployeeView;
import modal.ResultsMessage;

public class DaoEmployee {
	ResultsMessage rsmess = new ResultsMessage();
	private List<EmployeeView> list = new ArrayList<EmployeeView>();
	
	// view
	public EmployeeView getFromId(String id) {
		EmployeeView empV = new EmployeeView();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_employeeViewFromId(?)}")
			)
		{
			cs.setString(1, id);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			rs.next();
			empV = new EmployeeView(rs.getString("id"), rs.getString("name"), rs.getString("department_id"), rs.getString("position_id"), rs.getBoolean("status"),
					rs.getString("address"), rs.getString("education"), rs.getString("specialize"), rs.getString("phone"), rs.getString("email"),
					rs.getDate("datejoin") ==null ? null : rs.getDate("datejoin").toLocalDate(), rs.getString("gender"), rs.getNString("gender_name"));
			
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return empV;
	}
	
	public List<EmployeeView> getAll(String userLoginId, boolean getall){
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_employeeView(?,?)}")
				)
		{
			cs.setString(1, userLoginId);
			cs.setBoolean(2, getall);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				list.add(new EmployeeView(rs.getString("id"), rs.getString("name"), rs.getString("department_id"), rs.getString("position_id"), rs.getBoolean("status"),
						rs.getString("address"), rs.getString("education"), rs.getString("specialize"), rs.getString("phone"), rs.getString("email"),
						rs.getDate("datejoin") ==null ? null : rs.getDate("datejoin").toLocalDate(), rs.getString("gender"), rs.getNString("gender_name")));
			}
			
		} catch (Exception e) {
			new ResultsMessage(-1,e.getMessage()).showMessage(null);
		}
		return list;
	}
	
	public List<EmployeeView> getFormLoad(String id, String name, boolean status, LocalDate date1, LocalDate date2,
			String edu, String special, String position, String department, String branch, String userLoginId) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_getFormLoad_employeeView(?,?,?,?,?,?,?,?,?,?,?)}")
				)
		{
			Date d1 = date1 == null ? null : java.sql.Date.valueOf(date1);
			Date d2 = date2 == null ? null : java.sql.Date.valueOf(date2);
			cs.setString(1, id);
			cs.setString(2, name);
			cs.setBoolean(3, status);
			cs.setDate(4, d1);
			cs.setDate(5, d2);
			cs.setString(6, edu);
			cs.setString(7, special);
			cs.setString(8, position);
			cs.setString(9, department);
			cs.setString(10, branch);
			cs.setNString(11, userLoginId);
			
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				list.add(new EmployeeView(rs.getString("id"), rs.getString("name"), rs.getString("department_id"), rs.getString("position_id"), rs.getBoolean("status"),
						rs.getString("address"), rs.getString("education"), rs.getString("specialize"), rs.getString("phone"), rs.getString("email"),
						rs.getDate("datejoin") ==null ? null : rs.getDate("datejoin").toLocalDate(), rs.getString("gender"), rs.getNString("gender_name")));
			}
			
		} catch (Exception e) {
			new ResultsMessage(-1,e.getMessage()).showMessage(null);
		}
		return list;
	}
	
	public ResultsMessage insert(EmployeeView obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_employeeView_insert(?,?,?,?,?,?,?,?,?,?,?,?)}")
			)
		{
			
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getDepartment_id());
			cs.setString(4, obj.getPosition_id());
			cs.setBoolean(5, obj.isStatus());
			cs.setString(6, obj.getAddress());
			cs.setString(7, obj.getEducation());
			cs.setString(8, obj.getSpecialize());
			cs.setString(9, obj.getPhone());
			cs.setString(10, obj.getEmail());
			cs.setDate(11, java.sql.Date.valueOf(obj.getDatejoin()));
			cs.setString(12, obj.getGender());
					
					
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	public ResultsMessage update(EmployeeView obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_employeeView_update(?,?,?,?,?,?,?,?,?,?,?,?)}")
			)
		{
			Date datejoin = obj.getDatejoin() == null ? null : java.sql.Date.valueOf(obj.getDatejoin());
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getName());
			cs.setString(3, obj.getDepartment_id());
			cs.setString(4, obj.getPosition_id());
			cs.setBoolean(5, obj.isStatus());
			cs.setString(6, obj.getAddress());
			cs.setString(7, obj.getEducation());
			cs.setString(8, obj.getSpecialize());
			cs.setString(9, obj.getPhone());
			cs.setString(10, obj.getEmail());
			cs.setDate(11, datejoin);
			cs.setString(12, obj.getGender());
					
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
// normal
	public ResultsMessage insert(Employee obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_employee_insert(?,?,?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getPassword());
			cs.setString(3, obj.getName());
			cs.setString(4, obj.getDepartment_id());
			cs.setString(5, obj.getPosition_id());
			cs.setBoolean(6, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage update(Employee obj) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_employee_update(?,?,?,?,?,?)}")
			)
		{
			cs.setString(1, obj.getId());
			cs.setString(2, obj.getPassword());
			cs.setString(3, obj.getName());
			cs.setString(4, obj.getDepartment_id());
			cs.setString(5, obj.getPosition_id());
			cs.setBoolean(6, obj.isStatus());
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
			
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_employee_delete(?,?)}")
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
