package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ToDoerUtil;
import model.Todoer;

/**
 * Servlet implementation class AddDoer
 */
@WebServlet("/AddDoer")
public class AddDoer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ToDoerDB doerDB = new ToDoerDB();
		Todoer doer = new Todoer();
//		INSERT INTO testuserdb.TODOER (ID, ADMINROLE, EMAIL, NAME, PASSWORD) VALUES (?, ?, ?, ?, ?)
		doer.setId(3);
		doer.setName("anshy");
		doer.setEmail("aa@zz");
		doer.setAdminrole(new BigDecimal(0));
		doer.setPassword("");
		ToDoerUtil.insert(doer);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
