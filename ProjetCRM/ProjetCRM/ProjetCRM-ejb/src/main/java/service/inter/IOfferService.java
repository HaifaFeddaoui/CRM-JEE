package interf;

import java.util.List;

import javax.ejb.Remote;

import Entities.Offer;

@Remote
public interface IOfferService {

	
//	public List<Offer> getListOffer();
	public int ajouterOffer(Offer offer);

	public List<Offer> getOffer();
	public void updateOffer(Offer offer);
	public void updateOfferPrix(Offer offer);

	Offer getOfferById(int id);
	Offer getOfferByName(String name);
	
	public String getofferNamebyid(int id);

	public String getofferName(Offer off);
	Offer getOfferMax();
	Offer getOfferMin();

}
