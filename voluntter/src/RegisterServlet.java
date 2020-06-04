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
		
		//先确定两次密码是否相同
		if(!password.equals(passwordConfirm)) {
			
			request.setAttribute("errorMessage2", "两次输入的密码不相同！");
			request.getRequestDispatcher("register.jsp").forward(request, response);	
		}
		else {
			
			Connection con = null;
			try {
				
				// 建立一个dbutil链接 然后传入userDao里面执行sql语句用的
				con = dbUtil.getConnection();
				//传回在数据库中的查询结果
				
				//判断是否注册成为管理员
				
				boolean flag;
				if(checkedbox.equals("on")) {  //表示注册成为发布者
					flag = userDao.Pregister(con, email, userName,password,idnumber,contact);
					//注册成功，跳回到登录页面
					request.getRequestDispatcher("login2.jsp").forward(request, response);
					//等待审核页面
				}
				else {//表示注册成为普通新用户，等待管理员为其分配角色
					flag = userDao.Uregister(con, email, userName,password,idnumber,contact);
					//注册成功，跳回到登录页面
					request.setAttribute("errorMessage2", "请输入您的密码!");//密码错误，将密码清空，用户名不发生变化
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

