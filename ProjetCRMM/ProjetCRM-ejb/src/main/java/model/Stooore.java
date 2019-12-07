package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stooores database table.
 * 
 */
@Entity
@Table(name="Stooores")
@NamedQuery(name="Stooore.findAll", query="SELECT s FROM Stooore s")
public class Stooore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="storeId")

	private int storeId;

	private String closingHour;

	private int latitude;

	private int longitude;

	private String openingHour;

	private String storeAddress;

	private String storeDesc;

	private String storeImage;

	private String storeName;

	private int storeNum;

	public Stooore() {
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getClosingHour() {
		return this.closingHour;
	}

	public void setClosingHour(String closingHour) {
		this.closingHour = closingHour;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getOpeningHour() {
		return this.openingHour;
	}

	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreDesc() {
		return this.storeDesc;
	}

	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}

	public String getStoreImage() {
		return this.storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreNum() {
		return this.storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public Stooore(int storeId, String closingHour, int latitude, int longitude, String openingHour,
			String storeAddress, String storeDesc, String storeImage, String storeName, int storeNum) {
		super();
		this.storeId = storeId;
		this.closingHour = closingHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.openingHour = openingHour;
		this.storeAddress = storeAddress;
		this.storeDesc = storeDesc;
		this.storeImage = storeImage;
		this.storeName = storeName;
		this.storeNum = storeNum;
	}
	
	

	public Stooore(int storeId, String closingHour, int latitude, int longitude, String openingHour,
			String storeAddress, String storeDesc, String storeName, int storeNum) {
		super();
		this.storeId = storeId;
		this.closingHour = closingHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.openingHour = openingHour;
		this.storeAddress = storeAddress;
		this.storeDesc = storeDesc;
		this.storeName = storeName;
		this.storeNum = storeNum;
	}

	public Stooore(String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeImage, String storeName, int storeNum) {
		super();
		this.closingHour = closingHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.openingHour = openingHour;
		this.storeAddress = storeAddress;
		this.storeDesc = storeDesc;
		this.storeImage = storeImage;
		this.storeName = storeName;
		this.storeNum = storeNum;
	}

	public Stooore(String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeName, int storeNum) {
		super();
		this.closingHour = closingHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.openingHour = openingHour;
		this.storeAddress = storeAddress;
		this.storeDesc = storeDesc;
		this.storeName = storeName;
		this.storeNum = storeNum;
	}
	
	

}