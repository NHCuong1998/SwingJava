package modal;

import java.util.*;

import helper.GetIndexComboID;

public class ListComboItem {
	private List<ComboItem> listCB = new ArrayList<ComboItem>();

	public ListComboItem() {};
	public ListComboItem(List<ComboItem> listCB) {
		this.listCB = listCB;
	}
	
	
	public int findIdToIndex(String id) {
		return GetIndexComboID.getIndex(this.listCB, id);
	}
}
