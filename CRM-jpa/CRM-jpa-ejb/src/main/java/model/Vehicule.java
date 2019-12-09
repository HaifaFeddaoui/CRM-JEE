package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Vehicules database table.
 * 
 */
@Entity
@Table(name="Vehicules")
@NamedQuery(name="Vehicule.findAll", query="SELECT v FROM Vehicule v")
public class Vehicule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VehiculeId")
	private int vehiculeId;

	private Date dateCirc;

	@Column(name="Matricule")
	private String matricule;

	private String typeVh;

	public Vehicule() {
	}

	public int getVehiculeId() {
		return this.vehiculeId;
	}

	public void setVehiculeId(int vehiculeId) {
		this.vehiculeId = vehiculeId;
	}

	public Date getDateCirc() {
		return this.dateCirc;
	}

	public void setDateCirc(Date dateCirc) {
		this.dateCirc = dateCirc;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getTypeVh() {
		return this.typeVh;
	}

	public void setTypeVh(String typeVh) {
		this.typeVh = typeVh;
	}

}