package managedbean;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender implements Serializable {
	private static final long serialVersionUID = 1L;
	public void sendMail(String toMail
			,String message) throws AddressException, MessagingException 
	{ 
		String users = "haifafeddaoui96@gmail.com";
		String pass = "haifa27356205";
		String from = "haifafeddaoui96@gmail.com";
		String subject = "Recommander un événement";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.fallback", "false");
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(true);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		msg.setSubject(subject);
		msg.setContent(message,"text/html");
		Transport transport=mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", users, pass);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		
		
	}

}
