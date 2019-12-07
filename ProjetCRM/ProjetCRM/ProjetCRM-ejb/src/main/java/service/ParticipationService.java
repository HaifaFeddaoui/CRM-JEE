package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Participation;

import service.inter.IParticipationService;
@Stateless
@LocalBean
public class ParticipationService implements IParticipationService{
	@PersistenceContext
	EntityManager em;
	@Override
	public void participer(Participation part) 
	{

		
		em.persist(part	);
	}
	@Override
	public List<Participation> getEventPopulaire() {
		List<Participation> emp = em.createQuery("SELECT MAX(Eventid) "
				+ "FROM (SELECT COUNT(*) AS Eventid "
				+ "FROM Participation GROUP BY Eventid) AS Results", Participation.class).getResultList();
		return emp;
	}

}
