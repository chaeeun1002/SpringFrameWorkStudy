package logic;

import dao.UserDao;
import model.User;

public class UserCatalogImpl implements UserCatalog {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User getUserByUserIdAndPassword(User user) {
		return this.userDao.findUserIdAndPassword(user);
	}

}
