package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;
import model.PlayerTeam;
import model.Team;

public class PlayerDaoImpl implements PlayerDao {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		sqlSession.insert("mappers.mymapper.putPlayer",player);
	}

	@Override
	public void deletePlayer(Integer id) throws DataAccessException {
		sqlSession.delete("mappers.mymapper.deletePlayer",id);
	}

	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		sqlSession.update("mappers.mymapper.updatePlayer",player);
	}

	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		PlayerTeam pl = sqlSession.selectOne("mappers.mymapper.getPlayerTeam",id);
		if(pl != null) {
			Player player = new Player();
			player.setPlayer_id(pl.getPlayer_id());
			player.setName(pl.getPlayer_name());
			Team team = new Team();
			team.setTeam_id(pl.getTeam_id());
			team.setName(pl.getTeamName());
			player.setTeam(team);
			return player;
		}else {
			return null;
		}
	}

	@Override
	public List<PlayerTeam> getPlayerList(Integer teamId) throws DataAccessException {
		List<PlayerTeam> list = sqlSession.selectList("mappers.mymapper.getTeamPlayer",teamId);
		return list;
	}

}
