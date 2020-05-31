import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class applyDetailsServlet
 */
@WebServlet("/applyDetailsServlet")
public class applyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	ArrayList<apply> applyArrayList = new ArrayList<apply>();
	
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
		
        //从数据库中获取申请表信息arraylist
		Connection con = null;
		try {
			con = dbUtil.getConnection();

		    VolunteerDao volunteer=new VolunteerDao();
		    applyArrayList = volunteer.showApply(con);			
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
		request.setAttribute("applyArrayList", applyArrayList);
		request.getRequestDispatcher("applyDetails.jsp").forward(request,response);
	}

}
