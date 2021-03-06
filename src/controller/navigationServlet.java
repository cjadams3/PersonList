package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("select");
		
		if (action == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (action.equals("add")) {
			getServletContext().getRequestDispatcher("/add.html").forward(request, response);
		}
		else if (action.equals("edit")) {
			getServletContext().getRequestDispatcher("/editMenu.html").forward(request, response);
		}
		else if (action.equals("delete")) {
			getServletContext().getRequestDispatcher("/delete.html").forward(request, response);
		}
		else if (action.equals("view")) {
			getServletContext().getRequestDispatcher("/viewAllServlet").forward(request, response);
		}
	}

}
