package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SqlSession session;
	
	public User getUser(String id) {//계정으로 사용자 검색
		return session.selectOne("mappers.mymapper.getUser",id);
	}

	public String getPassword(String id) {//계정으로 암호 검색
		return session.selectOne("mappers.mymapper.getPassword",id);
	}

	public Integer getIdCount(String id) {//동일한 계정의 갯수 검색
		return session.selectOne("mappers.mymapper.checkId",id);
	}

}
