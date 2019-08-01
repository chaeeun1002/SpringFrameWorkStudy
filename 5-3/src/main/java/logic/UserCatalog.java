package logic;

import model.User;

public interface UserCatalog {
	User getUserByUserIdAndPassword(User user);
}
