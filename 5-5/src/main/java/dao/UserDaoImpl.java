package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
//자동주입(객체) : Repository
@Repository
public class UserDaoImpl implements UserDao {
	//자동주입(속성) : Autowired
	@Autowired
	private SqlSession session;
	public User findUserIdAndPassword(User user) {
		User list = session.selectOne("mappers.mymapper.getUser",user);
		return list;
	}
	public void create(User user) {
		session.insert("mappers.mymapper.putUser",user);
	}
}
