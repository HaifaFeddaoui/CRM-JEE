package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Favoris database table.
 * 
 */
@Entity
@Table(name="Favoris")
@NamedQuery(name="Favori.findAll", query="SELECT f FROM Favori f")
public class Favori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FavorisId")
	private int favorisId;

	@Column(name="PackId")
	private int packId;

	@Column(name="UserProfilId")
	private String userProfilId;

	public Favori() {
	}

	public int getFavorisId() {
		return this.favorisId;
	}

	public void setFavorisId(int favorisId) {
		this.favorisId = favorisId;
	}

	public int getPackId() {
		return this.packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getUserProfilId() {
		return this.userProfilId;
	}

	public void setUserProfilId(String userProfilId) {
		this.userProfilId = userProfilId;
	}

}