package dao;

import model.User;

public interface LoginDao {
	User getUser(String id);
	String getPassword(String id);
	Integer getIdCount(String id);
}
