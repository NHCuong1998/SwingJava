package helper;

import java.util.List;

import modal.ComboItem;

public class GetIndexComboID {
	public static int getIndex(List<ComboItem> listCB, String id) {
		int index=-1;
		int i = 0;
		for (ComboItem comboItem : listCB) {
			if(comboItem.getId().equals(id)) {
				index = i;
				break;
			}	
			i++;
		}
		return index;
	}
}
