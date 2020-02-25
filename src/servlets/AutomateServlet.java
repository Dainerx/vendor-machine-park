package servlets;

import java.io.IOException;
import java.sql.SQLException;

import models.*;
import utl.HibernateUtil;
import dao.*;
import java.util.*;
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


	private AutomateDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	HibernateUtil.loadSessionFactory();
		this.dao = new AutomateDAO();
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action = request.getServletPath();
            switch (action) {
            case "/add":
            	insertAutomate(request, response);
                break;
            case "/list":
            	try {
					listAutomate(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
    private void listAutomate(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Automate> list = this.dao.getAllAutomates();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("automate-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertAutomate(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException 
    {
				// Machine creation
				Address ad = new Address(2, "a", "sarra", 2097);
				CarteSansContact cc = new CarteSansContact("normal");
				Set<PaymentSystem> pp = new HashSet<>();
				Set<MachineErr> ll = new HashSet<>();
				MachineErr err = new MachineErr();
				err.setMessage("aze");
				CarteSansContact c = new CarteSansContact();
				Machine machine = new Machine(StateMachine.OK,23.4f,pp,ll);
				machine.addErrors(err);
				machine.addPaymentSystem(c);
			

    	        String serialNumber = "1123123";
    	        String area = "area";
    	        String comments = "";
    	        //Address
    	        int streetNumber = 12321;
    	        String street = "street";
    	        String city = "city";
    	        int postCode = 223;
    	        Address address = new Address(streetNumber, street, city, postCode);
    	        // GPS
    	        Gps gps = new Gps();
    	        // ArticlesType
    	        ArticlesType articlesType = ArticlesType.ColdDrinks;
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

				newAutomate.setMachine(machine);

				this.dao.saveAutomate(newAutomate);
    	        response.sendRedirect("newAutomate");
    	        }



}
