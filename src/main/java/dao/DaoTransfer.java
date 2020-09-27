package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.Department;
import entity.GetProject;
import entity.Project;
import entity.Transfer1;
import entity.TransferLog;
import entity.Transfer;
import entity.TransferView;
import modal.EmployeeView;
import modal.ResultsMessage;

public class DaoTransfer {
	ResultsMessage rsmess = new ResultsMessage();
	List<Transfer1> list = new ArrayList<Transfer1>();
	List<Transfer> list1 = new ArrayList<Transfer>();
	List<TransferView> listView = new ArrayList<TransferView>();

	
	public Transfer loadTableTransfer(String id, String oldProject, String newProject){
		Transfer tf = new Transfer();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_row_tranfer(?,?,?,?)}")
			)
		{
			cs.setString(1, id);
			cs.setString(2, oldProject);
			cs.setString(3, newProject);
			cs.setBoolean(4, true);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			rs.next();
			tf.setId(rs.getNString("id"));
			tf.setType(rs.getString("type"));
			tf.setEmp_id(rs.getString("name_emp"));
			tf.setDepartment_old(rs.getString("department_old"));
			tf.setDepartment_new(rs.getString("department_new"));
			tf.setProject_old(rs.getString("project_id_old"));
			tf.setProject_new(rs.getString("project_id_new"));
			tf.setDescription(rs.getString("description"));
			tf.setStatus(rs.getBoolean("status"));
			tf.setDate(rs.getDate("date").toLocalDate());
			tf.setPart(rs.getInt("part"));
			tf.setCheck(rs.getBoolean("check"));
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		return (Transfer) list1;
	}
	
	public List<Transfer1> getTransferAdmin(String branch, int status){
//		try (
//				Connection con = DatabaseConnect.getConnection();
//				CallableStatement cs = con.prepareCall("{call sproc_get_transfer_admin(?,?)}")
//			)
//		{
//			cs.setString(1, branch);
//			cs.setInt(2, status);
//			cs.executeQuery();
//			ResultSet rs = cs.getResultSet();
//			while(rs.next()) {
//				list.add(new Transfer1(rs.getString("id"), rs.getString("id_user"), rs.getNString("name_user"), rs.getNString("old_project"),rs.getNString("new_project"), rs.getNString("reason"),
//						rs.getBoolean("censorship"), rs.getBoolean("admin_watch"), rs.getBoolean("status")
//						));
//			}
//		} catch (Exception e) {
//			e.getMessage();
//			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
//		}
		return list;
	}
	
	public ResultsMessage insert(String username, String oldProject, String newProject, String reason) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_insert(?,?,?,?)}")
			)
		{
			cs.setString(1,	username);
			cs.setString(2, oldProject);
			cs.setString(3, newProject);
			cs.setString(4, reason);
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}

	public List<TransferView> getTranferView(String employee_id, String department_id, boolean getAll, String userLoginId) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_transferView(?,?,?,?)}")
			)
		{
			cs.setString(1, employee_id);
			cs.setString(2, department_id);
			cs.setBoolean(3, getAll);
			cs.setString(4, userLoginId);
			
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				listView.add(
						new TransferView(rs.getString("id"), rs.getString("type"), rs.getString("employee_id"), rs.getString("department_old"), rs.getString("department_new"),
							rs.getString("project_id_old"), rs.getString("project_id_new"), rs.getString("description"), rs.getBoolean("check"), rs.getBoolean("status"),
							rs.getString("department_name_old"), rs.getString("department_name_new"),rs.getString("project_name_old"), rs.getString("project_name_new"),
							rs.getString("employee_name"), rs.getString("type_name"), rs.getDate("date") ==null ? null : rs.getDate("date").toLocalDate())
						);
				
			}
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		return listView;
	}
	
	public ResultsMessage insertDepartmentTransfer(String id, String oldv, String newv, String description) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_insert_department(?,?,?,?)}")
			)
		{
			
			cs.setString(1, id);
			cs.setString(2, oldv);
			cs.setString(3, newv);
			cs.setString(4, description);
					
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete(String id) {
		
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_delete(?,?)}")
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

	public ResultsMessage dpTransferAccectp(String id, String userLoginId, boolean check) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_department_check(?,?,?)}")
			)
		{
			cs.setString(1, id);
			cs.setString(2, userLoginId);
			cs.setBoolean(3, check);
			cs.executeUpdate();
					
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		
		return rsmess;
	}
	public List<Transfer> getTransfer(String id, String branch){
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_transfer(?,?)}")
			)
		{
			cs.setString(1, id);
			cs.setString(2, branch);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				list1.add(new Transfer(rs.getString("id"), rs.getString("type"), rs.getString("name_emp"), rs.getString("department_old"), rs.getString("department_new"),
						rs.getString("project_id_old"), rs.getString("project_id_new"), rs.getString("description"),
						rs.getBoolean("status"), rs.getDate("date").toLocalDate(), rs.getInt("part"),rs.getBoolean("check")
						));
				
			}
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		return list1;
	}
	
	public ResultsMessage insert(String emp, String oldProject, String newProject, String description,String user_name) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_insert_admin(?,?,?,?,?)}")
			)
		{
			cs.setString(1, emp);
			cs.setString(2, oldProject);
			cs.setString(3, newProject);
			cs.setString(4, description);
			cs.setString(5, user_name);
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage censorship(String id, int check, String username, String old_project, String new_project) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_approval(?,?,?,?,?)}")
			)
		{
			cs.setString(1,	id);
			cs.setInt(2, check);
			cs.setString(3, username);
			cs.setString(4, old_project);
			cs.setString(5, new_project);
			
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public ResultsMessage delete_project(String id) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_delete_project(?)}")
			)
		{
			cs.setString(1,	id);
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	public List<TransferLog> getTransferLog(String userLoginId){
		List<TransferLog> listTF = new ArrayList<TransferLog>();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_transferLog(?)}")
			)
		{
			cs.setString(1, userLoginId);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				listTF.add(new TransferLog(rs.getNString("employee_id"), rs.getNString("description"), rs.getNString("old"), rs.getNString("newname"),
						rs.getNString("userCheck"),rs.getDate("date").toLocalDate(), rs.getBoolean("check"), rs.getInt("part")));
			}
		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		return listTF;
	}
	
	public ResultsMessage insertDepartmentTransfer(String id, String oldv, String newv, String description, String userLoginId) {
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_transfer_insert_department(?,?,?,?,?)}")
			)
		{
			
			cs.setString(1, id);
			cs.setString(2, oldv);
			cs.setString(3, newv);
			cs.setString(4, description);
			cs.setNString(5, userLoginId);
					
			rsmess = new ResultsMessage(cs.executeUpdate(),"Success!");
		} catch (Exception e) {
			rsmess = new ResultsMessage(-1,e.getMessage());
		}
		return rsmess;
	}
	
	
}
