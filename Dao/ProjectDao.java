package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entity.Project;
import Entity.Publisher;
import Entity.train;

public class ProjectDao {
	    //创建新项目
		public void createProject(Connection con,Project project,String pub_id) throws SQLException {
			//插入一个新的项目
			String sql1="insert into project(pro_name,pro_intro,pro_info,state,pro_s_time,pro_e_time,pro_type,pro_place,v_num) values(?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, project.getName());
			pstmt1.setString(2, project.getIntro());
			pstmt1.setString(3, project.getInfo());
			pstmt1.setString(4, "1");
			pstmt1.setDate(5, project.getStime());
			pstmt1.setDate(6, project.getEtime());
			pstmt1.setString(7, project.getType());
			pstmt1.setString(8, project.getPlace());
			pstmt1.setInt(9, project.getVnum());
		
			boolean t1;
			if(pstmt1.executeUpdate()>0) {
				t1=true;
			}
			
			String sql2="insert into pub_project(pub_id,pro_id,audit_state) values(?,?,?) ";
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			pstmt2.setString(1,pub_id);
			pstmt2.setString(2,project.getId());
			pstmt2.setString(3, "1");
			
			boolean t2;
			if(pstmt2.executeUpdate()>0) {
				t2=true;
			}
		}
			
		//查询项目状态
		public String getState(Connection con,String pro_id) throws SQLException {
				
			String stateStr="";
			int state;
				
			String sql="select pro_state from project where pro_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pro_id);
			ResultSet rs=pstmt.executeQuery();
				
			stateStr = rs.getString("pro_state");	
			state = Integer.parseInt(stateStr);

			if(state==1) {
				stateStr= "项目待审核";
			}
			else if(state==2) {
				stateStr= "项目已发布";
			}
			else if(state==3) {
				stateStr= "项目进行中";
			}
			else if(state==4) {
				stateStr= "项目已结束";
			}
			return stateStr;
		}
		
		//查询某个项目的信息
		public Project showProject(Connection con,String pro_id) throws SQLException {
			
			String sql = "select * from project where pro_id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,pro_id);
			Project checkShow=null ;
			ResultSet rs = pstmt.executeQuery();
			
			String id = rs.getString("pro_id");
			String pro_name = rs.getString("pro_name");
			String pro_intro = rs.getString("pro_intro");
			String pro_info = rs.getString("pro_info");
			String pro_state = rs.getString("pro_state");
			Date pro_s_time = rs.getDate("pro_s_time");
			Date pro_e_time = rs.getDate("pro_e_time");
			String pro_type = rs.getString("pro_type");
			String pro_place = rs.getString("pro_place");
			int v_num = rs.getInt("v_num");
				
			checkShow = new Project(id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,pro_type,pro_place,v_num);
			
			return checkShow;
		}	
		
		//根据类型查询项目
		public ArrayList<Project> typeSearch(Connection con,String pro_type) throws SQLException {
			ArrayList<Project> projectArrayList = new ArrayList<Project>();  
			String sql = "select * from project where pro_type=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pro_type);
			Project projectShow=null ;
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
			    String pro_id = rs.getString("pro_id");
			    String pro_name = rs.getString("pro_name");
			    String pro_intro = rs.getString("pro_intro");
			    String pro_info = rs.getString("pro_info");
			    String pro_state = rs.getString("pro_state");
			    Date pro_s_time = rs.getDate("pro_s_time");
			    Date pro_e_time = rs.getDate("pro_e_time");
			    String type = rs.getString("pro_type");
			    String pro_place = rs.getString("pro_place");
			    int v_num = rs.getInt("v_num");
				
			    projectShow = new Project(pro_id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,type,pro_place,v_num);
			    projectArrayList.add(projectShow);
			}
			
			return projectArrayList;
		}
		
		//根据地点查询项目
		public ArrayList<Project> placeSearch(Connection con,String pro_place) throws SQLException {
			ArrayList<Project> projectArrayList = new ArrayList<Project>();  
			String sql = "select * from project where pro_place=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pro_place);
			Project projectShow=null ;
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
			    String pro_id = rs.getString("pro_id");
			    String pro_name = rs.getString("pro_name");
			    String pro_intro = rs.getString("pro_intro");
			    String pro_info = rs.getString("pro_info");
			    String pro_state = rs.getString("pro_state");
			    Date pro_s_time = rs.getDate("pro_s_time");
			    Date pro_e_time = rs.getDate("pro_e_time");
			    String pro_type = rs.getString("pro_type");
			    String place = rs.getString("pro_place");
			    int v_num = rs.getInt("v_num");
				
			    projectShow = new Project(pro_id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,pro_type,place,v_num);
			    projectArrayList.add(projectShow);
			}
			
			return projectArrayList;
		}		
		

		
		//审核通过项目
		public void approveProject(Connection con,String pro_id) throws SQLException {
			String sql="update project set pro_state='2' where pro_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,pro_id);
			boolean t;
			if(pstmt.executeUpdate()>0) {
				t=true;
			}
			
			String sql1="update pub_project set audit_state='2' where pro_id=?";
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1,pro_id);
			boolean t1;
			if(pstmt1.executeUpdate()>0) {
				t1=true;
			}

		}
		
		
		//项目开始进行
		public void startProject(Connection con,String pro_id) throws SQLException {
			String sql="update project set pro_state='3' where pro_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,pro_id);
			boolean t;
			if(pstmt.executeUpdate()>0) {
				t=true;
			}

		}
		
		//结束项目
		public void endProject(Connection con,String pro_id) throws SQLException {
			String sql="update project set pro_state='4' where pro_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,pro_id);
			boolean t;
			if(pstmt.executeUpdate()>0) {
				t=true;
			}

		}
		
					
		
		//查询某发布者正在进行的项目
		public ArrayList<Project> showPdoing(Connection con,String pub_id) throws SQLException {
			ArrayList<Project> projectArrayList = new ArrayList<Project>();  
			String sql = "select * from pub_project where pub_id=? and audit_state='3'";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){ 
				
				String pro_id = rs.getString("pro_id");
				String sql1 = "select * from project where pro_id=?";
				PreparedStatement pstmt1=con.prepareStatement(sql1);
				ResultSet rs1 = pstmt.executeQuery();
				
				String id = rs1.getString("pro_id");
				String pro_name = rs1.getString("pro_name");
				String pro_intro = rs1.getString("pro_intro");
				String pro_info = rs1.getString("pro_info");
				String pro_state = rs1.getString("pro_state");
				Date pro_s_time = rs1.getDate("pro_s_time");
				Date pro_e_time = rs1.getDate("pro_e_time");
				String pro_type = rs1.getString("pro_type");
				String place = rs1.getString("pro_place");
				int v_num = rs1.getInt("v_num");
				
				Project project = new Project(pro_id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,pro_type,place,v_num);
				projectArrayList.add(project);
			}
			return projectArrayList;
		}
		
		//查询某发布者已结束的项目
		public ArrayList<Project> showPend(Connection con,String pub_id) throws SQLException {
			ArrayList<Project> projectArrayList = new ArrayList<Project>();  
			String sql = "select * from pub_project where pub_id=? and audit_state='4'";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){ 
				
				String pro_id = rs.getString("pro_id");
				String sql1 = "select * from project where pro_id=?";
				PreparedStatement pstmt1=con.prepareStatement(sql1);
				ResultSet rs1 = pstmt.executeQuery();
				
				String id = rs1.getString("pro_id");
				String pro_name = rs1.getString("pro_name");
				String pro_intro = rs1.getString("pro_intro");
				String pro_info = rs1.getString("pro_info");
				String pro_state = rs1.getString("pro_state");
				Date pro_s_time = rs1.getDate("pro_s_time");
				Date pro_e_time = rs1.getDate("pro_e_time");
				String pro_type = rs1.getString("pro_type");
				String place = rs1.getString("pro_place");
				int v_num = rs1.getInt("v_num");
				
				Project project = new Project(pro_id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,pro_type,place,v_num);
				projectArrayList.add(project);
			}
			return projectArrayList;
		}
		
		//显示待审核项目列表
		public ArrayList<Project> showDSpro(Connection con) throws SQLException {
			ArrayList<Project> projectArrayList = new ArrayList<Project>();
			
			String sql = "select * from project where pro_state='1'";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){ 
				String pro_id = rs.getString("pro_id");
				String pro_name = rs.getString("pro_name");
				String pro_intro = rs.getString("pro_intro");
				String pro_info = rs.getString("pro_info");
				Date pro_s_time = rs.getDate("pro_s_time");
				Date pro_e_time = rs.getDate("pro_e_time");
				String pro_type = rs.getString("pro_type");
				String pro_place = rs.getString("pro_place");
				
				Project project = new Project(pro_id,pro_name,pro_intro,pro_info,pro_s_time,pro_e_time,pro_type,pro_place);
				projectArrayList.add(project);
			}
			
			return projectArrayList;
		}	
		
}
