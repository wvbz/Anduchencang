package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PublisherDao;
import Entity.Publisher;

/**
 * Servlet implementation class publisherServlet
 */ 
@WebServlet("/publisherServlet")
public class publisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publisherServlet() {
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
		
        //从数据库中获取发布者信息 
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			
			String pub_id = request.getParameter("pub_id");	
			System.out.println(pub_id);

		    PublisherDao publisher=new PublisherDao();
		    Publisher pub = publisher.showPublisher(con, pub_id);
		    
		    request.setAttribute("pub", pub);
		    
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
		request.getRequestDispatcher("publisher.jsp").forward(request,response);
	}

}
