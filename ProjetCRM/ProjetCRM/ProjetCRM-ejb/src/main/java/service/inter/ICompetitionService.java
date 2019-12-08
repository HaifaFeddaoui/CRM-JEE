package interf;

import java.util.List;

import javax.ejb.Remote;

import Entities.Competition;

@Remote
public interface ICompetitionService {

	public int ajouterCompetition(Competition competition);	
	public List<Competition> getComp();
	public void deleteC(int id);


	


}
