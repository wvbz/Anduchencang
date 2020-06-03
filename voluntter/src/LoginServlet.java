
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBTool.DBUtil;
import Entity.User;
import Dao.UserDao;
import Entity.UserNow;



/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static String id;
	DBUtil dbUtil = new DBUtil();
	UserDao userDao = new UserDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//��ȡ����˵��û���������
		String checkedbox=request.getParameter("checked");
		String userName=request.getParameter("user");
		String password=request.getParameter("password");
		
		if(checkedbox==null) {
			checkedbox = "";
		}
		User user = new User(userName, password);
		Connection con = null;
		User currentUser=null;
		try {
			
			// ����һ��dbutil���� Ȼ����userDao����ִ��sql����õ�
			con = dbUtil.getConnection();
			if(checkedbox.equals("on")) {//�Ƿ�����
				currentUser = userDao.Plogin(con, user);
			}
			else {
				currentUser = userDao.Vlogin(con, user);
			}
			
			
			
			//���������ݿ��еĲ�ѯ���
			
			if (currentUser == null) {
				request.setAttribute("errorMessage1", "�û������ڣ�");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} 
			
			else {
				
				if(!(currentUser.getPasswor()).equals(password)) {
					
					request.setAttribute("errorMessage2", "�������!");//������󣬽�������գ��û����������仯
					request.setAttribute("errorMessage1", userName);
					request.getRequestDispatcher("login2.jsp").forward(request, response);
				}
				else{   //��¼�ɹ�
				
					id = userName;
					UserNow.id = id;
					request.getRequestDispatcher("login2.jsp").forward(request, response);//��ת��ҳ
			
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

