package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.User;



//对用户表进行插入/查询
public class UserDao {

	public User Plogin(Connection con,User user) throws Exception{  //登录
		
		User resultUser = null;
		String sql="select * from Publisher where pub_id=?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, user.getEmail());
		
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			
			resultUser=new User();
			resultUser.setEmail(rs.getString("id"));
			resultUser.setPassword(rs.getString("password"));
			
		}
		
		return resultUser;	
	}
	public User Vlogin(Connection con,User user) throws Exception{  //登录
		
		User resultUser = null;
		String sql="select * from volunteer where v_id=?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, user.getEmail());
		
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			
			resultUser=new User();
			resultUser.setEmail(rs.getString("id"));
			resultUser.setPassword(rs.getString("password"));
			
		}
		
		return resultUser;	
	}
                   
                   
	
	

	public boolean Uregister(Connection con,String email,String userName,String password,String idnumber,String contact) throws Exception{
		
		boolean flag=false;
		
	
			String sql="INSERT INTO volunteer(v_id,v_name,v_paw,v_contact,v_id_number,v_credit) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt2 = null;
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, email);
			pstmt2.setString(2, userName);
			pstmt2.setString(3, password);
			pstmt2.setString(4,contact);
			pstmt2.setString(5, idnumber);
			pstmt2.setString(6,"0");
			
			
			
			if (pstmt2.executeUpdate() > 0) {
				flag = true;
			}
		return flag;
			
	}
			
	
	public boolean Pregister(Connection con,String email,String userName,String password,String idnumber,String contact) throws Exception{
		
		boolean flag=false;
		
	
			String sql="INSERT INTO publisher(pub_id,pub_name,pub_psw,pub_contact,pub_id_number,pub_state,pub_credit) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt2 = null;
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, email);
			pstmt2.setString(2, userName);
			pstmt2.setString(3, password);
			pstmt2.setString(4,contact);
			pstmt2.setString(5, idnumber);
			pstmt2.setString(6,"0");
			pstmt2.setString(7,"0");
			
			
			if (pstmt2.executeUpdate() > 0) {
				flag = true;
			}
			
		

		
		
		/*详细信息的填入
		String sql2="INSERT INTO userInfor(id,name,email,image) VALUES(?,?,?,?)";
		PreparedStatement pstmt3 = null;
		pstmt3 = con.prepareStatement(sql2);
		pstmt3.setString(1, id);
		pstmt3.setString(2, "");
		pstmt3.setString(3, email);
		
		
		//读取本地图片，作为默认头像
		File file1 = new File("C:\\Users\\lenovo\\Desktop\\user.jpg");
		//得到大小
		int length = (int) file1.length();
		//获得文件输入流
		InputStream input = new FileInputStream(file1);
		pstmt3.setBinaryStream(4,input,length);
		
		if (pstmt3.executeUpdate() > 0) {
			flag = true;
		}
        */
		return flag;
	
	}

}