package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Promotions database table.
 * 
 */
@Entity
@Table(name="Promotions")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PromotionId")
	private int promotionId;

	private Timestamp promoDateD;

	private Timestamp promoDateF;

	private String promoDesc;

	private int promoPrice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProductId")
	private Product product;

	public Promotion() {
	}

	public int getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public Timestamp getPromoDateD() {
		return this.promoDateD;
	}

	public void setPromoDateD(Timestamp promoDateD) {
		this.promoDateD = promoDateD;
	}

	public Timestamp getPromoDateF() {
		return this.promoDateF;
	}

	public void setPromoDateF(Timestamp promoDateF) {
		this.promoDateF = promoDateF;
	}

	public String getPromoDesc() {
		return this.promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public int getPromoPrice() {
		return this.promoPrice;
	}

	public void setPromoPrice(int promoPrice) {
		this.promoPrice = promoPrice;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}