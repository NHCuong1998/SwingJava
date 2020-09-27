package bao;

import dao.DaoEmp_info;
import entity.Emp_info;
import modal.ResultsMessage;

public class BaoEmp_info {
	ResultsMessage rsmess = new ResultsMessage();
	
	public ResultsMessage insert(Emp_info obj) {
		return new DaoEmp_info().insert(obj);
	}
	public ResultsMessage update(Emp_info obj) {
		return new DaoEmp_info().update(obj);
	}
	public ResultsMessage delete(String id) {
		return new DaoEmp_info().delete(id);
	}
}
