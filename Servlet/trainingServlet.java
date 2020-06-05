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
		 
		 
		 //�����ݿ��л�ȡ��ѵ��Ϣ
		 Connection con = null;
		 try {
			 con = dbUtil.getConnection();

			 String pro_id = request.getParameter("pro_id");	
			 System.out.println(pro_id);
				
			 TrainDao train=new TrainDao();
			 train t=train.showTrain(con,pro_id);
			 
			 request.setAttribute("t", t);
				
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
