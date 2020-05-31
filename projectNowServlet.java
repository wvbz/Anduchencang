import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class projectNowServlet
 */
@WebServlet("/projectNowServlet")
public class projectNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	ArrayList<project> projectArrayList = new ArrayList<project>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectNowServlet() {
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
		
        //从数据库中获取项目信息arraylist 
		Connection con = null;
		try {
			con = dbUtil.getConnection();

		    ProjectDao project=new ProjectDao();
			projectArrayList = project.showProject(con);			
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
		request.setAttribute("projectArrayList", projectArrayList);
		request.getRequestDispatcher("projectNow.jsp").forward(request,response);
	}

}
