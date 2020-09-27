package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.DatabaseConnect;
import entity.Emp_project;
import entity.GetProject;
import modal.ResultsMessage;

public class DaoEmp_project {
	ResultsMessage rsmess = new ResultsMessage();
	List<Emp_project> list = new ArrayList<Emp_project>();
	
	public List<Emp_project>  getEmp_project(String id) {
		Emp_project empPro = new Emp_project();
		try (
				Connection con = DatabaseConnect.getConnection();
				CallableStatement cs = con.prepareCall("{call sproc_get_myproject(?)}")
			){ 
			cs.setString(1, id);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();			
			while(rs.next()) {
				list.add(new Emp_project(rs.getString("name_project"), rs.getString("name_type_project"), rs.getDate("datejoin") == null ? null : rs.getDate("datejoin").toLocalDate(),
						rs.getDate("datenew") == null ? null : rs.getDate("datenew").toLocalDate(),rs.getInt("done")));
			}			
			
		}catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Fail: "  +e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		return list;
	}
	
}
