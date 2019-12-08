package imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.AffectationOffre;
import Entities.Offer;
import interf.IAffectationService;

@Stateless
@LocalBean
public class AffectationService implements IAffectationService{

	@PersistenceContext
	EntityManager em;

	@Override
	public int affecter(AffectationOffre affoffer) {
		System.out.println("In addEmploye: ");
		em.persist(affoffer);
		System.out.println("Out of addEmploye"+ affoffer.getAffectationOffreId());
		return affoffer.getAffectationOffreId();
	}

	@Override
	public List<AffectationOffre> GetMyOffers(String id) {
		TypedQuery<AffectationOffre> query= em.createQuery(
				"SELECT a FROM AffectationOffre a "					
						+ "where a.userProfilId=:id", 
						AffectationOffre.class);

		query.setParameter("id", id);

		return query.getResultList();
	}

	@Override
	public AffectationOffre getaffById(int id) {
		TypedQuery<AffectationOffre> query =
				em.createQuery("SELECT a FROM AffectationOffre a WHERE a.affectationOffreId=:id",
						AffectationOffre.class);
		query.setParameter("id", id);

		AffectationOffre aff = null;
		try { aff = query.getSingleResult(); }
		catch (Exception e) { System.out.println("Erreur : " + e); }
		return aff;		

	}

	@Override
	public void deleteAf(int id) {

		AffectationOffre aff = em.find(AffectationOffre.class, id);
		em.remove(aff);
	}

	
	



}
