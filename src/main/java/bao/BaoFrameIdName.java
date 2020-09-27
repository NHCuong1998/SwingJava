package bao;

import dao.DaoDepartment;
import entity.Department;
import modal.ResultsMessage;

public class BaoFrameIdName {
	ResultsMessage rsmess = new ResultsMessage();
	
	public ResultsMessage insert(Department obj) {
		return new DaoDepartment().insert(obj);
	}
}
