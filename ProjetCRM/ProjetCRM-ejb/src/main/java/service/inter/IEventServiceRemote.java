package service.inter;

import java.util.List;

import javax.ejb.Remote;

import model.Event;

@Remote
public interface IEventServiceRemote {
	public int ajouterEvent(Event event);
	public List<Event> getAllEvents();
	public void deleteEventById(int eventId);
	public void updateEvent(Event event);

}
