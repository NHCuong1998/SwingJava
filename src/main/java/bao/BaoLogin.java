package bao;

import dao.DaoLogin;
import entity.CurrentUser;
import modal.ResultsMessage;

public class BaoLogin {
	public CurrentUser getLogin(String username, String password) {
		return new DaoLogin().getLogin(username, password);
	}
	public ResultsMessage changePassword(String id, String oldPassword, String newPassword) {
		return new DaoLogin().changePassword(id, oldPassword, newPassword);
	}
}
