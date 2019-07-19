package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException; 
	void deletePlayer(Player player) throws DataAccessException;
	void updatePlayer(Player player) throws DataAccessException;
	Player getPlayer(Integer id) throws DataAccessException;
	List<Player> getPlayerList(Integer id) throws DataAccessException;
}
