package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editMenuServlet
 */
@WebServlet("/editMenuServlet")
public class editMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		PersonItemHelper pi = new PersonItemHelper();
		
		request.setAttribute("searchItems", pi.getItemsByName(name));
		
		if (pi.getItemsByName(name).isEmpty()) {
			System.out.println("Person not found");
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		getServletContext().getRequestDispatcher("/edititem.jsp").forward(request, response);
	}

}
