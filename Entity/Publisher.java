package Entity;

public class Publisher {
	private String pub_id;
	private String pub_name;
	private String pub_psw;
	private int pub_contact;
	private int pub_id_number;
	private String pub_state;
	private int pub_credit;
	
	// 无参数的构造器
	public Publisher() {
		super();
		}

	public Publisher(String pub_id,String pub_name,String pub_psw,int pub_contact,int pub_id_number,String pub_state,int pub_credit) {
		this.pub_id=pub_id;
		this.pub_name = pub_name;
		this.pub_psw = pub_psw;
		this.pub_contact=pub_contact;
		this.pub_id_number=pub_id_number;
		this.pub_state=pub_state;
		this.pub_credit=pub_credit;
		
	}
	
	public Publisher(String pub_id,String pub_name,int pub_contact,int credit) {
		this.pub_id=pub_id;
		this.pub_name = pub_name;
		this.pub_contact=pub_contact;
		this.pub_credit=pub_credit;
	}
	
	public Publisher(String pub_id,String pub_name,int pub_id_number,int pub_contact,int credit) {
		this.pub_id=pub_id;
		this.pub_name = pub_name;
		this.pub_contact=pub_contact;
		this.pub_id_number=pub_id_number;
		this.pub_credit=pub_credit;
	}
	
	
	public String getID() {
		return pub_id;
	}
	
	public String getName() {
		return pub_name;
	}
	public String getPsw() {
		return pub_psw;
	}
	public int getContact() {
		return pub_contact;
	}
	public int getIDnum() {
		return pub_id_number;
	}
	public String getState() {
		return pub_state;
	}
	public int getCredit() {
		return pub_credit;
	}
	
	public void setID(String pub_id) {
		this.pub_id = pub_id;
	}
		
	public void setName(String pub_name) {
		this.pub_name = pub_name;
	}
	
	public void setPsw(String pub_psw) {
		this.pub_psw = pub_psw;
	}
	public void setContact(int pub_contact) {
		this.pub_contact = pub_contact;
	}
	public void setIDnum(int pub_id_number) {
		this.pub_id_number=pub_id_number;
	}
	public void setState(String pub_state) {
		this.pub_state=pub_state;
	}
	public void setCredit(int pub_credit) {
		this.pub_credit=pub_credit;
	}
}
