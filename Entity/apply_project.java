package Entity;

public class apply_project {
	private String v_id;
	private String pro_id;
	private String apply_state;
	private String registration_info;
	
	// 无参数的构造器
	public apply_project() {
		super();
		}

	public apply_project(String v_id,String pro_id,String apply_state,String registration_info) {
		this.v_id=v_id;
		this.pro_id = pro_id;
		this.apply_state = apply_state;
		this.registration_info=registration_info;
	}
	
	public apply_project(String v_id,String pro_id,String registration_info) {
		this.v_id=v_id;
		this.pro_id = pro_id;
		this.registration_info=registration_info;
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
	
}
