package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Competitions database table.
 * 
 */
@Entity
@Table(name="Competitions")
@NamedQuery(name="Competition.findAll", query="SELECT c FROM Competition c")
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CompetitionId")
	private int competitionId;

	@Column(name="CompetitionDesc")
	private String competitionDesc;

	@Column(name="CompetitionName")
	private String competitionName;

	@Column(name="ImageCompetition")
	private String imageCompetition;

	@Column(name="OfferId")
	private int offerId;

	@Column(name="ProductId")
	private int productId;

	private float solde;

	//bi-directional many-to-one association to Participation
	@OneToMany(mappedBy="competition")
	private List<Participation> participations;

	public Competition() {
	}

	public int getCompetitionId() {
		return this.competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public String getCompetitionDesc() {
		return this.competitionDesc;
	}

	public void setCompetitionDesc(String competitionDesc) {
		this.competitionDesc = competitionDesc;
	}

	public String getCompetitionName() {
		return this.competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getImageCompetition() {
		return this.imageCompetition;
	}

	public void setImageCompetition(String imageCompetition) {
		this.imageCompetition = imageCompetition;
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public List<Participation> getParticipations() {
		return this.participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public Participation addParticipation(Participation participation) {
		getParticipations().add(participation);
		participation.setCompetition(this);

		return participation;
	}

	public Participation removeParticipation(Participation participation) {
		getParticipations().remove(participation);
		participation.setCompetition(null);

		return participation;
	}

}