package dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		sqlSession.insert("mappers.mymapper.putPlayer",player);
	}

}
