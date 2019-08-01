package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoImpl implements UserDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public User findUserIdAndPassword(User user) {
		User list = session.selectOne("mappers.mymapper.getUser",user);
		return list;
	}

}
