package fr.gtm.contacts.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;
import fr.gtm.contacts.services.ContactServices;

/**
 * Servlet implementation class GetAllContactsAddressesServlet
 */
@WebServlet("/GetAllContactsAddressesServlet")
public class GetAllContactsAddressesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("contactWeb");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		String page = "";
		String id = request.getParameter("id");
		Set<Adresse> adresses =  service.getAllAdresses(id);
		Contact contact =  service.getContactById(id);
		request.setAttribute("adresses", adresses);
		request.setAttribute("contact", contact);
		page = "/show-contactsLAZY2.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
