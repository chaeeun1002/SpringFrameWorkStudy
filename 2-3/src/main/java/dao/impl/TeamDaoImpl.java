package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Team> getTeamList() throws DataAccessException {
		return sqlSession.selectList("mappers.mymapper.getTeamList");
	}

	@Override
	public Team getTeam(Integer teamId) throws DataAccessException {
		return sqlSession.selectOne("mappers.mymapper.getTeam",teamId);
	}

}
