package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContactBens;
import model.ContactDAO;

import java.io.IOException;
import java.util.ArrayList;

import client.AtendeCliente;
import client.AtendeClienteService;
import client.EnderecoERP;
import client.SQLException_Exception;
import client.SigepClienteException;
import client.util.ConnectionSOAP;

/**
 * Servlet implementation class ContactController
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/cep" })
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	ContactDAO dao = new ContactDAO();
	
	/** The model. */
	ContactBens contact = new ContactBens();
	
	private AtendeCliente soapCorreios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        soapCorreios = ConnectionSOAP.getServicocorreio();
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contacts(request, response);
		} else if (action.equals("/insert")) {
			insert(request, response);
		} else if (action.equals("/select")) {
			getContact(request, response);
		} else if (action.equals("/update")) {
			updateContact(request, response);
		} else if (action.equals("/delete")) {
			deleteContact(request, response);
		} else if (action.equals("/cep")) {
			getCEP(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Contacts.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contacts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ContactBens> contacts = dao.list();
		request.setAttribute("contacts", contacts);
		RequestDispatcher rd = request.getRequestDispatcher("contacts.jsp");
		rd.forward(request, response);
	}

	/**
	 * Insert contact.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setName(request.getParameter("name"));
		contact.setFone(request.getParameter("fone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAdress(request.getParameter("adress"));
		contact.setZipCode(request.getParameter("zipCode"));
		dao.insert(contact);
		response.sendRedirect("main");
	}
	
	/**
	 * Get contact.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void getContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setId(request.getParameter("id"));
		dao.getById(contact);
		request.setAttribute("id", contact.getId());
		request.setAttribute("name", contact.getName());
		request.setAttribute("fone", contact.getFone());
		request.setAttribute("email", contact.getEmail());
		request.setAttribute("adress", contact.getAdress());
		request.setAttribute("zipCode", contact.getZipCode());
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Update contact.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void updateContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setId(request.getParameter("id"));
		contact.setName(request.getParameter("name"));
		contact.setFone(request.getParameter("fone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAdress(request.getParameter("adress"));
		contact.setZipCode(request.getParameter("zipCode"));
		dao.update(contact);
		response.sendRedirect("main");
	}
	
	/**
	 * Delete contact by id.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void deleteContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setId(request.getParameter("id"));
		dao.deleteById(contact);
		response.sendRedirect("main");
	}
	
	/**
	 * Get CEP.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SigepClienteException 
	 * @throws SQLException_Exception 
	 */
	protected void getCEP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adressResponse = "";
		try {
			String cep = request.getParameter("zipCode");
			EnderecoERP adress = soapCorreios.consultaCEP(cep);
			
			adressResponse = adress.getEnd() + ", " +					
				     adress.getBairro() + ", " +
				     adress.getCidade() + "-" + adress.getUf();

		} catch (SQLException_Exception e) {
			e.printStackTrace();
		} catch (SigepClienteException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
        response.getWriter().write(adressResponse);
	}
}
