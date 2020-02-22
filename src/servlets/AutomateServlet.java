package servlets;

import java.io.IOException;

import models.Address;
import models.Automate;
import models.Gps;
import models.StateAutomate;

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
@WebServlet("/")
public class AutomateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserDao userDao;
       
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
            case "/insertautomate":
            	insertAutomate(request, response);
                break;
            default:
            	listAddress(request, response);
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
    
    private void insertAutomate(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException 
    {
    	        String serialNumber = request.getParameter("serialNumber");
    	        String area = request.getParameter("area");
    	        String comments = request.getParameter("comments");
    	        //Address
    	        int streetNumber = Integer.parseInt(request.getParameter("streetNumber"));
    	        String street = request.getParameter("street");
    	        String city = request.getParameter("city");
    	        int postCode = Integer.parseInt(request.getParameter("postCode"));
    	        Address address = new Address(streetNumber, street, city, postCode);
    	        // GPS
    	        float latitude = Float.parseFloat(request.getParameter("latitude"));
    	        float longitude = Float.parseFloat(request.getParameter("longitude"));
    	        Gps gps = new Gps(latitude, longitude);
    	        // ArticlesType
    	        String ArticlesType = request.getParameter("articlestype");
    	        // Construction de l'automate
    	        Automate newAutomate = new Automate();
    	        newAutomate.setSerialNumber(serialNumber);
    	        //newAutomate.setArticlesType(ArticlesType);
    	        newAutomate.setAddress(address);
    	        newAutomate.setArea(area);
    	        newAutomate.setGpsCoordinates(gps);
    	        // on_ajoute_par_defaut_un automate en service, on ne va pas rajouter un automate hors-service si il est nouveau
    	        newAutomate.setStateAutomate(StateAutomate.UP);
    	        newAutomate.setComments(comments);

    	       // userDao.saveUser(newAutomate);
    	        response.sendRedirect("newAutomate");
    	        }

}
