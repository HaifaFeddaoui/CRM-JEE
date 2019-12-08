package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRes;

	@ManyToOne
	@JoinColumn(name="productId",referencedColumnName="ProductId")
	private Product productId;

	//@Column(name="UserProfilId")
	@ManyToOne
	@JoinColumn(name="UserProfilId",referencedColumnName="UserProfilId")
	private UserProfil user;

	public Reservation() {
	}

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public UserProfil getUser() {
		return user;
	}

	public void setUser(UserProfil user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}