package Entity;
import java.util.Date;

public class Project {
	public String pro_id;
	public String pro_name;
	public String pro_intro;
	public int pro_state;
	public Date pro_stime;
	public Date pro_etime;
	public String type;
	public String place;
	public int v_num;

	// 无参数的构造器
	

	public Project(String pro_id,String pro_name, String pro_intro,int pro_state,Date pro_stime,Date pro_etime,String type,String place,int v_num) {
		this.place=place;
		this.pro_etime=pro_etime;
		this.pro_id=pro_id;
		this.pro_intro=pro_intro;
		this.pro_name=pro_name;
		this.pro_state=pro_state;
		this.pro_stime=pro_stime;
		this.type=type;
		this.v_num=v_num;
	}
}
