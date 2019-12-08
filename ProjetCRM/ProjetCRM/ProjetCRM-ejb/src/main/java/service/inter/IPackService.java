package interf;

import java.util.List;

import javax.ejb.Remote;

import Entities.Favori;
import Entities.Pack;

@Remote

public interface IPackService {
	
	
	public List<Pack> getPack();
	Pack getPackById(int id);
	public int Favoris(Favori favori);
	public void updatePack(Pack pack);
	Pack getPackMax();


}
