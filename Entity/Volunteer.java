 package Entity;

public class Volunteer {
	private String v_id;
	private String v_name;	
	private String v_paw;
	private int v_contact;
	private int v_id_number;  
	private int v_credit;
	
	// 无参数的构造器
	public Volunteer() {
		super();
		}

	public Volunteer(String v_id,String v_name,String v_paw,int v_contact,int v_id_number,int v_credit) {
		this.v_id=v_id;
		this.v_name = v_name;
		this.v_paw = v_paw;
		this.v_contact=v_contact;
		this.v_id_number=v_id_number;
		this.v_credit=v_credit;
	}
	
	public Volunteer(String v_id,String v_name,int v_contact,int v_id_number) {
		this.v_id=v_id;
		this.v_name = v_name;
		this.v_contact=v_contact;
		this.v_id_number=v_id_number;
	}
	
	public String getID() {
		return v_id;
	}
	
	public String getName() {
		return v_name;
	}
	public String getPaw() {
		return v_paw;  
	}
	public int getContact() {
		return v_contact;
	}
	public int getIDnum() {
		return v_id_number;
	}
	public int getCredit() {
		return v_credit;
	}
	
	public void setID(String v_id) {
		this.v_id = v_id;
	}
		
	public void setName(String v_name) {
		this.v_name = v_name;
	}
	
	public void setPaw(String v_paw) {
		this.v_paw = v_paw;
	}
	public void setContact(int v_contact) {
		this.v_contact=v_contact;
	}
	public void setIDnum(int v_id_number) {
		this.v_id_number=v_id_number;
	}
	public void setCredit(int v_credit) {
		this.v_credit = v_credit;
	}
}
