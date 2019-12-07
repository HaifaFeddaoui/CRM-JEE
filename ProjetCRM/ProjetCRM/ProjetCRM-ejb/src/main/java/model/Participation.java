package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Participation.findAll", query="SELECT p FROM Participation p")
public class Participation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partid")
	private int partid;
	@ManyToOne
	@JoinColumn(name = "Eventid", referencedColumnName = "Eventid")
	private Event event;
	@ManyToOne
	@JoinColumn(name = "UserProfilId", referencedColumnName = "UserProfilId")
	private UserProfil user;
	public int getPartid() {
		return partid;
	}
	public void setPartid(int partid) {
		this.partid = partid;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public UserProfil getUser() {
		return user;
	}
	public void setUser(UserProfil user) {
		this.user = user;
	}
	public Participation()
	{
	}
	

}
