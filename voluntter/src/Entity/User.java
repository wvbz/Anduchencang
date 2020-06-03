package Entity;

public class User {
	private String userName;
	private String password;
	private String email;
	private int credit;
	
	// 无参数的构造器
	public User() {
		super();
		}

	public User(String userName,String password,String email,int credit) {
		this.userName=userName;
		this.password = password;
		this.email = email;
		this.credit=credit;
	}
	public User(String userName,String password) {
		this.userName=userName;
		this.password = password;
		
	}
	
	
	public String getPasswor() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	public int getCredit() {
		return credit;
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
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
