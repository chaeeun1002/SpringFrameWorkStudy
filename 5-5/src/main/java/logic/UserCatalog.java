package logic;

import model.User;

public interface UserCatalog {
	void entryUser(User user);
	User getUserByUserIdAndPassword(User user);
}
