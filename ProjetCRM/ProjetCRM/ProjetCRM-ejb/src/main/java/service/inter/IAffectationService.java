package interf;

import java.util.List;

import Entities.AffectationOffre;
import Entities.Offer;


public interface IAffectationService {
	
	
	public int affecter(AffectationOffre affoffer);
	public  List<AffectationOffre> GetMyOffers(String  id);
	AffectationOffre getaffById(int id);
	public void deleteAf(int id);


}
