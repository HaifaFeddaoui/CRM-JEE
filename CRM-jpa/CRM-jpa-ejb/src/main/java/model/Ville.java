package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Villes database table.
 * 
 */
@Entity
@Table(name="Villes")
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VilleId")
	private int villeId;

	private float lat;

	private float lon;

	private String nom;

	public Ville() {
	}

	public int getVilleId() {
		return this.villeId;
	}

	public void setVilleId(int villeId) {
		this.villeId = villeId;
	}

	public float getLat() {
		return this.lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return this.lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}