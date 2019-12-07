package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the UserProfils database table.
 * 
 */
@Entity
@Table(name="UserProfils")
@NamedQuery(name="UserProfil.findAll", query="SELECT u FROM UserProfil u")
public class UserProfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserProfilId")
	private String userProfilId;

	private Timestamp birthDate;

	private String gender;

	private String image;

	private int internet;

	private String lastName;

	@Column(name="Name")
	private String name;

	private int point;

	private String role;

	private float solde;

	private String userAddress;

	private String userMail;
	private String soldevent;

	public String getSoldevent() {
		return soldevent;
	}

	public void setSoldevent(String soldevent) {
		this.soldevent = soldevent;
	}

	private int userNum;
	//bi-directional many-to-one association to Participation
		@OneToMany(mappedBy="user")
		private List<Participation> participations;

	public UserProfil() {
	}

	public String getUserProfilId() {
		return userProfilId;
	}

	public void setUserProfilId(String userProfilId) {
		this.userProfilId = userProfilId;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getInternet() {
		return internet;
	}

	public void setInternet(int internet) {
		this.internet = internet;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	
}