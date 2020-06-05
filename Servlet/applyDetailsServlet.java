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
import Entity.apply_project;

/**
 * Servlet implementation class applyDetailsServlet
 */
@WebServlet("/applyDetailsServlet")
public class applyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public applyDetailsServlet() {
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
		
        //从数据库中获取申请表详细信息
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			
			String v_id = request.getParameter("v_id");	
			System.out.println(v_id);
			String pro_id = request.getParameter("pro_id");	
			System.out.println(pro_id);

		    ApplyDao apply=new ApplyDao();
		    apply_project applyDetails = apply.showApplyDetails(con,v_id,pro_id);	
		    
		    request.setAttribute("applyDetails", applyDetails);
		    
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
		
		request.getRequestDispatcher("applyDetails.jsp").forward(request,response);
	}

}
