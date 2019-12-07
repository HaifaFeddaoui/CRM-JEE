package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Products database table.
 * 
 */
@Entity
@Table(name="Products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductId")
	private int productId;

	private int categorie;

	private double newPrice;

	private String prodDesc;

	private String prodImage;

	private String prodName;

	private double prodPrice;

	private int prodQuantity;

	private String prodState;

	@Column(name="StoreId")
	private int storeId;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategorie() {
		return this.categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public double getNewPrice() {
		return this.newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdImage() {
		return this.prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQuantity() {
		return this.prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public String getProdState() {
		return this.prodState;
	}

	public void setProdState(String prodState) {
		this.prodState = prodState;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Product(int productId, int categorie, double newPrice, String prodDesc, String prodImage, String prodName,
			double prodPrice, int prodQuantity, String prodState, int storeId) {
		super();
		this.productId = productId;
		this.categorie = categorie;
		this.newPrice = newPrice;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodState = prodState;
		this.storeId = storeId;
	}

	public Product(int categorie, double newPrice, String prodDesc, String prodImage, String prodName, double prodPrice,
			int prodQuantity, String prodState, int storeId) {
		super();
		this.categorie = categorie;
		this.newPrice = newPrice;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodState = prodState;
		this.storeId = storeId;
	}

	public Product(int categorie, double newPrice, String prodDesc, String prodImage, String prodName, double prodPrice,
			int prodQuantity, String prodState) {
		super();
		this.categorie = categorie;
		this.newPrice = newPrice;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodState = prodState;
	}

	
}