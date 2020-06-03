package Entity;
import java.util.Date;

public class train {
	public String pro_id;
	public String t_content;
	public Date t_stime;
	public Date t_etime;
	
	public train(String pro_id,String t_content,Date t_stime,Date t_etime) {
		this.pro_id=pro_id;
		this.t_content=t_content;
		this.t_etime=t_etime;
		this.t_stime=t_stime;
	}

}
