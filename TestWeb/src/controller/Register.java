package controller;

import java.io.IOException;
import java.util.Date;
import model.Todoer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.ToDoerUtil;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("loginname");
		String email = request.getParameter("email");
		String admin = request.getParameter("admin");
		Todoer doer = new Todoer();
		doer.setName("name");
		doer.setEmail("email");
		if (admin.equals("on")) doer.setAdminrole(new java.math.BigDecimal(String.valueOf(1)));
		doer.setPassword("");
		ToDoerUtil.insert(doer);
		HttpSession session = request.getSession(true);
		session.setAttribute("loginname", name);
		session.setAttribute("AnAdmin", "true");
		getServletContext().getRequestDispatcher("/ShowList").forward(request, response);
	}

}
