package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.ToDoerUtil;
import model.*;
import customTools.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		HttpSession session = request.getSession(true);
		String userid = (String) session.getAttribute("loginname");
		boolean isMember = false;
		if (userid == null) { // user has not logged in
			userid = request.getParameter("loginname");
			isMember = ToDoerUtil.doerExist(userid);
			if (isMember) { // user is a member
				session.setAttribute("loginname", userid);
				// check if an admin
				if (ToDoerUtil.isAdmin(userid)) {
					session.setAttribute("AnAdmin", "true");
				}
				getServletContext().getRequestDispatcher("/ShowList").forward(request, response);
			} else {
				// You are not a memeber yet, please register first
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
		} else {
			String message = "You have logged in already. Do something else.";
			request.setAttribute("Message", message);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
