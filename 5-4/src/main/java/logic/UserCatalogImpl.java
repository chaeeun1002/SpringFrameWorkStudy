package logic;

import dao.UserDao;
import model.User;

public class UserCatalogImpl implements UserCatalog {
	private UserDao userdao;
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public void entryUser(User user) {
		this.userdao.create(user);
	}

}
