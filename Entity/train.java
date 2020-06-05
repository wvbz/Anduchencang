package Entity;

import java.sql.Date;

public class train {
	
	private String pro_id;
	private String t_content;
	private java.util.Date t_s_time;
	private java.util.Date t_e_time;
	
	// 无参数的构造器
	public train() {
		super();
		}

	public train(String pro_id,String t_content,java.util.Date t_s_time,java.util.Date t_e_time) {
		this.pro_id = pro_id;
		this.t_content = t_content;
		this.t_s_time = t_s_time;
		this.t_e_time = t_e_time;
	}
	
	
	public String getPro_id() {
		return pro_id;
	}
	
	public String getT_content() {
		return t_content;
	}
	
	public Date getT_s_time() {
		java.sql.Date t_s_time=new java.sql.Date(this.t_s_time.getTime());
		return t_s_time;
	}
	
	public Date getT_e_time() {
		java.sql.Date t_e_time=new java.sql.Date(this.t_e_time.getTime());
		return t_e_time;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	
	public void setT_s_time(java.util.Date t_s_time) {
		this.t_s_time = t_s_time;
	}
	
	public void setT_e_time(java.util.Date t_e_time) {
		this.t_e_time = t_e_time;
	}
	
}
