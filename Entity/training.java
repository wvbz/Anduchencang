package Entity;

import java.sql.Date;

public class training {
	private String v_id;
	private String pro_id;
	private String t_state;
	
	// 无参数的构造器
	public training() {
		super();
		}

	public training(String v_id,String pro_id,String t_state) {
		this.v_id = v_id;
		this.pro_id = pro_id;
		this.t_state = t_state;
	}
	
	public training(String v_id,String pro_id) {
		this.v_id = v_id;
		this.pro_id = pro_id;
	}
	
	public String getV_id() {
		return v_id; 
	}
	
	public String getPro_id() {
		return pro_id;
	}
	
	public String getT_state() {
		return t_state;
	}
	
	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	
	public void setT_state(String t_state) {
		this.t_state = t_state;
	}
	
}
