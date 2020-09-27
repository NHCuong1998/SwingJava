package bao;

import java.util.List;

import dao.DaoProject_type;
import entity.Project_type;
import modal.ResultsMessage;

public class BaoProject_type {
	public Project_type getfromId(String id) {
		return new DaoProject_type().getfromId(id);
	}
	
	public List<Project_type> getall(boolean getall){
		return new DaoProject_type().getall(getall);
	}
	
	public ResultsMessage insert(Project_type obj) {
		return new DaoProject_type().insert(obj);
	}
	public ResultsMessage update(Project_type obj) {
		return new DaoProject_type().update(obj);
	}
	public ResultsMessage delete(String id) {
		return new DaoProject_type().delete(id);
	}
}
