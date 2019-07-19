package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {
	@PersistenceContext
	private EntityManager em;
//	private EntityManagerFactory emf;
//	@PersistenceUnit //자동주입 
//	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
//	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
		em.persist(player);//JPQL에서의 insert(삽입)은 persist메서드에 의해서 삽입된다.
//		et.commit();
	}

}
