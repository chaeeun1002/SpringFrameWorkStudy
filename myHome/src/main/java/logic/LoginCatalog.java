package logic;

import model.User;

public interface LoginCatalog {
	String getPwd(String id);
	Integer getIdCnt(String id);
	void putUser(User user);
}
