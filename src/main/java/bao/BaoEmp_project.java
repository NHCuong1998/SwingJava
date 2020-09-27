package bao;

import java.util.List;

import dao.DaoEmp_project;
import dao.DaoProject;
import entity.Emp_project;
import entity.GetProject;
import modal.ResultsMessage;

public class BaoEmp_project {
	ResultsMessage rsmess = new ResultsMessage();
	
//	public Emp_project getMyProject(String id) {
//		
//	}
	public List<Emp_project> getMyProject(String id){
		return new DaoEmp_project().getEmp_project(id);
	}
}
