import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBTool.DBUtil;
import Dao.UserDao;
import Entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBUtil dbUtil = new DBUtil();
	UserDao userDao = new UserDao();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String passwordConfirm=request.getParameter("passwordConfirm");
		String checkedbox=request.getParameter("checked");
		String idnumber=request.getParameter("idnumber");
		String contact=request.getParameter("contact");
		if(checkedbox==null) {
			checkedbox = "";
		}
		
		//��ȷ�����������Ƿ���ͬ
		if(!password.equals(passwordConfirm)) {
			
			request.setAttribute("errorMessage2", "������������벻��ͬ��");
			request.getRequestDispatcher("register.jsp").forward(request, response);	
		}
		else {
			
			Connection con = null;
			try {
				
				// ����һ��dbutil���� Ȼ����userDao����ִ��sql����õ�
				con = dbUtil.getConnection();
				//���������ݿ��еĲ�ѯ���
				
				//�ж��Ƿ�ע���Ϊ����Ա
				
				boolean flag;
				if(checkedbox.equals("on")) {  //��ʾע���Ϊ������
					flag = userDao.Pregister(con, email, userName,password,idnumber,contact);
					//ע��ɹ������ص���¼ҳ��
					request.getRequestDispatcher("login2.jsp").forward(request, response);
					//�ȴ����ҳ��
				}
				else {//��ʾע���Ϊ��ͨ���û����ȴ�����ԱΪ������ɫ
					flag = userDao.Uregister(con, email, userName,password,idnumber,contact);
					//ע��ɹ������ص���¼ҳ��
					request.setAttribute("errorMessage2", "��������������!");//������󣬽�������գ��û����������仯
					request.getRequestDispatcher("login2.jsp").forward(request, response);
					
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

}

