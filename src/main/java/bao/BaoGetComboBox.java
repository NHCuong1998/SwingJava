package bao;

import java.util.ArrayList;
import java.util.List;

import dao.DaoGetComboBox;
import modal.ComboItem;
import modal.Gender;

public class BaoGetComboBox {
	List<ComboItem> list = new ArrayList<ComboItem>();
	
	public List<ComboItem> getList(String exspres, String userLoginID){	
		return new DaoGetComboBox().getCB(false, exspres, userLoginID);
	}
	
	public List<ComboItem> getListAll(String exspres, String userLoginID){	
		return new DaoGetComboBox().getCB(true, exspres, userLoginID);
	}
	
//	public List<ComboItem> getListGender(){	
////		list.add(new ComboItem("0","Famale"));
////		list.add(new ComboItem("1","Male"));
////		list.add(new ComboItem("2","Order"));
//		return new;
//	}
}
