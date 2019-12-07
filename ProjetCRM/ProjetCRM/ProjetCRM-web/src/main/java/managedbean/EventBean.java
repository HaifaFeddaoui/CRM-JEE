package managedbean;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import model.Event;
import model.Participation;
import model.UserProfil;
import service.EventService;
import service.ParticipationService;
import service.UserProfilService;
import utils.Util;

/**
 * Session Bean implementation class EventBean
 */
@ManagedBean(name="ebean")
@SessionScoped

public class EventBean implements Serializable {

	/**
	 * Default constructor. 
	 */
	private static final long serialVersionUID = 1L;
	private String etat;
	private String eventDateD;
	private String eventDateF;
	private String eventDesc;
	private String eventImage;
	private String eventName;
	private float eventprix;
	private String lieu;
	private int nbreplace;
	private String toMail;
	private float solde;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public float getEventprix() {
		return eventprix;
	}
	public void setEventprix(float eventprix) {
		this.eventprix = eventprix;
	}
	public List<Participation> getPart() {
		return part;
	}
	public void setPart(List<Participation> part) {
		this.part = part;
	}
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	private Part file;
	private List<Event> events;
	private List<Event> event;
	private List<UserProfil> userp;
	public List<UserProfil> getUserp() {
		return userp;
	}
	public void setUserp(List<UserProfil> userp) {
		this.userp = userp;
	}
	private List<Participation> part;
	@EJB
	EventService eventService;
	@EJB 
	UserProfilService UPS;
	@EJB
	ParticipationService PS;

	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public EventBean() {
	}
	public List<Event> getEvent() {
		return event;
	}
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getEventDateD() {
		return eventDateD;
	}
	public void setEventDateD(String eventDateD) {
		this.eventDateD = eventDateD;
	}
	public String getEventDateF() {
		return eventDateF;
	}
	public void setEventDateF(String eventDateF) {
		this.eventDateF = eventDateF;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getNbreplace() {
		return nbreplace;
	}
	public void setNbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}


	public EventBean(String etat, String eventDateD, String eventDateF, String eventDesc, String eventImage,
			String eventName, String lieu, int nbreplace, List<Event> events,String toMail ,List<Event> event,float eventprix) {
		super();
		this.etat = etat;
		this.eventDateD = eventDateD;
		this.eventDateF = eventDateF;
		this.eventDesc = eventDesc;
		this.eventImage = eventImage;
		this.eventName = eventName;
		this.lieu = lieu;
		this.nbreplace = nbreplace;
		this.events=events;
		this.event=event;
		this.toMail=toMail;
		this.eventprix=eventprix;
	}
	public void addEvent() throws IOException {

		eventService.ajouterEvent(new Event(eventprix, eventDateD, eventDateF, eventDesc, file.getSubmittedFileName(),
				eventName,lieu,nbreplace)); 
		String folderName1 = Util.serverI;
		uploadimage(folderName1);
	}



	public List<Event> getEvents() {
		events = eventService.getAllEvents();
		return events;
	}
	public void removeEvent(int eventId)
	{
		eventService.deleteEventById(eventId);
	}
	private int eventIdToBeUpdated;
	public void displayEvent(Event event)
	{
		this.setEventName(event.getEventName());
		this.setEventImage(event.getEventImage());
		this.setEventDateD(event.getEventDateD());
		this.setEventDateF(event.getEventDateF());
		this.setEventDesc(event.getEventDesc());
		this.setLieu(event.getLieu());
		this.setNbreplace(event.getNbreplace());
		this.setEventprix(event.getEventprix());
	}

	public void updateEvent()
	{ 
		eventService.updateEvent(new Event(eventIdToBeUpdated,eventImage,eventprix, eventDateD, eventDateF, eventDesc,lieu,nbreplace));
	}
	
	
	public String uploadimage(String folderName1) throws IOException {

		if (file != null) {

			InputStream in = file.getInputStream();
			File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			return "succes-image-uplaod?faces-redirect=true";
		}
		else {
			return "succes-image-uplaod?faces-redirect=true";	
		}	
	}
	public void participerEvent(int id)
	{
		Event event = eventService.getEventById(id);
		Participation part = new Participation();
		UserProfil user = UPS.getUserById("haifa");
		//part.setUser(user.getUserProfilId());
		part.setUser(user);
		//float prix= event.getEventprix();
		if(event.getNbreplace()== 0)
		{
			event.setEtat("complet");
			eventService.updateEvent(event);
			part.setEvent(event);
			try{
				String host ="smtp.gmail.com" ;
				String users = "haifafeddaoui96@gmail.com";
				String pass = "haifa27356205";
				String to = "haifafeddaoui03@gmail.com";
				String from = "haifafeddaoui96@gmail.com";
				String subject = "Confirmation de Reservation";
				String messageText = "Madame/Monsieur,\n" +
						"\n" +
						" Nous vous informons que cet événement est déja complet  "+
						"\n En vous remerciant par avance, nous vous adressons, nos salutations distinguées, ";
				boolean sessionDebug = false;

				Properties props = System.getProperties();
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.required", "true");

				//java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
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
		else
		{
		  if(event.getEventprix()==0)
				{
				
					int count = event.getNbreplace() - 1;
					event.setNbreplace(count);
					float nvsolde= (float)(user.getSolde() + 1000);
					user.setSolde(nvsolde);	
					part.setEvent(event);
					part.setUser(user);
					//System.out.println(event.getNbreplace());
					PS.participer(part);  
				}
		  else
		  {
			  int count = event.getNbreplace() - 1;
				event.setNbreplace(count);
				float nvsolde= (float)(user.getSolde()-event.getEventprix());
				user.setSolde(nvsolde);	
				part.setEvent(event);
				part.setUser(user);
				//System.out.println(event.getNbreplace());
				PS.participer(part);  
		  }
				
			
			
		
		}
		eventService.updateEvent(event);
		UPS.updateUser(user);




	}

	public List<Event> getEventMax() {
		events = eventService.getEvent();
		return events;
		
		
	}
	public List<UserProfil> getUser() {
		userp = UPS.getUser();
		return userp;
		}
	
	private String fromMail;
	private String subject;
	private String message;

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
	
	






}
