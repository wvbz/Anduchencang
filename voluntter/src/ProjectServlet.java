

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contract.Contract;
import Contract.ContractDao;
import DBTool.DBUtil;

/**展示待定稿的合同
 * Servlet implementation class DaiDingGaoServlet
 */
@WebServlet("/DaiDingGaoServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBUtil dbUtil = new DBUtil();
	ContractDao contractDao = new ContractDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
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
		Connection con = null;
		
		try {
			con = dbUtil.getConnection();
			
			ArrayList<Contract> contractArrayList = new ArrayList<Contract>();  
			contractArrayList = contractDao.ShowDaiDingGao(con);
			
			request.setAttribute("contractArrayList", contractArrayList);
			
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
		request.getRequestDispatcher("待定稿合同.jsp").forward(request,response);
	}
}
