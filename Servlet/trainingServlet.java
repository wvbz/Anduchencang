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
import Dao.TrainDao;
import Entity.train;

/**
 * Servlet implementation class trainingServlet
 */
@WebServlet("/trainingServlet")
public class trainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trainingServlet() {
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
		 
		 
		 //从数据库中获取培训信息
		 Connection con = null;
		 try {
			 con = dbUtil.getConnection();

			 String pro_id = request.getParameter("pro_id");
			 String t_content = request.getParameter("t_content");
			 Date t_s_time = request.getParameter("t_s_time");
			 Date t_e_time = request.getParameter("t_e_time");
			 System.out.println(pro_id);
			 System.out.println(t_content);
			 System.out.println(t_s_time);
			 System.out.println(t_e_time);
			 
			 train train=new train(pro_id,t_content,t_s_time,t_e_time);
			 TrainDao t=new TrainDao();
			 t.createTrain(con, train);
			 
				
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
		request.getRequestDispatcher("training.jsp").forward(request,response);
		
	}
}
