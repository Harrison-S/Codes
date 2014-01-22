package org.market.serviceservlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.market.controlmysql.*;
import org.market.types.ClientType;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String usr = request.getParameter("usr");
		String pwd = request.getParameter("password");
		String stuNO = request.getParameter("stuNO");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String date = format1.format(new Date());
		System.out.println("usr:"+usr+"\npassword:"+pwd +"\nstu:"+stuNO+
				"\nsex:"+sex+"\nemail:"+email+"\nphone:"+phone+"\ndate:"+date);
		ClientInfo customer = new ClientInfo();
		if(customer.findClient(usr)){
			System.out.println("User name Exists!");
			response.sendRedirect("signup.jsp?error=usrExist");
		}else{
			System.out.println("Signing up...");
			ClientType newCustomer = new ClientType(usr,pwd,sex,stuNO,phone,email,date);
			customer.addClient(newCustomer);
			response.sendRedirect("login.jsp?error=signup");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
