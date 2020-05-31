import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PmeServlet
 */
@WebServlet("/PmeServlet")
public class PmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBUtil dbUtil = new DBUtil();
	ArrayList<publisher> publisherArrayList = new ArrayList<publisher>();
	
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
		
        //从数据库中获取发布者个人信息arraylist 
		Connection con = null;
		try {
			con = dbUtil.getConnection();

		    PublisherDao publisher=new PublisherDao();
			publisherArrayList = publisher.showPublisher(con);			
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
		request.setAttribute("publisherArrayList", publisherArrayList);
		request.getRequestDispatcher("Pme.jsp").forward(request,response);
	}

}
