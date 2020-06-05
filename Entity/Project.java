package Entity;

import java.util.Date;

public class Project {
	private String pro_id;
	private String pro_name;
	private String pro_intro;
	private String pro_info;
	private String state;
	private Date pro_s_time;
	private Date pro_e_time;
	private String pro_type;
	private String pro_place;
	private int v_num;
	
	
	// 无参数的构造器
	public Project() {
		super();
		}

	public Project(String pro_id,String pro_name,String pro_intro,String pro_info,String state,Date pro_s_time,Date pro_e_time,String pro_type,String pro_place,int v_num) {
		this.pro_id=pro_id;
		this.pro_name = pro_name;
		this.pro_intro = pro_intro;
		this.pro_info=pro_info;
		this.state=state;
		this.pro_s_time=pro_s_time;
		this.pro_e_time=pro_e_time;
		this.pro_type=pro_type;
		this.pro_place=pro_place;
		this.v_num=v_num;
	}
	
	public Project(String pro_id,String pro_name,String pro_intro,String pro_info,Date pro_s_time,Date pro_e_time,String pro_type,String pro_place) {
		this.pro_id=pro_id;
		this.pro_name = pro_name;
		this.pro_intro = pro_intro;
		this.pro_info=pro_info;
		this.pro_s_time=pro_s_time;
		this.pro_e_time=pro_e_time;
		this.pro_type=pro_type;
		this.pro_place=pro_place;
	}
	
	
	public String getId() {
		return pro_id;
	}
	public String getName() {
		return pro_name;
	}
	public String getIntro() {
		return pro_intro;
	}
	public String getInfo() {
		return pro_info;
	}
	public String getState() {
		return state;
	}
	public java.sql.Date getStime() {
		java.sql.Date pro_s_time = new java.sql.Date(this.pro_s_time.getTime());
		return pro_s_time;
	}
	public java.sql.Date getEtime() {
		java.sql.Date pro_e_time = new java.sql.Date(this.pro_e_time.getTime());
		return pro_e_time;
	}
	public String getType() {
		return pro_type;
	}
	public String getPlace() {
		return pro_place;
	}
	public int getVnum() {
		return v_num;
	}
	
	public void setID(String pro_id) {
		this.pro_id = pro_id;
	}
	public void setName(String pro_name) {
		this.pro_name = pro_name;
	}
	public void setIntro(String pro_intro) {
		this.pro_intro = pro_intro;
	}
	public void setInfo(String info) {
		this.pro_info = pro_info;
	}
	public void setState(String state) {
		this.state=state;
	}
	public void setStime(Date pro_s_time) {
		this.pro_s_time=pro_s_time;
	}
	public void setEtime(Date pro_e_time) {
		this.pro_e_time=pro_e_time;
	}
	public void setType(String pro_type) {
		this.pro_type=pro_type;
	}
	public void setPlace(String pro_place) {
		this.pro_place=pro_place;
	}
	public void setVnum(int v_num) {
		this.v_num=v_num;
	}

}
