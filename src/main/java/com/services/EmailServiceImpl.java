package com.services;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.SessionFactory;
public class EmailServiceImpl implements EmailService {
	
		private static final String senderEmail = "smitbhojani5555@gmail.com";// change with your sender email
		private static final String senderPassword = "9427836642";// change with your sender password

		private SessionFactory sessionFactory;

		public EmailServiceImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public void sendAshtml(String to, String title, String html) throws MessagingException {
			System.out.println("Sending email to " + to);

			Session session = createSession();

			// create message using session
			MimeMessage message = new MimeMessage(session);
			prepareEmailMessage(message, to, title, html);

			// sending message
			Transport.send(message);
			System.out.println("Done");
		}

		private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
				throws MessagingException {
			message.setContent(html, "text/html; charset=utf-8");
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(title);
		}

		private static Session createSession() {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");// Outgoing server requires authentication
			props.put("mail.smtp.starttls.enable", "true");// TLS must be activated
			props.put("mail.smtp.host", "smtp.gmail.com"); // Outgoing server (SMTP) - change it to your SMTP server
			props.put("mail.smtp.port", "587");// Outgoing port

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmail, senderPassword);
				}
			});
			return session;
		}

	}



