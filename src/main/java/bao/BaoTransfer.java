package bao;

import java.util.List;

import dao.DaoBranch;
import dao.DaoTransfer;
import entity.Branch;
import entity.Project;
import entity.Transfer1;
import entity.TransferLog;
import entity.Transfer;
import entity.TransferView;
import modal.ResultsMessage;

public class BaoTransfer {
	ResultsMessage rsmess = new ResultsMessage();
	
//	public List<Transfer1> getTranfer(String id){
//		return new DaoTransfer().getTransfer(id);
//	}
	public Transfer loadTableTransfer(String id, String oldProject, String newProject) {
		return new DaoTransfer().loadTableTransfer(id, oldProject, newProject);
	}
	public List<Transfer> getTranfer(String id, String branch) {
		return new DaoTransfer().getTransfer(id, branch);
	}
	
	public List<Transfer1> getTranferAdmin(String branch,int status){
		return new DaoTransfer().getTransferAdmin(branch, status);
	};
	
	public List<TransferView> getTranferView(String employee_id, String department_id, boolean getAll, String userLoginId){
		return new DaoTransfer().getTranferView(employee_id,department_id,getAll,userLoginId);
	}
	
	public ResultsMessage insert(String username, String oldProject, String newProject, String reason) {
		return new DaoTransfer().insert(username, oldProject, newProject, reason);
	}
	public ResultsMessage insert(String username, String oldProject, String newProject, String description,String user_name) {
		return new DaoTransfer().insert(username, oldProject, newProject, description,user_name);
	}
	
	public ResultsMessage delete(String id) {
		return new DaoTransfer().delete(id);
	}
	public ResultsMessage delete_project(String id) {
		return new DaoTransfer().delete_project(id);
	}
	public ResultsMessage insertDepartmentT(String id, String oldv, String newv, String description) {
		return new DaoTransfer().insertDepartmentTransfer(id, oldv, newv, description);
	}
	public ResultsMessage insertDepartmentT(String id, String oldv, String newv, String description, String userLoginId) {
		return new DaoTransfer().insertDepartmentTransfer(id, oldv, newv, description, userLoginId);
	}
	
	public ResultsMessage dpTransferAccectp(String id, String userLoginId, boolean check) {
		return new DaoTransfer().dpTransferAccectp(id, userLoginId, check);
	}
	public ResultsMessage censorship(String id, int check, String username, String old_project, String new_project) {
		return new DaoTransfer().censorship(id, check, username, new_project, new_project);
	}
	public List<TransferLog> getTransferLog(String userLoginId){
		return new DaoTransfer().getTransferLog(userLoginId);
	}
	
}
