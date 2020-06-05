package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Entity.Publisher;
import Entity.apply_project;
import Entity.train;

public class PublisherDao {
    //注册新发布者
	public void createPublisher(Connection con,Publisher publisher) throws SQLException {
		//插入一个新的发布者
		String sql1="insert into publisher(pub_name,pub_psw,pub_contact,pub_id_number,pub_state,pub_credit) values(?,?,?,?,?,?) ";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, publisher.getName());
		pstmt1.setString(2, publisher.getPsw());
		pstmt1.setInt(3, publisher.getContact());
		pstmt1.setInt(4, publisher.getIDnum());
		pstmt1.setString(5,"1");
		pstmt1.setInt(6, publisher.getCredit());
	
		boolean t1;
		if(pstmt1.executeUpdate()>0) {
			t1=true;
		}
		
	}
	
	//查询发布者状态
	public String getState(Connection con,String pub_id) throws SQLException {
			
		int state;
		String stateStr ="";
			
		String sql="select pub_state from project where pub_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pub_id);
		ResultSet rs=pstmt.executeQuery();

		stateStr = rs.getString("pub_state");	
		state = Integer.parseInt(stateStr);

		if(state==1) {
			stateStr= "发布者待审核";
		}
		else if(state==2) {
			stateStr= "发布者已通过审核";
		}
		return stateStr;
	}	
	
	//查询某个发布者的信息
	public Publisher showPublisher(Connection con,String pub_id) throws SQLException {
		
		String sql = "select * from publisher where pub_id = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pub_id);

		Publisher checkShow=null ;
		ResultSet rs = pstmt.executeQuery();
		
		String id = rs.getString("pub_id");
		String pub_name = rs.getString("pub_name"); 
		int pub_contact = rs.getInt("pub_contact");
		int pub_credit = rs.getInt("pub_credit");
			
		checkShow = new Publisher(id,pub_name,pub_contact,pub_credit);
		
		return checkShow;
	}	
	
	//显示待审核发布者列表
	public ArrayList<Publisher> showDSpub(Connection con) throws SQLException {
		ArrayList<Publisher> publisherArrayList = new ArrayList<Publisher>();
		
		String sql = "select * from publisher where pub_state='1'";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){ 
			String pub_id = rs.getString("pub_id");
			String pub_name = rs.getString("pub_name");
			int pub_contact = rs.getInt("pub_contact");
			int pub_id_number = rs.getInt("pub_id_number");
			int pub_credit = rs.getInt("pub_credit");
			
			Publisher publisher = new Publisher(pub_id,pub_name,pub_contact,pub_id_number,pub_credit);
			publisherArrayList.add(publisher);
		}
		
		return publisherArrayList;
	}	
	
	
}
