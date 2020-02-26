package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AutomateDAO;
import dao.RapportDAO;
import models.Automate;
import utl.HibernateUtil;

/**
 * Servlet implementation class ModuleTele
 */
@WebServlet("/rapport")
public class ModuleTele extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RapportDAO dao;
    private Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleTele() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	HibernateUtil.loadSessionFactory();
		this.dao = new RapportDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action = request.getServletPath();
    	try {
            switch (action) {
            case "/rapportjson":
            	getRapportsJson(request,response);
                break;
            case "/rapportxml": 
            	getRapportsXml(request,response);
                break;
            default:
            	break;
            }
    	} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private void getRapportsJson(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException 
    {
    	System.out.println("yay");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(this.gson.toJson(this.dao.getAllRapports()));
        out.flush();
    }
    
    private void getRapportsXml(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException 
    {

    }

}
