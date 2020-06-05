package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Entity.Project;
import Entity.Volunteer;
import Entity.apply_project;

public class ApplyDao {
	//创建新申请表
	public void createApply(Connection con,apply_project apply) throws SQLException {
		String sql="insert into apply_project(v_id,pro_id,apply_state,registration_info,registration_state) values(?,?,?,?,?) ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,apply.getVid());
		pstmt.setString(2,apply.getPid());
		pstmt.setString(3,"1");
		pstmt.setString(4,apply.getRinfo());
		pstmt.setString(5,"1");
		
		boolean t;
		if(pstmt.executeUpdate()>0) {
			t=true;
		}		
		
	}
	
	//查询申请状态
	public String getState(Connection con,String v_id,String pro_id) throws SQLException {
			
		String stateStr="";
		int state;
			
		String sql="select apply_state from apply_project where v_id=? and pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, v_id);
		pstmt.setString(1, pro_id);
		ResultSet rs=pstmt.executeQuery();
			
		stateStr = rs.getString("apply_state");	
		state = Integer.parseInt(stateStr);

		if(state==1) {
			stateStr= "申请待审核";
		}
		else if(state==2) {
			stateStr= "申请已通过";
		}
		
		return stateStr;
	}
	
	//显示某个申请表的信息
	public apply_project showApplyDetails(Connection con,String v_id,String pro_id) throws SQLException {
		
		String sql = "select * from apply_project where v_id = ? and pro_id = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,v_id);
		pstmt.setString(1,pro_id);
		apply_project applyShow=null ;
		ResultSet rs = pstmt.executeQuery();
		
		String vid = rs.getString("v_id");
		String pid = rs.getString("pro_id");
		String registration_info = rs.getString("registration_info");
			
		applyShow = new apply_project(vid,pid,registration_info);
		
		return applyShow;
	}	
	
	//显示申请列表
	public ArrayList<apply_project> showApply(Connection con,String pub_id) throws SQLException {
		ArrayList<apply_project> applyArrayList = new ArrayList<apply_project>();
		
		String sql1 = "select * from pub_project where pub_id = ?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1,pub_id);
		ResultSet rs1 = pstmt1.executeQuery();
		
		while(rs1.next()){ 
			String pro_id = rs1.getString("pro_id");
		    String sql = "select * from apply_project where pro_id = ?";
		    PreparedStatement pstmt=con.prepareStatement(sql);
		    pstmt.setString(1,pro_id);
		    apply_project applyShow=null ;
		    ResultSet rs = pstmt.executeQuery();
		
		    while(rs.next()){ 
		        String vid = rs.getString("v_id");
		        String pid = rs.getString("pro_id");
		        applyShow = new apply_project(vid,pid);
		        }
			
		    applyArrayList.add(applyShow);
		}
		
		return applyArrayList;
	}	
	
	//显示某一项目中报名志愿者的列表
	public ArrayList<Volunteer> showVolunteer(Connection con,String pro_id) throws SQLException {
		ArrayList<Volunteer> volunteerArrayList = new ArrayList<Volunteer>();
		
		String sql1 = "select * from apply_project where pro_id = ?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1,pro_id);
		ResultSet rs1 = pstmt1.executeQuery();
		
		while(rs1.next()){ 
			String v_id = rs1.getString("v_id");
		    String sql = "select * from volunteer where v_id = ?";
		    PreparedStatement pstmt=con.prepareStatement(sql);
		    pstmt.setString(1,v_id);
		    Volunteer volunteerShow=null ;
		    ResultSet rs = pstmt.executeQuery();
		
		    String vid = rs.getString("v_id");
		    String v_name = rs.getString("v_name");
		    int v_id_number = rs.getInt("v_id_number");
		    int v_credit = rs.getInt("v_credit");
		    
		    volunteerShow = new Volunteer(vid,v_name,v_id_number,v_credit);
		    volunteerArrayList.add(volunteerShow);
		 }
			
		
		return volunteerArrayList;
	}	

}
