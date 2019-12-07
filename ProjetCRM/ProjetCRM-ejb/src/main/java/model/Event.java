package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Eventid")
	private int eventid;

	private String etat;

	@Column(name="EventDateD")
	private String eventDateD;

	@Column(name="EventDateF")
	private String eventDateF;

	@Column(name="EventDesc")
	private String eventDesc;

	@Column(name="EventImage")
	private String eventImage;

	@Column(name="EventName")
	private String eventName;

	private String lieu;

	private int nbreplace;

	public Event() {
	}

	public int getEventid() {
		return this.eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getEventDateD() {
		return this.eventDateD;
	}

	public void setEventDateD(String eventDateD) {
		this.eventDateD = eventDateD;
	}

	public String getEventDateF() {
		return this.eventDateF;
	}

	public void setEventDateF(String eventDateF) {
		this.eventDateF = eventDateF;
	}

	public String getEventDesc() {
		return this.eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventImage() {
		return this.eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbreplace() {
		return this.nbreplace;
	}

	public void setNbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}

	public Event(String etat, String eventDateD, String eventDateF, String eventDesc, String eventImage,
			String eventName, String lieu, int nbreplace) {
		super();
		this.etat = etat;
		this.eventDateD = eventDateD;
		this.eventDateF = eventDateF;
		this.eventDesc = eventDesc;
		this.eventImage = eventImage;
		this.eventName = eventName;
		this.lieu = lieu;
		this.nbreplace = nbreplace;
	}

	public Event(int eventid,String eventName,String eventImage,String etat, String eventDateD, String eventDateF, String eventDesc, String lieu,
			int nbreplace) {
		this.eventid=eventid;
		this.eventImage=eventImage;
		this.etat = etat;
		this.eventDateD = eventDateD;
		this.eventDateF = eventDateF;
		this.eventDesc = eventDesc;
		this.eventName = eventName;
		this.lieu = lieu;
		this.nbreplace = nbreplace;
	}

}