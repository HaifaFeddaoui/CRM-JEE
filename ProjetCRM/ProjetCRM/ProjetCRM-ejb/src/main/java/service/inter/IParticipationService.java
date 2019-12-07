package service.inter;

import java.util.List;

import javax.ejb.Remote;

import model.Participation;

@Remote
public interface IParticipationService {
	public void participer(Participation part);
	public List<Participation> getEventPopulaire();

}
