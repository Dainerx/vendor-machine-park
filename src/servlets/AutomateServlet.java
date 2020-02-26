package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import models.*;
import utl.HibernateUtil;
import utl.XmlWrapperRapport;
import dao.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutomateServlet
 */
@WebServlet("/")
public class AutomateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AutomateDAO dao;
	private Gson gson = new Gson();
	private List<Automate> la = new ArrayList<>();

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
		List<Rapport> listR = this.dao.feedRapports();
		for (Rapport r : listR) {
			this.dao.saveRapport(r);
		}	
		
		/*
		 * 			List<Rapport> listR = this.dao.feedRapports();
			for (Rapport r : listR) {
				this.dao.saveRapport(r);
			}	
		List<Automate> list = this.dao.feedAutomates();
		for (Automate a : list) {
			this.dao.saveAutomate(a);
		}
		*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/":
				listAutomate(request, response);
				break;
			case "/add":
				insertAutomate(request, response);
				break;
			case "/getone":
				listOneAutomate(request, response);
				break;
			case "/list":
				listAutomate(request, response);
				break;
			case "/delete":
				deleteAutomate(request,response);
				break;
			case "/rapportjson":
				getRapportsJson(request, response);
				break;
			case "/rapportxml":
				getRapportsXml(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	private void listOneAutomate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Automate a = this.dao.getAutomate("1000"); // Request from interface
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-automate.jsp");
		dispatcher.forward(request, response);
	}

	private void listAutomate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Automate> list = this.dao.getAllAutomates();
		this.la = list;
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-automate.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteAutomate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serialNumber = request.getParameter("serialNumber");
		for (Automate a : this.la)
		{
			System.out.println(a.getSerialNumber());
			if (a.getSerialNumber().equals(serialNumber))
			{
				this.la.remove(a);
			}
		}
		request.setAttribute("list", this.la);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-automate.jsp");
		dispatcher.forward(request, response);
	}
	private void insertAutomate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Machine creation
		CarteSansContact cc = new CarteSansContact("normal");
		Set<PaymentSystem> pp = new HashSet<>();
		Set<MachineErr> ll = new HashSet<>();
		MachineErr err = new MachineErr();
		err.setMessage("aze");
		CarteSansContact c = new CarteSansContact();
		Machine machine = new Machine(StateMachine.OK, 23.4f, pp, ll);
		machine.addErrors(err);
		machine.addPaymentSystem(c);
	
		Address address = new Address(99, "Avenue Jean Baptiste Clement", "Villetaneuse", 93430);
		Gps gps = new Gps(48.954230f, 2.337950f);

		Automate automate = new Automate();
		int randomSerial = (int)(Math.random() * ((10000 - 1000) + 1)) + 1000;
		String serialNumber = Integer.toString(randomSerial);
		automate.setSerialNumber(serialNumber);
		automate.setMachine(machine);
		automate.setAddress(address);
		automate.setGpsCoordinates(gps);
		automate.setStateAutomate(StateAutomate.UP);
		automate.setArea("Forum");
		automate.setArticlesType(ArticlesType.Snacks);
		this.dao.saveAutomate(automate);
		response.sendRedirect("list");
	}

	private void getRapportsJson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(this.gson.toJson(this.dao.getAllRapports()));
		out.flush();
	}

	private void getRapportsXml(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringWriter sw = new StringWriter();
		XmlWrapperRapport xwr = new XmlWrapperRapport();
		xwr.setRapports(this.dao.getAllRapports());
		JAXB.marshal(xwr,sw);
		String xmlString = sw.toString();
		out.print(xmlString);
		out.flush();
	}

}
