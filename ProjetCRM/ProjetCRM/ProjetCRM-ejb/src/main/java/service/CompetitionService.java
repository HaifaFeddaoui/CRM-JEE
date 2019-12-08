package imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.AffectationOffre;
import Entities.Competition;
import Entities.Offer;
import interf.ICompetitionService;

@Stateless
@LocalBean
public class CompetitionService implements ICompetitionService {

	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterCompetition(Competition competition) {
		System.out.println("In addEmploye: ");
		em.persist(competition);
	//   System.out.println("Out of addEmploye"+ competition.getCompetitionId());
		return competition.getCompetitionId();
		
	}

	@Override
	public List<Competition> getComp() {
		List<Competition> cp = em.createQuery("SELECT c FROM Competition c", Competition.class).getResultList();

		return cp; 
	}

	@Override
	public void deleteC(int id) {

		Competition c = em.find(Competition.class, id);
		em.remove(c);
		
	}
	
	
	
	
}
