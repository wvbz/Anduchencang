package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entity.train;
import Entity.training;

public class TrainDao {
	//创建新培训
	public void createTrain(Connection con,train train,training training) throws SQLException {
		//插入一个新的培训
		String sql1="insert into train(pro_id,t_content,t_s_time,t_e_time) values(?,?,?,?) ";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, train.getPro_id());
		pstmt1.setString(2, train.getT_content());
		pstmt1.setDate(3, train.getT_s_time());
		pstmt1.setDate(4, train.getT_e_time());
		boolean t1;
		if(pstmt1.executeUpdate()>0) {
			t1=true;
		}
		
		//培训状态
		String sql2="insert into training(pro_id,t_state) values(?,?) ";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1,training.getPro_id());
		pstmt2.setString(2, "1");
		boolean t2;
		if(pstmt2.executeUpdate()>0) {
			t2=true;
		}
	}
	
	//查询培训状态
	public String getState(Connection con,String pro_id) throws SQLException {
		
		String stateStr="";
		int state;
		
		String sql="select t_state from training where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pro_id);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			stateStr = rs.getString("t_state");
		}
		
		state = Integer.parseInt(stateStr);

		if(state==1) {
			stateStr= "培训已发布";
		}
		else if(state==2) {
			stateStr= "培训进行中";
		}
		else if(state==3) {
			stateStr= "培训已结束";
		}
		else if(state==0) {
			stateStr= "尚未发布培训";
		}
		return stateStr;
	}
	
	//查询某个培训的信息
	public train showTrain(Connection con,String pro_id) throws SQLException {
		
		String sql = "select * from train where pro_id = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pro_id);

		train checkShow=null ;
		ResultSet rs = pstmt.executeQuery();
		
		String id = rs.getString("pro_id");
		String t_content = rs.getString("t_content");
		Date t_s_time = rs.getDate("t_s_time");
		Date t_e_time = rs.getDate("t_e_time");
			
		checkShow = new train(id,t_content,t_s_time,t_e_time);
		
		return checkShow;
	}	
	
	
	//显示训练内容
	public String showContent(Connection con,String pro_id) throws SQLException {
		
		String sql = "select t_content from train where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pro_id);
		ResultSet rs = pstmt.executeQuery();
		
		String t_content = rs.getString("t_content");
		return t_content;
	}
	
	//显示训练开始时间
	public Date showStime(Connection con,String pro_id) throws SQLException {
			
		String sql = "select t_s_time from train where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pro_id);
		ResultSet rs = pstmt.executeQuery();
			
		Date t_s_time = rs.getDate("t_s_time");
		return t_s_time;
	}
		
	
	//显示训练结束时间
	public Date showEtime(Connection con,String pro_id) throws SQLException {
			
		String sql = "select t_e_time from train where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pro_id);
		ResultSet rs = pstmt.executeQuery();
			
		Date t_e_time = rs.getDate("t_e_time");
		return t_e_time;
	}
	
	//培训开始进行
	public void startProject(Connection con,String pro_id) throws SQLException {
		String sql="update training set t_state='2' where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pro_id);
		boolean t;
		if(pstmt.executeUpdate()>0) {
			t=true;
		}

	}
	
	//培训结束
	public void endProject(Connection con,String pro_id) throws SQLException {
		String sql="update training set t_state='3' where pro_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pro_id);
		boolean t;
		if(pstmt.executeUpdate()>0) {
			t=true;
		}

	}	
	
	
}
