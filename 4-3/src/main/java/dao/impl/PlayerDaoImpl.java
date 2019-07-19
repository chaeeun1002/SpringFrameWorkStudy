package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {

	//영속성 주입 : EntityManager를 생성해서 쿼리 메서드를 실행하면 transcation.begin과 transaction.commit이 자동실행된다.
	@PersistenceContext 
	private EntityManager em;
//	private EntityManagerFactory emf;
//	@PersistenceUnit //자동주입 
//	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
//	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
//		EntityManager em = emf.createEntityManager(); //mybatis의 SqlSession 객체와 같은 역할
//		EntityTransaction et = em.getTransaction();
//		et.begin();
		em.persist(player);//JPQL에서의 insert(삽입)은 persist메서드에 의해서 삽입된다.
//		et.commit();
	}
	
	@Override
	public void deletePlayer(Player player) throws DataAccessException {
		em.remove(player);//JPQL에서의 delete(삭제)은 remove메서드에 의해서 삽입된다.
	}

	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		em.merge(player);//JPQL에서의 update(수정)은 merge메서드에 의해서 삽입된다.
	}

	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		Player player = em.createQuery("from Player where player_id = :player_id",
										Player.class).setParameter("player_id", id).getSingleResult();
		return player;
	}

	@Override
	public List<Player> getPlayerList(Integer id) throws DataAccessException {
		List<Player> list = em.createQuery("from Player as player where player.team.team_id = :team_id",
											Player.class).setParameter("team_id", id).getResultList();
		return list;
	}
}
