package Entities;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the Offers database table.
 * 
 */
@Entity
@Table(name="Offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OfferId")
	private int offerId;

	private int countAff;

	@Column(name="ImageOffer")
	private String imageOffer;

	private String offerDesc;
 
	private String offerName;

	private double offerprice;
   
	//@Enumerated(EnumType.STRING)
	
	
	private int offerType;

	//bi-directional many-to-one association to AffectationOffre
/*	@OneToMany(mappedBy="offer")
	private List<AffectationOffre> affectationOffres;

	//bi-directional many-to-one association to Pack
	@OneToMany(mappedBy="offer")
	private List<Pack> packs;
*/
	@OneToOne(mappedBy="offer")
	private Pack pack;
	
	
	public Offer(String offerDesc, String offerName, double offerprice) {
		super();
		this.offerDesc = offerDesc;
		this.offerName = offerName;
		this.offerprice = offerprice;
	
	}

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCountAff() {
		return this.countAff;
	}

	public void setCountAff(int countAff) {
		this.countAff = countAff;
	}

	public String getImageOffer() {
		return this.imageOffer;
	}

	public void setImageOffer(String imageOffer) {
		this.imageOffer = imageOffer;
	}

	public String getOfferDesc() {
		return this.offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public double getOfferprice() {
		return this.offerprice;
	}

	public void setOfferprice(double offerprice) {
		this.offerprice = offerprice;
	}

	public int getOfferType() {
		return this.offerType;
	}

	public void setOfferType(int offerType) {
		this.offerType = offerType;
	}

/*	public List<AffectationOffre> getAffectationOffres() {
		return this.affectationOffres;
	}

	public void setAffectationOffres(List<AffectationOffre> affectationOffres) {
		this.affectationOffres = affectationOffres;
	}
*/
	/*public AffectationOffre addAffectationOffre(AffectationOffre affectationOffre) {
		getAffectationOffres().add(affectationOffre);
		affectationOffre.setOffer(this);

		return affectationOffre;
	}

	public AffectationOffre removeAffectationOffre(AffectationOffre affectationOffre) {
		getAffectationOffres().remove(affectationOffre);
		affectationOffre.setOffer(null);

		return affectationOffre;
	}

	public List<Pack> getPacks() {
		return this.packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public Pack addPack(Pack pack) {
		getPacks().add(pack);
		pack.setOffer(this);

		return pack;
	}

	public Pack removePack(Pack pack) {
		getPacks().remove(pack);
		pack.setOffer(null);

		return pack;
	}

	*/
}