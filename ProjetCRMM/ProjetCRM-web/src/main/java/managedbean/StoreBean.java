package managedbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import model.Stooore;
import service.StoreService;



@ManagedBean
@SessionScoped
public class StoreBean implements Serializable {

	//private int storeId;
	private static final long serialVersionUID = 1L;

	private String closingHour;
	private int latitude;
	private int longitude;
	private String openingHour;
	private String storeAddress;
	private String storeDesc;
	private String storeImage;
	private String storeName;
	private int storeNum;
	private Part file;
	private List<Stooore> stores;
	private int storeIdToBeUpdated;
	
	private Stooore store ;


	
	public Stooore getStore(int storeId) {
		store = SS.getStoreById(storeId);
		return store;
	}

	public void setStore(Stooore store) {
		this.store = store;
	}




	@EJB
	StoreService SS  ;
	
	

	public int getStoreIdToBeUpdated() {
		return storeIdToBeUpdated;
	}

	public void setStoreIdToBeUpdated(int storeIdToBeUpdated) {
		this.storeIdToBeUpdated = storeIdToBeUpdated;
	}

	public String getClosingHour() {
		return closingHour;
	}

	public void setClosingHour(String closingHour) {
		this.closingHour = closingHour;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreDesc() {
		return storeDesc;
	}

	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}

	public String getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	

	public StoreService getSS() {
		return SS;
	}

	public void setSS(StoreService sS) {
		SS = sS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StoreBean() {
		super();
	}

	public StoreBean(String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeImage, String storeName, int storeNum, List<Stooore> stores) {
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
		this.stores = stores;
	}

	public StoreBean(String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeImage, String storeName, int storeNum, Part file, List<Stooore> stores,
			StoreService sS) {
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
		this.file = file;
		this.stores = stores;
		SS = sS;
	}

	public String uploadimage(String folderName1) throws IOException {

		if (file != null) {

			InputStream in = file.getInputStream();
			File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			out.close();
			in.close();
			return "succes-image-uplaod?faces-redirect=true";
		}
		else {
			return "succes-image-uplaod?faces-redirect=true";	
		}	
	}


	/*public void addStore() throws IOException {
		SS.ajouterStore(new Stooore(closingHour, latitude, longitude, openingHour, storeAddress, storeDesc, file.getSubmittedFileName(), 
				storeName, storeNum) );
		String folderName1=Util.serverI;
		uploadimage(folderName1) ;	}*/

	public void addStore() {
		SS.ajouterStore(new Stooore(closingHour, latitude, longitude, openingHour, storeAddress, storeDesc, storeImage, storeName, storeNum)); }

	
	public List<Stooore> getStores() {
		stores = SS.getAllStores();
		return stores;
	}
	
	public void setStores(List<Stooore> stores) {
		this.stores = stores;}

	public void removeStore(int storeId)
	{
		SS.deleteStoreById(storeId);
	}
	
	public void displayStore(Stooore store)
	{
		this.setClosingHour(store.getClosingHour());
		this.setLatitude(store.getLatitude());
		this.setLongitude(store.getLongitude());
		this.setOpeningHour(store.getOpeningHour());
		this.setStoreAddress(store.getStoreAddress());
		this.setStoreDesc(store.getStoreDesc());
		this.setStoreName(store.getStoreName());
		this.setStoreNum(store.getStoreNum());	
		this.setStoreIdToBeUpdated(store.getStoreId());
	}

	public StoreBean(String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeImage, String storeName, int storeNum, Part file, List<Stooore> stores,
			int storeIdToBeUpdated, StoreService sS) {
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
		this.file = file;
		this.stores = stores;
		this.storeIdToBeUpdated = storeIdToBeUpdated;
		SS = sS;
	}

	public StoreBean(int storeIdToBeUpdated,String closingHour, int latitude, int longitude, String openingHour, String storeAddress,
			String storeDesc, String storeImage, String storeName, int storeNum ) {
		super();
		this.storeIdToBeUpdated = storeIdToBeUpdated;

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
	

	
	
	public void updateStore() { SS.updateStore(new Stooore (storeIdToBeUpdated,closingHour, latitude, longitude,
			
	openingHour, storeAddress, storeDesc, storeName, storeNum));}

	
	
	
	
	/*public List<Stooore> getStores() {
		return stores;
	}

	public void setStores(List<Stooore> stores) {
		this.stores = stores;
	}*/

}
