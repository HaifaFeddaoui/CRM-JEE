package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Participations database table.
 * 
 */
@Entity
@Table(name="Participations")
@NamedQuery(name="Participation.findAll", query="SELECT p FROM Participation p")
public class Participation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ParticipationId")
	private int participationId;

	@Column(name="UserProfilId")
	private String userProfilId;

	private String winner;

	//bi-directional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="CompetitionId")
	private Competition competition;

	public Participation() {
	}

	public int getParticipationId() {
		return this.participationId;
	}

	public void setParticipationId(int participationId) {
		this.participationId = participationId;
	}

	public String getUserProfilId() {
		return this.userProfilId;
	}

	public void setUserProfilId(String userProfilId) {
		this.userProfilId = userProfilId;
	}

	public String getWinner() {
		return this.winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

}