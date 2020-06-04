package Entity;

public class Publisher {
	private String userName;
	private String password;
	private String email;
	private int credit;
	private int state;
	
	// 无参数的构造器
	public Publisher() {
		super();
		}

	public Publisher(String userName,String password,String email,int credit,int state) {
		this.userName=userName;
		this.password = password;
		this.email = email;
		this.credit=credit;
		this.state=state;
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
	public int getState() {
		return state;
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
	public void setState(int state) {
		this.state=state;
	}
}
