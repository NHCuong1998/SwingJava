package bao;

import java.util.List;

import dao.DaoAssignment;
import entity.Assignment;
import entity.Assignment1;
import entity.AssignmentUser;
import modal.ResultsMessage;

public class BaoAssignment {
	ResultsMessage rsmess = new ResultsMessage();
	
	public Assignment1 getfromId(String id) {
		return new DaoAssignment().getfromId(id);
	}
	
	public List<Assignment1> getall(boolean getall){
		return new BaoAssignment().getall(getall);
	}
	
	public ResultsMessage insert(Assignment1 obj) {
		return new DaoAssignment().insert(obj);
	}
	public ResultsMessage update(Assignment1 obj) {
		return new DaoAssignment().update(obj);
	}
	public List<AssignmentUser> getAssignmentUser(String id){
		return new DaoAssignment().getAssignmentUser(id);
	}
	public ResultsMessage insert(String emp, String project) {
		return new DaoAssignment().insert(emp, project);
	}
	public List<Assignment> getAssignmentDepartment(String id){
		return new DaoAssignment().getAssignmentDepartment(id);
	}
	public ResultsMessage setDone(String id,String project_id, String emp_id) {
		return new DaoAssignment().setDone(id, project_id, emp_id);
	}
	public ResultsMessage delete(String id) {
		return new DaoAssignment().delete(id);
	}
	
}
