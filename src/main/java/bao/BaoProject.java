package bao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProject;
import entity.GetProject;
import entity.Project;
import entity.Project_branch;
import modal.ResultsMessage;

public class BaoProject {
	ResultsMessage rsmess = new ResultsMessage();

	public List<GetProject> getAllProjectFirt(boolean getall, String userLoginId){
		
		return new DaoProject().getAllProject(true, null, getall, null, null, null, null, null, null, userLoginId);
	
	}
	
	public List<GetProject> getAllProject(String id, boolean getall, String type_id, String department_id, String branch_id, String name, LocalDate date1, LocalDate date2, String userLoginId){
		return new DaoProject().getAllProject(false , id, getall, type_id, department_id, branch_id, name, date1, date2, userLoginId);
	
	}
	
	public GetProject getGProjectFromID(String id, boolean getall, String userLoginId) {
		return new DaoProject().getGetProject(id, getall, userLoginId);
	}
	
	public Project getFromID(String id) {
		return new DaoProject().getFromID(id);
	}
	public ResultsMessage insert(Project obj) {
		return new DaoProject().insert(obj);
	}
	public ResultsMessage update(Project obj) {
		return new DaoProject().update(obj);
	}
	public ResultsMessage delete(String id) {
		return new DaoProject().delete(id);
	}
	
	public List<Project_branch> getProjectBrand(String id){
		return new DaoProject().getProjectBranch(id);
	}
}
