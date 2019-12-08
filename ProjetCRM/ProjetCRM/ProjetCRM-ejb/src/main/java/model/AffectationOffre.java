package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AffectationOffres database table.
 * 
 */
@Entity
@Table(name="AffectationOffres")
@NamedQuery(name="AffectationOffre.findAll", query="SELECT a FROM AffectationOffre a")
public class AffectationOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AffectationOffreId")
	private int affectationOffreId;

	private int delai;

	private int numTel;

	@Column(name="UserProfilId")
	private String userProfilId;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="OfferId")
	private Offer offer;

	public AffectationOffre() {
	}

	public int getAffectationOffreId() {
		return this.affectationOffreId;
	}

	public void setAffectationOffreId(int affectationOffreId) {
		this.affectationOffreId = affectationOffreId;
	}

	public int getDelai() {
		return this.delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getUserProfilId() {
		return this.userProfilId;
	}

	public void setUserProfilId(String userProfilId) {
		this.userProfilId = userProfilId;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}