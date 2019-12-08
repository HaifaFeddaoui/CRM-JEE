package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entities.Product;
import entities.Reservation;
import entities.UserProfil;
import services.ProductService;
import services.ReservationService;
import services.UserProfilService;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int categorie;

	private double newPrice;

	private String prodDesc;

	private String prodImage;

	private String prodName;

	private double prodPrice;

	private int prodQuantity;

	private String prodState;

	private List<Product> products ;
	
	private int nb;


	@EJB
	ProductService PS ;

	@EJB 
	UserProfilService UP;

	@EJB
	ReservationService RS;
	
	//@EJB
	//LikeService LS ;

	public ProductBean() {
		super();
	}

	public ProductBean(int categorie, double newPrice, String prodDesc, String prodImage, String prodName,
			double prodPrice, int prodQuantity, String prodState, List<Product> products, ProductService pS) {
		super();
		this.categorie = categorie;
		this.newPrice = newPrice;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodState = prodState;
		this.products = products;
		PS = pS;
	}

	public ProductBean(int categorie, double newPrice, String prodDesc, String prodImage, String prodName,
			double prodPrice, int prodQuantity, String prodState, List<Product> products) {
		super();
		this.categorie = categorie;
		this.newPrice = newPrice;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodState = prodState;
		this.products = products;
	}

	public ProductBean(int categorie, double newPrice, String prodDesc, String prodImage, String prodName,
			double prodPrice, int prodQuantity, String prodState) {
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

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public String getProdState() {
		return prodState;
	}

	public void setProdState(String prodState) {
		this.prodState = prodState;
	}

	public List<Product> getProducts() {
		products = PS.getAllProducts();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductService getPS() {
		return PS;
	}

	public void setPS(ProductService pS) {
		PS = pS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	


	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}





	private String fromMail;
	private String subject;
	private String message;
	private String toMail;
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void send()
	{
		MailSender mail= new MailSender();
		try {
			mail.sendMail( toMail, message);
		}
		catch(Exception e)
		{

		}


	}


	
	public void reserver(int id)
	{

	Product product = PS.getProductById(id);
	Reservation res = new Reservation();
	UserProfil user = UP.getUserById("rahma");
	res.setUser(user);

	if (product.getProdQuantity() == 0 )
	{
		product.setProdState("Unavailable");
		
	PS.updateProduct(product);
	res.setProductId(product);
		try{
			String host ="smtp.gmail.com" ;
			String users = "rahma.boulila@esprit.tn";
			String pass = "<33LeadingInnovation<33";
			String to = "raahma.boulila@gmail.com";
			String from = "rahma.boulila@esprit.tn";
			String subject = "Reservation Response ";
			
			String messageText = "Sorry this product has run out of stock";
			
			boolean sessionDebug = false;

			Properties props = System.getProperties();
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host, users, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

		}
	
	else if (product.getProdQuantity()>0) {
		int count = product.getProdQuantity()-1;
		product.setProdQuantity(count);
		int nvpts= (int)(user.getPoint() - 20);
		user.setPoint(nvpts);	
		res.setProductId(product);
		res.setUser(user);
		//System.out.println(event.getNbreplace());
		RS.reserver(res); 
		
	}
	
	PS.updateProduct(product);
    UP.updateUser(user);
	/*else if (product.getProdQuantity() >0)
		{
		//  if(product.getProdQuantity() >0 && user.getPoint()>=100)
				//{

					int count = product.getProdQuantity() - 1;
					product.setProdQuantity(count);
					int nvpts= (int)(user.getPoint() - 20);
					user.setPoint(nvpts);	
					res.setProductId(product);
					res.setUser(user);
					//System.out.println(event.getNbreplace());
					RS.reserver(res);  
				}*/

				
}




	/*public void addLike(int id)
	{
		Product product = PS.getProductById(id);
		Like l = new Like();
		UserProfil user = UP.getUserById("rahma");
		l.setProductId(product);
		l.setUser(user);
		
		int nb = l.getNb()+1;
		l.setNb(nb);
		LS.ajouterLike(l);
		
	}*/











}
