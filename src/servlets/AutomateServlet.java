package servlets;

import java.io.IOException;

import models.Address;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutomateServlet
 */
@WebServlet("/automateservlet")
public class AutomateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action = request.getServletPath();
            switch (action) {
            case "/address":
            	listAddress(request, response);
                break;
            default:
            	break;
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
    private void listAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Address> listA = new ArrayList<>();
        Address a1 = new Address(1, "aa", "aa", 234);
        Address a2 = new Address(2,"aze","&é",23);
        listA.add(a1);
        listA.add(a2);
        request.setAttribute("listA", listA);
        RequestDispatcher dispatcher = request.getRequestDispatcher("a.jsp");
        dispatcher.forward(request, response);
    }

}
