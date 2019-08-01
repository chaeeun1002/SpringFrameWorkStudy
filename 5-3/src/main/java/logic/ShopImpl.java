package logic;

import model.User;

public class ShopImpl implements Shop {
	private UserCatalog userCatlog;
	public void setUserCatlog(UserCatalog userCatlog) {
		this.userCatlog = userCatlog;
	}
	public User getUser(User user) {
		return this.userCatlog.getUserByUserIdAndPassword(user);
	}

}
