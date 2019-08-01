package dao;

import model.User;

public interface UserDao {
	User findUserIdAndPassword(User user);
}
