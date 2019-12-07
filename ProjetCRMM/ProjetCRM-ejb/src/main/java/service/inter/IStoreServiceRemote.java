package service.inter;

import java.util.List;

import javax.ejb.Remote;

import model.Stooore;


@Remote
public interface IStoreServiceRemote {
	public int ajouterStore(Stooore store);
	public List<Stooore> getAllStores();
	public void deleteStoreById(int storeId);
	public void updateStore(Stooore store);
	public Stooore getStoreById(int storeId);
}
