package Entity;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	
	private String user=null;
	private String password=null;
	
	public MyAuthenticator() {
		
	}
	
	public MyAuthenticator(String user,String password) {
		this.user = user;
		this.password = password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user,password);
	}
}
