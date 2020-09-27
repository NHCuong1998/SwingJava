package bao;

import java.util.List;


import dao.DaoDepartment;

import entity.Department;
import modal.DepartmentGet;
import modal.ResultsMessage;

public class BaoDepartment {
	ResultsMessage rsmess = new ResultsMessage();
	
	public ResultsMessage insert(Department obj) {
		return new DaoDepartment().insert(obj);
	}
	public ResultsMessage update(Department obj) {
		return new DaoDepartment().update(obj);
	}
	public ResultsMessage delete(String id) {
		return new DaoDepartment().delete(id);
	}

	public List<Department> getFromBranch(String branch_id) {
		return new DaoDepartment().getFromBranch(branch_id);
	}
	public Department getFromId(String id) {
		return new DaoDepartment().getfromId(id);
	}
	
	public List<Department> getAll(String userLogin, boolean getall){
		return new DaoDepartment().getAll(userLogin, getall);
	}
}
