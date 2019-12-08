package imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Favori;
import Entities.Offer;
import Entities.Pack;
import interf.IPackService;

@Stateless
@LocalBean
public class PackService implements IPackService {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Pack> getPack() {
		List<Pack> emp = em.createQuery("SELECT p FROM Pack p", Pack.class).getResultList();

		return emp; }

	@Override
	public Pack getPackById(int id) {
		TypedQuery<Pack> query =
				em.createQuery("SELECT p FROM Pack p WHERE p.packId=:id",
						Pack.class);
		query.setParameter("id", id);

		Pack pa = null;
		try { pa = query.getSingleResult(); }
		catch (Exception e) { System.out.println("Erreur : " + e); }
		return pa;
	}

	@Override
	public int Favoris(Favori favori) {
		System.out.println("In addEmploye: ");
		em.persist(favori);
		System.out.println("Out of addEmploye"+ favori.getFavorisId());
		return favori.getFavorisId();
	}

	@Override
	public void updatePack(Pack pack) {
		Pack pa = em.find(Pack.class, pack.getPackId());

		pa.setCountP(pack.getCountP());

	}

	@Override
	public Pack getPackMax() {
		Query q = em.createQuery ("SELECT p FROM Pack p WHERE p.countP = (SELECT MAX(x.countP) FROM Pack x )");
		Pack result = (Pack) q.getSingleResult ();
		return result;
	}
}


