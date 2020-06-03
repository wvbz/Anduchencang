package Entity;

public class admin {
	private String userName;
	private String password;
	private String email;

	// 无参数的构造器
	public admin() {
		super();
		}

	public admin(String userName,String password,String email) {
		this.userName=userName;
		this.password = password;
		this.email = email;
		
	}
	
	
	public String getPasswor() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
