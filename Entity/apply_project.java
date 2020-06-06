package Entity;

public class apply_project {
	private String v_id;
	private String pro_id;
	private String apply_state;
	private String registration_info;
	private String name;
	private String idnumber;
	private String phonenumber;
	private String career;
	
	// 无参数的构造器
	public apply_project() {
		super();
		}

	public apply_project(String v_id,String pro_id,String apply_state,String registration_info,String name,String idnumber,String phonenumber,String career) {
		this.v_id=v_id;
		this.pro_id = pro_id;
		this.apply_state = apply_state;
		this.registration_info=registration_info;
		this.name=name;
		this.idnumber=idnumber;
		this.phonenumber=phonenumber;
		this.career=career;
	}
	
	public apply_project(String name,String idnumber,String phonenumber,String career,String registration_info) {
		this.name=name;
		this.idnumber=idnumber;
		this.phonenumber=phonenumber;
		this.career=career;
		this.registration_info=registration_info;
	}
	
	public apply_project(String name,String idnumber,String phonenumber,String career) {
		this.name=name;
		this.idnumber=idnumber;
		this.phonenumber=phonenumber;
		this.career=career;
	}
	
	public apply_project(String v_id,String pro_id) {
		this.v_id=v_id;
		this.pro_id = pro_id;
	}
	
	
	public String getVid() {
		return v_id;
	}
	public String getPid() {
		return pro_id;
	}
	public String getAstate() {
		return apply_state;  
	}
	public String getRinfo() {
		return registration_info;  
	}
	public String getName() {
		return name;
	}
	public String getIDnum() {
		return idnumber;
	}
	public String getPhonenum() {
		return phonenumber;  
	}
	public String getCareer() {
		return career;  
	}
	
	public void setVid(String v_id) {
		this.v_id = v_id;
	}
	public void setPid(String pro_id) {
		this.pro_id = pro_id;
	}
	public void setAstate(String apply_state) {
		this.apply_state = apply_state;
	}
	public void setRinfo(String registration_info) {
		this.registration_info=registration_info;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setIDnum(String idnumber) {
		this.idnumber=idnumber;
	}
	public void setPhonenum(String phonenumber) {
		this.phonenumber=phonenumber;
	}
	public void setCareer(String career) {
		this.career=career;
	}
	
	
}
