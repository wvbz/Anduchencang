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
import Dao.PublisherDao;
import Entity.Project;
import Entity.Publisher;
import Entity.apply_project;

/**
 * Servlet implementation class PmeServlet
 */
@WebServlet("/PmeServlet")
public class PmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PmeServlet() {
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
		
        //从数据库中获取发布者个人信息
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			
			
			String pub_id = request.getParameter("pub_id");	
			System.out.println(pub_id);
			
            PublisherDao publisher = new PublisherDao();
            ProjectDao project = new ProjectDao();
            ApplyDao apply = new ApplyDao();
			Publisher publisherShow = publisher.showPublisher(con,pub_id);
			ArrayList<Project> projectDoing = project.showPdoing(con, pub_id);
			ArrayList<apply_project> applyList = apply.showApply(con, pub_id);
			
			request.setAttribute("publisherShow", publisherShow);
			request.setAttribute("projectDoing", projectDoing);
			request.setAttribute("applyList", applyList);
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
		
		request.getRequestDispatcher("Pme.jsp").forward(request,response);
	}

}
