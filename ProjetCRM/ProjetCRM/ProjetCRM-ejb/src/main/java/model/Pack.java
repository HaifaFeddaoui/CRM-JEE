package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Packs database table.
 * 
 */
@Entity
@Table(name="Packs")
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PackId")
	private int packId;

	private String packDesc;

	private String packImage;

	private String packName;

	private float packPrice;

	//bi-directional many-to-one association to Offer
	@OneToOne
	@JoinColumn(name="OfferId")
	private Offer offer;

	//bi-directional many-to-one association to Product
	@OneToOne
	@JoinColumn(name="ProductId")
	private Product product;
	
	
	private int countP;
	
	
	public Pack() {
	}

	
	public int getCountP() {
		return countP;
	}


	public void setCountP(int countP) {
		this.countP = countP;
	}


	public int getPackId() {
		return this.packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getPackDesc() {
		return this.packDesc;
	}

	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}

	public String getPackImage() {
		return this.packImage;
	}

	public void setPackImage(String packImage) {
		this.packImage = packImage;
	}

	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public float getPackPrice() {
		return this.packPrice;
	}

	public void setPackPrice(float packPrice) {
		this.packPrice = packPrice;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}