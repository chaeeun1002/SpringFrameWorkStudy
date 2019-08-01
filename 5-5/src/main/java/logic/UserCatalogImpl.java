package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
@Service
public class UserCatalogImpl implements UserCatalog {
	@Autowired
	private UserDao userdao;
	public void entryUser(User user) {
		this.userdao.create(user);
	}
	public User getUserByUserIdAndPassword(User user) {
		return this.userdao.findUserIdAndPassword(user);
	}

}
