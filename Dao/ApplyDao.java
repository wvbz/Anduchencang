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
		String sql="insert into apply_project(v_id,pro_id,apply_state,registration_info,name,idnumber,phonenumber,career) values(?,?,?,?,?,?,?,?) ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,apply.getVid());
		pstmt.setString(2,apply.getPid());
		pstmt.setString(3,"1");
		pstmt.setString(4,apply.getRinfo());
		pstmt.setString(5,apply.getName());
		pstmt.setString(6,apply.getIDnum());
		pstmt.setString(7,apply.getPhonenum());
		pstmt.setString(8,apply.getCareer());
		
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
		
		String name = rs.getString("name");
		String idnumber = rs.getString("idnumber");
		String phonenumber = rs.getString("phonenumber");
		String career = rs.getString("career");
		String registration_info = rs.getString("registration_info");
			
		applyShow = new apply_project(name,idnumber,phonenumber,career,registration_info);
		
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
	
	//显示某一项目中已报名志愿者的列表
	public ArrayList<apply_project> showVolunteer(Connection con,String pro_id) throws SQLException {
		ArrayList<apply_project> volunteerArrayList = new ArrayList<apply_project>();
		
		String sql1 = "select * from apply_project where pro_id = ?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1,pro_id);
		ResultSet rs1 = pstmt1.executeQuery();
		
		while(rs1.next()){ 
		    String name = rs1.getString("name");
		    String idnumber = rs1.getString("idnumber");
		    String phonenumber = rs1.getString("phonenumber");
		    String career = rs1.getString("career");
		    
		    apply_project volunteerShow = new apply_project(name,idnumber,phonenumber,career);
		    volunteerArrayList.add(volunteerShow);
		 }
			
		
		return volunteerArrayList;
	}	
	
	//申请审核通过
	public void applyPass(Connection con,String v_id,String pro_id) throws SQLException {
		String sql="update apply_project set apply_state='2' where v_id=? and pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,v_id);
		pstmt.setString(2,pro_id);
		boolean t;
		if(pstmt.executeUpdate()>0) {
			t=true;
		}
		
		//通知志愿者
		String sql3="select * from project where pro_id=?";
		PreparedStatement pstmt3=con.prepareStatement(sql3);
		pstmt3.setString(1,pro_id);
		ResultSet rs3 = pstmt3.executeQuery();
		String pro_name=rs3.getString("pro_name");
		
		String sql2="insert into notice(id,content) values(?,?) ";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1,v_id);
		pstmt2.setString(2,"您报名的项目"+pro_name+"已通过申请");

	}

}
