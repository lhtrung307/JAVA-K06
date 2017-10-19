package model;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class UserMail {
	public String to;
	public String cc;
	public String bcc;
	public String subject;
	public String content;
	public String filePath;
	public Message msg;
	
	
	
	public UserMail(String to, String cc, String bcc, String subject, String content, String filePath) {
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.content = content;
		this.filePath = filePath;
	}

	public boolean sendMail(Session session, String username) {
		try {
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setSubject(subject);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			setCCRecipents();
			setBCCRecipents();
			msg.getSentDate();
			BodyPart messagePart = new MimeBodyPart();
			messagePart.setText(content);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagePart);

			BodyPart attachmentPart = new MimeBodyPart();
			putFileToAttachmentPart(attachmentPart, filePath);
			multipart.addBodyPart(attachmentPart);
			msg.setContent(multipart);
			sendMessage(session);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void setCCRecipents() throws AddressException, MessagingException {
		if (cc != null) {
			msg.setRecipients(Message.RecipientType.CC, getListRecipients(cc));
		}
	}

	private void setBCCRecipents() throws AddressException, MessagingException {
		if (bcc != null) {
			msg.setRecipients(Message.RecipientType.BCC, getListRecipients(bcc));
		}
	}

	private InternetAddress[] getListRecipients(String recipients) throws AddressException {
		return InternetAddress.parse(recipients);
	}

	private String getFileName() {
		return filePath.substring(filePath.lastIndexOf("\\"));
	}

	private void putFileToAttachmentPart(BodyPart attachmentPart, String filePath) throws MessagingException {
		DataSource sourceFile = new FileDataSource(filePath);
		attachmentPart.setDataHandler(new DataHandler(sourceFile));
		attachmentPart.setFileName(getFileName());
	}

	public void sendMessage(Session session) throws MessagingException {
		Transport transport = session.getTransport();
		transport.connect();
		transport.send(msg);
	}
}
