package fr.gtm.contacts.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;
import fr.gtm.contacts.services.ContactServices;

/**
 * Servlet implementation class CreateContactsServelt
 */
@WebServlet("/CreateContactsServelt")
public class CreateContactsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServices service = (ContactServices) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		Contact contact = new Contact();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		contact.setNom(nom);
		contact.setPrenom(prenom);
		String stringCivilite = request.getParameter("civilite");
		contact.setCivilite(Civilite.valueOf(stringCivilite));
		
		String page = "";
		if(nom==null || nom.isEmpty()) {
			page = "/index.jsp";
		}
		else {
		service.createContact(contact);
		page = "/show-contacts.jsp";
		}
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
//		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
