package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.ProjectDao;
import Entity.Project;

/**
 * Servlet implementation class projectNowServlet
 */
@WebServlet("/projectDetailsServlet")
public class projectDetailsServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletRes ponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        request.setCharacterEncoding("utf-8");
		
        //从数据库中获取项目信息
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			 
			String pro_id = request.getParameter("pro_id");	
			System.out.println(pro_id);

			ProjectDao project=new ProjectDao();
			Project projectDetails=project.showProject(con,pro_id);
			
			request.setAttribute("projectDetails", projectDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				dbUtil.closeCon(con);;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("审核项目.jsp").forward(request,response);
	}

}