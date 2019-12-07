package managedbean;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.servlet.http.Part;

import model.Event;
import service.EventService;


/**
 * Session Bean implementation class EventBean
 */
@ManagedBean(name="ebean")
@SessionScoped

public class EventBean implements Serializable {

    /**
     * Default constructor. 
     */
	private static final long serialVersionUID = 1L;
    private String etat;
    private String eventDateD;
    private String eventDateF;
    private String eventDesc;
    private String eventImage;
    private String eventName;
    private String lieu;
    private int nbreplace;
    private Part file;
    private List<Event> events;
    @EJB
    EventService eventService;
    
    public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public EventBean() {
    }
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getEventDateD() {
		return eventDateD;
	}
	public void setEventDateD(String eventDateD) {
		this.eventDateD = eventDateD;
	}
	public String getEventDateF() {
		return eventDateF;
	}
	public void setEventDateF(String eventDateF) {
		this.eventDateF = eventDateF;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getNbreplace() {
		return nbreplace;
	}
	public void setNbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}
	
	
	public EventBean(String etat, String eventDateD, String eventDateF, String eventDesc, String eventImage,
			String eventName, String lieu, int nbreplace, List<Event> events ) {
		super();
		this.etat = etat;
		this.eventDateD = eventDateD;
		this.eventDateF = eventDateF;
		this.eventDesc = eventDesc;
		this.eventImage = eventImage;
		this.eventName = eventName;
		this.lieu = lieu;
		this.nbreplace = nbreplace;
		this.events=events;
	}
	public void addEvent() throws IOException {
		
		eventService.ajouterEvent(new Event(etat, eventDateD, eventDateF, eventDesc, file.getSubmittedFileName(),
		eventName,lieu,nbreplace)); 
		//String folderName1 = Util.serverI;
		//uploadimage(folderName1);
		}
	

	
    public List<Event> getEvents() {
	events = eventService.getAllEvents();
	return events;
	}
    public void removeEvent(int eventId)
    	{
    	eventService.deleteEventById(eventId);
    	}
    private int eventIdToBeUpdated;
    public void displayEvent(Event event)
    {
    this.setEventName(event.getEventName());
    this.setEventImage(event.getEventImage());
    this.setEventDateD(event.getEventDateD());
    this.setEventDateF(event.getEventDateF());
    this.setEventDesc(event.getEventDesc());
    this.setLieu(event.getLieu());
    this.setNbreplace(event.getNbreplace());
    this.setEtat(event.getEtat());
    
    }
    
    public void updateEvent()
    { 
    	eventService.updateEvent(new Event(eventIdToBeUpdated,eventName,eventImage,etat, eventDateD, eventDateF, eventDesc,lieu,nbreplace));
    	}
public String uploadimage(String folderName1) throws IOException {
		
		if (file != null) {
		
		InputStream in = file.getInputStream();
		File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		out.close();
		in.close();
		return "succes-image-uplaod?faces-redirect=true";
		}
		else {
			return "succes-image-uplaod?faces-redirect=true";	
		}	
	}
	
    

}
