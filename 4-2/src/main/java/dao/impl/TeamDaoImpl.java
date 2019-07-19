package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.dao.DataAccessException;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {

	private EntityManagerFactory emf;
	
	@PersistenceUnit //자동주입
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	@Override
	public List<Team> getTeamList() throws DataAccessException {
		EntityManager em = emf.createEntityManager();//SqlSession과 같이 DB연동을 하는 객체
		return em.createQuery("from Team",Team.class).getResultList();
		//from Team = select * from team
	}

	@Override
	public Team getTeam(Integer teamId) throws DataAccessException {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Team where team_id = :team_id",Team.class).setParameter("team_id", teamId).getSingleResult();
		//:team_id -> teamId를 넘겨줌.(파라미터)
	}
	
}
