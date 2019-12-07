package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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

	private int userNum;

	public UserProfil() {
	}

	public String getUserProfilId() {
		return this.userProfilId;
	}

	public void setUserProfilId(String userProfilId) {
		this.userProfilId = userProfilId;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getInternet() {
		return this.internet;
	}

	public void setInternet(int internet) {
		this.internet = internet;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return this.point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getUserNum() {
		return this.userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

}