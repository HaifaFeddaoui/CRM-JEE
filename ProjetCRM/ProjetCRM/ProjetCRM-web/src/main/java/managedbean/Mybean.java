package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Entities.AffectationOffre;
import Entities.Competition;
import Entities.Favori;
import Entities.Offer;
import Entities.Pack;
import Entities.UserProfil;
import Entities.Role;
import imp.AffectationService;
import imp.CompetitionService;
import imp.OfferService;
import imp.PackService;
import imp.UserProfilService;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

@ManagedBean
@SessionScoped public class Mybean implements Serializable {
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
	private int affectationOffreId;

	private String lastName;

	private String name;

	private String maxoffImage;
	private String maxoffname;
	private String maximagePA;
	private String maxnamePA;
	
	 private Role role;
	 
	 private float soldeC;
	 


   public float getSoldeC() {
		return soldeC;
	}
	public void setSoldeC(float soldeC) {
		this.soldeC = soldeC;
	}
public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


private int idPa;

	
	private String nameOF;


	private String desOF;
	private double price;
	private String imageOF;




	private int packId;

	private String packDesc;

	private String packImage;

	private String packName;

	private float packPrice;

	private String namePa;
	private String descPa;
	private float pricePa;
	private String imagePa;
	private String  offerPa;
	
	private String competitionName;
	private String competitionDesc;
	
	private String competitionImage;
	
	
	
	

	 public String getCompetitionImage() {
		return competitionImage;
	}
	public void setCompetitionImage(String competitionImage) {
		this.competitionImage = competitionImage;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public String getCompetitionDesc() {
		return competitionDesc;
	}
	public void setCompetitionDesc(String competitionDesc) {
		this.competitionDesc = competitionDesc;
	}


	private Part file; 
	    public Part getFile() {
			return file;
		}
		public void setFile(Part file) {
			this.file = file;
		}



	public int getIdPa() {
		return idPa;
	}

	public void setIdPa(int idPa) {
		this.idPa = idPa;
	}

	public String getMaximagePA() {
		return maximagePA;
	}

	public void setMaximagePA(String maximagePA) {
		this.maximagePA = maximagePA;
	}

	public String getMaxnamePA() {
		return maxnamePA;
	}

	public void setMaxnamePA(String maxnamePA) {
		this.maxnamePA = maxnamePA;
	}

	public String getNamePa() {
		return namePa;
	}

	public void setNamePa(String namePa) {
		this.namePa = namePa;
	}

	public String getDescPa() {
		return descPa;
	}

	public void setDescPa(String descPa) {
		this.descPa = descPa;
	}

	public float getPricePa() {
		return pricePa;
	}

	public void setPricePa(float pricePa) {
		this.pricePa = pricePa;
	}

	public String getImagePa() {
		return imagePa;
	}

	public void setImagePa(String imagePa) {
		this.imagePa = imagePa;
	}

	public String getOfferPa() {
		return offerPa;
	}

	public void setOfferPa(String offerPa) {
		this.offerPa = offerPa;
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getPackDesc() {
		return packDesc;
	}

	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}

	public String getPackImage() {
		return packImage;
	}

	public void setPackImage(String packImage) {
		this.packImage = packImage;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public float getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(float packPrice) {
		this.packPrice = packPrice;
	}

	public String getNameOF() {
		return nameOF;
	}

	public void setNameOF(String nameOF) {
		this.nameOF = nameOF;
	}

	public String getDesOF() {
		return desOF;
	}

	public void setDesOF(String desOF) {
		this.desOF = desOF;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageOF() {
		return imageOF;
	}

	public void setImageOF(String imageOF) {
		this.imageOF = imageOF;
	}


	private float mysolde;

	public String getMaxoffImage() {
		return maxoffImage;
	}

	public void setMaxoffImage(String maxoffImage) {
		this.maxoffImage = maxoffImage;
	}

	public String getMaxoffname() {
		return maxoffname;
	}

	public void setMaxoffname(String maxoffname) {
		this.maxoffname = maxoffname;
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



	public float getMysolde() {
		return mysolde;
	}

	public void setMysolde(float mysolde) {
		this.mysolde = mysolde;
	}

	public int getAffectationOffreId() {
		return this.affectationOffreId;
	}

	public void setAffectationOffreId(int affectationOffreId) {
		this.affectationOffreId = affectationOffreId;
	}


	private int delai;

	private int numTel;

	private int offerr;



	public int getOfferr() {
		return offerr;
	}

	public void setOfferr(int offerr) {
		this.offerr = offerr;
	}
	

	public Mybean(String offerDesc, String offerName, double offerprice,int numTel, int delai) {
		super();
		this.offerDesc = offerDesc;
		this.offerName = offerName;
		this.offerprice = offerprice;
		this.numTel=numTel;
		this.delai=delai;

	}

	public Mybean() {
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


	public int getDelai() {
		return this.delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	@EJB
	OfferService OF;

	@EJB
	UserProfilService US;

	@EJB
	AffectationService AF;

	@EJB
	PackService PS;
	
	@EJB
	CompetitionService CS;




	private List<Offer> offers;

	private List<AffectationOffre> myoffers;

	private List<Pack> packs;
	
	private List<Competition> competitions;





	public List<Offer> getoffers() { 


		offers = OF.getOffer();

		return offers;


	}


	public List<Pack> getpacks() { 

		packs = PS.getPack();

		return packs;


	}

	public List<Competition> getcompetitions() { 

       competitions = CS.getComp();

		return competitions;


	}
	public List<AffectationOffre> getuserOffers() { 

		myoffers = AF.GetMyOffers("san");

		UserProfil user=US.getUserById("san");

		name=user.getName();
		lastName=user.getLastName();
		mysolde=user.getSolde();
		return myoffers; 
	}


	public String getname(Offer off)

	{
		return OF.getofferName(off);
	}


	public void addOffer() {

		Offer offer= new Offer(offerDesc,offerName,offerprice);
		offer.setOfferType(2);
		offer.setCountAff(5);
		OF.ajouterOffer(offer);


	}

	public String activate(int id) {


		//get offer 
		Offer offer= OF.getOfferById(id);
		AffectationOffre aff= new AffectationOffre();
		//get user
		UserProfil user=US.getUserById("san");





		//check if credit is enough
		if (user.getSolde() >= offer.getOfferprice())
		{
			aff.setUserProfilId(user.getUserProfilId());
			aff.setOffer(offer);
			aff.setNumTel(numTel);
			aff.setDelai(delai);
			//increment offerAff

			int count = offer.getCountAff() + 1;
			offer.setCountAff(count);


			//calcul solde after 
			float solde=(float) (user.getSolde()-(delai * offer.getOfferprice()));

			//modifier user
			user.setSolde(solde);
			user.setSolde(solde);
			US.updateUser(user);


			//modifier offer
			OF.updateOffer(offer);

			//affecter
			AF.affecter(aff);




			//send mail

			try{
				String host ="smtp.gmail.com" ;
				String userr = "sandra.boughanmi@esprit.tn";
				String pass = "sa14763777";
				String to = user.getUserMail();
				String from = "sandra.boughanmi@esprit.tn";
				String subject = "Offer activiation";
				String messageText =  "Your "+offer.getOfferName()+" offer has been activated";
				boolean sessionDebug = false;

				Properties props = System.getProperties();

				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
				transport.connect(host, userr, pass);
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("message send successfully");
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			return "index?faces-redirect=true";


		}

		else {

			try{
				String host ="smtp.gmail.com" ;
				String userr = "sandra.boughanmi@esprit.tn";
				String pass = "sa14763777";
				String to = user.getUserMail();
				String from = "sandra.boughanmi@esprit.tn";
				String subject = "insufficient credit";
				String messageText =  "insufficient credit";
				boolean sessionDebug = false;

				Properties props = System.getProperties();

				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
				transport.connect(host, userr, pass);
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("message send successfully");
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			return "index?faces-redirect=true";


		}


	}


	public String sendmail()
	{

		UserProfil user = US.getUserById("san");
		try{
			String host ="smtp.gmail.com" ;
			String userr = "sandra.boughanmi@esprit.tn";
			String pass = "sa14763777";
			String to = user.getUserMail();
			String from = "sandra.boughanmi@esprit.tn";
			String subject = "Offer activiation";
			String messageText =  "Your offer has been activated";
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
			transport.connect(host, userr, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

		return "index?faces-redirect=true";

	} 


	public String desactiver(int id)

	{

		AffectationOffre p = AF.getaffById(id);
		UserProfil userr = US.getUserById(p.getUserProfilId());
		//  System.out.println(userr.getName());
		//  AF.deleteAf(id);
		//  return "myOffers?faces-redirect=true";

		Offer offer = p.getOffer();
		if (p.getDelai() <= 2)
		{

			float Newsolde=(float) (userr.getSolde() + (offer.getOfferprice() * p.getDelai() * 20 / 100));     	
			userr.setSolde(Newsolde);
			US.updateUser(userr);
			AF.deleteAf(id);


			try{
				String host ="smtp.gmail.com" ;
				String user = "sandra.boughanmi@esprit.tn";
				String pass = "sa14763777";
				String to = userr.getUserMail();
				String from = "sandra.boughanmi@esprit.tn";
				String subject = "Offer desactiviation";
				String messageText =  "Dear  "+userr.getName()+" Your " + offer.getOfferName() + " offer has been deactivated, you have been reimbursed by 20 of the total price";
				boolean sessionDebug = false;

				Properties props = System.getProperties();

				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
				transport.connect(host, user, pass);
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("message send successfully");
			}catch(Exception ex)
			{
				System.out.println(ex);
			}

			return "myOffers?faces-redirect=true";

		}
		else

		{  

			AF.deleteAf(id);


			try{
				String host ="smtp.gmail.com" ;
				String user = "sandra.boughanmi@esprit.tn";
				String pass = "sa14763777";
				String to = userr.getUserMail();
				String from = "sandra.boughanmi@esprit.tn";
				String subject = "Offer desactiviation";
				String messageText =  "Dear  "+userr.getName()+" Your " + offer.getOfferName() +  " offer has been desactivated";
				boolean sessionDebug = false;

				Properties props = System.getProperties();

				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
				transport.connect(host, user, pass);
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("message send successfully");
			}catch(Exception ex)
			{
				System.out.println(ex);
			}



			return "myOffers?faces-redirect=true";
		}






	}


	public void offerMax() {

		Offer off=OF.getOfferMax();
		maxoffImage=off.getImageOffer();
		maxoffname=off.getOfferName();
		Pack pa=PS.getPackMax();
		maximagePA=pa.getPackImage();
		maxnamePA=pa.getPackName();
		
		Offer min=OF.getOfferMin();

		float newprice= (float) (min.getOfferprice()-(min.getOfferprice()*40/100));
		min.setOfferprice(newprice); 
		System.out.println(min.getOfferName());
		System.out.println("oui");
		OF.updateOfferPrix(min);

	}



	public void offerMin() {

		Offer min=OF.getOfferMin();

		float newprice= (float) (min.getOfferprice()-(min.getOfferprice()*40/100));
		min.setOfferprice(0); 
		System.out.println(min.getOfferName());
		System.out.println("oui");

		OF.updateOffer(min);	

	}



	public String getOfferDetail(int id) { 

		Offer off = OF.getOfferById(id);



		nameOF=off.getOfferName();
		desOF=off.getOfferDesc();
		price=off.getOfferprice();
		imageOF=off.getImageOffer();
		return "offerDetails?faces-redirect=true";

	}


	public String getPackDetail(int id) { 

		Pack pa =PS.getPackById(id);



		namePa=pa.getPackName();
		descPa=pa.getPackDesc();
		pricePa=pa.getPackPrice();
		imagePa=pa.getPackImage();		
		offerPa=OF.getofferName(pa.getOffer());
		idPa=pa.getPackId();
		
		
		
		return "packDetails?faces-redirect=true";

	}

	
	
	public String favourite(int id)
	{
		
		Favori fv=new Favori();
		Pack pa=PS.getPackById(id);
		fv.setUserProfilId("san");
		fv.setPackId(id);
		
		
		int count = pa.getCountP()+ 1;
		pa.setCountP(count);	
		PS.updatePack(pa);
		PS.Favoris(fv);
		return "packDetails?faces-redirect=true";
	
		
		
		
	}
	
	public String getOffername(Offer off)
	
	
	{
		
        return OF.getofferName(off);	
		
	}
	
public String getOffernameByid(int id)
	
	
	{
		
        return OF.getofferNamebyid(id);
		
	}
	
	
	
	
public void addCompetition() {

		Competition c= new Competition();
	
		
		
		c.setCompetitionName(competitionName);
		c.setCompetitionDesc(competitionDesc);
		competitionImage="11.png";
		Offer off=OF.getOfferByName(role.name());
		
		c.setOfferId(off.getOfferId());
		
		c.setSolde(soldeC);
		
		//c.getProductId()
		
		
		
		c.setProductId(5);
		c.setImageCompetition(competitionImage);
		
		 CS.ajouterCompetition(c);
		 
		 
	//	OF.ajouterOffer(offer);


	}
	
	
/*public String uploadimage(String folderName1) throws IOException {
		
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
	
*/
	
	
	
}
