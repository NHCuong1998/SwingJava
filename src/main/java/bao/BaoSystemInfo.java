package bao;

import dao.DaoSystemInfo;
import entity.SystemInfo;

public class BaoSystemInfo {
	public static int get(String name) {
		return new DaoSystemInfo().get(name);
	}
	public String getSysRegex(String name, String inputName, String value) {
		return new DaoSystemInfo().getSysRegex(name, inputName, value);
	}
}
