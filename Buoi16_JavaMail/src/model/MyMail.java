package model;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class MyMail {
	public String serverMail;
	public int port;
	public String username;
	public String password;
	public String status;
	public Session session;

	public MyMail(String serverMail, int port, String username, String password) {
		this.serverMail = serverMail;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public String getServerMail() {
		return serverMail;
	}

	public void setServerMail(String serverMail) {
		this.serverMail = serverMail;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean login() {
		Properties properties = new Properties();
		putProperties(properties);
		session = createNewSession(properties);
		try {
			Transport transport = session.getTransport();
			transport.connect();
			return transport.isConnected();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void putProperties(Properties properties) {
		properties.put("mail.smtp.host", this.serverMail);
		properties.put("mail.smtp.port", this.port);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
	}

	private Session createNewSession(Properties properties) {
		return Session.getInstance(properties, getAuthenticator());
	}

	private Authenticator getAuthenticator() {
		return new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
	}

}
