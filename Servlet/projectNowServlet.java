package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ApplyDao;
import Dao.ProjectDao;
import Entity.Project;
import Entity.apply_project;

/**
 * Servlet implementation class projectNowServlet
 */
@WebServlet("/projectNowServlet")
public class projectNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	DBUtil dbUtil = new DBUtil();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectNowServlet() {
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
		
        //从数据库中获取当前项目信息和志愿者列表
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			 
			String pro_id = request.getParameter("pro_id");	
			System.out.println(pro_id);

			ProjectDao project=new ProjectDao();
			ApplyDao volunteer=new ApplyDao();
			Project projectDetails=project.showProject(con,pro_id);
			ArrayList<apply_project> volunteerShow=volunteer.showVolunteer(con, pro_id);
			
			request.setAttribute("projectDetails", projectDetails);
			request.setAttribute("volunteerShow", volunteerShow);
			
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
		
		request.getRequestDispatcher("projectNow.jsp").forward(request,response);
	}

}
