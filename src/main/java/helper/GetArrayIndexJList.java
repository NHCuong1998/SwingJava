package helper;

import java.util.Arrays;
import java.util.List;

import entity.Department;

public class GetArrayIndexJList {
	public static int[] get(String listStringID, List<Department> listDepartment) {
		List<String> listId = Arrays.asList(listStringID.split(","));
		int[] listIndex = new int[listId.size()];
		int iList=0, x=0;
		
		
//		while(x!=listId.size()-1) {
			for (int j = 0; j < listDepartment.size(); j++) {
				if(listDepartment.get(j).getId().equals(listId.get(x))) {
					listIndex[iList++] = j;
					x++;
				}
				if(x==listId.size())
					break;
			}
//		}
		
		return listIndex;
	}
}
