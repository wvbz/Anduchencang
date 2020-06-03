package DBTool;

//����Oracle�Ĺ��߼�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	public final static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	//ǰ������oracle
	public final static String USERNAME="c##zyt";//�û���
	public final static String PWD="zyt";//����
	public final static String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	//java��������λ�ȡDRIVER
	//��̬��
	
	static{
		try {//ʹ��Class.forName���Դﵽ�����ض����������Ŀ�ģ�ÿ�����ݿ����ϵͳ��DBMS��
			//����������ͬ�������ݿ⳧���ṩ
			Class.forName(DRIVER);
			//Ŀǰ�������ӵ���Oracle�����ڴ�����Ҫд��OracleDriver
			//java.lang.ClassNotFoundException
			System.out.println("��ȡ�����ɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("û�л�ȡ��������");
			e.printStackTrace();
		}		
	}
	
	//java�������û�ȡ�����������������ݿ�  java.sql 
	public Connection getConnection() throws SQLException{
		Connection conn=null;
		//�Ȼ�����ݿ������
		conn=DriverManager.getConnection(URL, USERNAME, PWD);
		return conn;
	}
	
 //�����ͷ�������Դ�ķ���
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}

}



