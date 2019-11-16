package ca.sheridancollege.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.model.Model;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/access")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model myModel = null;
	
	@Override
	public void init() {  // this whole section needed to be manually added
		myModel = new Model();  // lifecycle - gets done only once
		
		
	}

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    	super(); // added manually
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accessState = request.getParameter("access");
		if (accessState.equals("denied"))
			response.sendRedirect("http://disney.com");
		else
		{
			String myImage = myModel.returnImage(); // gets a random image
			request.setAttribute("movie,myImage");
			myModel.LogAccess(request.getRemoteAddr()); // get IP address from request
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
