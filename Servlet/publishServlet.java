package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBTool.DBUtil;
import Dao.ProjectDao;
import Entity.Project;

/**
 * Servlet implementation class publishServlet
 */
@WebServlet("/publishServlet")
public class publishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publishServlet() {
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
		 try {
			 con = dbUtil.getConnection();
			 
             String pub_id = request.getParameter("pub_id");
			 String pro_id = request.getParameter("pro_id");
			 String pro_name = request.getParameter("pro_name");
			 String pro_intro = request.getParameter("pro_intro");
			 String pro_info = request.getParameter("pro_info");
			 String pro_state = request.getParameter("pro_state");
			 Date pro_s_time = request.getParameter("pro_s_time");
			 Date pro_e_time = request.getParameter("pro_e_time");
			 String pro_type = request.getParameter("pro_type");
			 String pro_place = request.getParameter("pro_place");
			 int v_num = request.getParameter("v_num");
			
			 System.out.println(pub_id);
			 System.out.println(pro_id);
			 System.out.println(pro_name);
			 System.out.println(pro_intro);
			 System.out.println(pro_info);
			 System.out.println(pro_state);
			 System.out.println(pro_s_time);
			 System.out.println(pro_e_time);
			 System.out.println(pro_type);
			 System.out.println(pro_place);
			 System.out.println(v_num);
				
			 Project project=new Project(pro_id,pro_name,pro_intro,pro_info,pro_state,pro_s_time,pro_e_time,pro_type,pro_place,v_num);
			 ProjectDao pro = new ProjectDao();
			 pro.createProject(con,project,pub_id);
				
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
		request.getRequestDispatcher("publish.jsp").forward(request,response);
		
	}
}
