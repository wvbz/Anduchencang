package DBTool;

//连接Oracle的工具集
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	public final static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	//前提启动oracle
	public final static String USERNAME="c##zyt";//用户名
	public final static String PWD="zyt";//密码
	public final static String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	//java程序中如何获取DRIVER
	//静态块
	
	static{
		try {//使用Class.forName可以达到加载特定驱动程序的目的，每种数据库管理系统（DBMS）
			//的驱动都不同，有数据库厂商提供
			Class.forName(DRIVER);
			//目前我们连接的是Oracle所以在此我们要写好OracleDriver
			//java.lang.ClassNotFoundException
			System.out.println("获取驱动成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("没有获取到驱动！");
			e.printStackTrace();
		}		
	}
	
	//java将会利用获取到的驱动来连接数据库  java.sql 
	public Connection getConnection() throws SQLException{
		Connection conn=null;
		//先获得数据库的驱动
		conn=DriverManager.getConnection(URL, USERNAME, PWD);
		return conn;
	}
	
 //创建释放所有资源的方法
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}

}



