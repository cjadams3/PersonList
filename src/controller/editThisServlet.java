package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonItem;

/**
 * Servlet implementation class editThisServlet
 */
@WebServlet("/editThisServlet")
public class editThisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editThisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonItemHelper pi = new PersonItemHelper();
		try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PersonItem itemToEdit = pi.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edit-person.jsp").forward(request, response);
			
		}
		catch (NumberFormatException e) {
			getServletContext().getRequestDispatcher("/edit.html").forward(request, response);
		}
	}

}
