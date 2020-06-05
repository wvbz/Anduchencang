package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBTool.DBUtil;
import Dao.ApplyDao;
import Dao.ProjectDao;
import Dao.PublisherDao;
import Entity.Project;
import Entity.Publisher;
import Entity.apply_project;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		 response.setCharacterEncoding("utf-8");
		 
		 Connection con = null;
		 
		 //从数据库中获取待审核发布者表arraylist和待审核项目表arraylist
		 try {
				con = dbUtil.getConnection();
				
	            PublisherDao publisher = new PublisherDao();
	            ProjectDao project = new ProjectDao();
				ArrayList<Publisher> dsPublisher = publisher.showDSpub(con);
				ArrayList<Project> dsProject = project.showDSpro(con);
				
				request.setAttribute("dsPublisher", dsPublisher);
				request.setAttribute("dsProject", dsProject);
				
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
			
			request.getRequestDispatcher("admin.jsp").forward(request,response); 
		 
		
	}
}
