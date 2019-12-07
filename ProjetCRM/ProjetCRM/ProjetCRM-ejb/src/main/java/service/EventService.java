package service;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import model.Event;
import service.inter.IEventServiceRemote;

@Stateless
@LocalBean
public class EventService  implements IEventServiceRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public  int ajouterEvent(Event event) {
		em.persist(event);
		return event.getEventid();
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> emp = em.createQuery("Select e from Event e", Event.class).getResultList();
		return emp;
	}
	@Override
	public List<Event> getEvent() {
		List<Event> e = em.createQuery("SELECT e From Event e WHERE nbreplace=0 ", Event.class).getResultList();
		return e;
	}
	public void deleteEventById(int eventId) {
		em.remove(em.find(Event.class, eventId));

	}
	@Override
	public void updateEvent(Event event) {
		Event emp = em.find(Event.class, event.getEventid());
		emp.setEventName(event.getEventName());
		//emp.setEventImage(event.getEventImage());
		emp.setEventDateD(event.getEventDateD());
		emp.setEventDateF(event.getEventDateF());
		emp.setEventDesc(event.getEventDesc());
		emp.setEventprix(event.getEventprix());
		emp.setLieu(event.getLieu());
		emp.setNbreplace(event.getNbreplace());

	}
	@Override
	public Event getEventById(int Eventid) {
		return em.find(Event.class, Eventid);
	}
	
	

}
