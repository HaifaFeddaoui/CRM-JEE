package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Stooore;
import service.inter.IStoreServiceRemote;


@Stateless
@LocalBean
public class StoreService implements IStoreServiceRemote{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterStore(Stooore store) {
		em.persist(store);
		return store.getStoreId();
	}

	@Override
	public List<Stooore> getAllStores() {
		List<Stooore> store = em.createQuery("SELECT s FROM Stooore s", Stooore.class).getResultList();
		return store;
	}

	@Override
	public void deleteStoreById(int storeId) {
		em.remove(em.find(Stooore.class, storeId));		
	}

	@Override
	public void updateStore(Stooore store) {
		Stooore st = em.find(Stooore.class, store.getStoreId());		
		st.setClosingHour(store.getClosingHour());
		st.setLatitude(store.getLatitude());
		st.setLongitude(store.getLongitude());
		st.setOpeningHour(store.getOpeningHour());
		st.setStoreAddress(store.getStoreAddress());
		st.setStoreDesc(store.getStoreDesc());
		//st.setStoreImage(store.getStoreImage());
		st.setStoreName(store.getStoreName());
		st.setStoreNum(store.getStoreNum());
		
	}
	
	
	@Override
	public Stooore getStoreById(int storeId) {
		//Stooore store = em.find(Stooore.class, storeId);
		
		Stooore store = em.createQuery("SELECT s FROM Stooore s where s.storeId=:storeId",Stooore.class).getSingleResult();
		return store;
	}
	
	// Employe employe = em.createQuery("select e from Employe e where e.id=:id", Employe.class).getSingleResult();

}
