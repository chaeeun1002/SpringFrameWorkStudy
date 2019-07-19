package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;
import model.PlayerTeam;

public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
	void deletePlayer(Integer id) throws DataAccessException;
	void updatePlayer(Player player) throws DataAccessException;
	Player getPlayer(Integer id) throws DataAccessException;//운동선수 번호로 운동선수 검색
	List<PlayerTeam> getPlayerList(Integer teamId) throws DataAccessException;//팀번호로 팀에 소속된 모든 운동선수 검색
}
