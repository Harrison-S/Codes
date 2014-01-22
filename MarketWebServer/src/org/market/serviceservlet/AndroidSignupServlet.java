package org.market.serviceservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.market.controlmysql.ClientInfo;
import org.market.tools.FormatVerification;
import org.market.types.ClientType;

public class AndroidSignupServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AndroidSignupServlet() {
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
		PrintWriter out = response.getWriter();
		String usr = request.getParameter("username");
		String pwd = request.getParameter("password");
		String stuNO = request.getParameter("stuno");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String date = format1.format(new Date());
	    System.out.println("username:"+usr+"\npwd:"+pwd+"\nstuNO:"+stuNO+"\nsex:"+sex
	    		+"\nemail:"+email+"\nphone:"+phone+"\ndate:"+date);
		if(!FormatVerification.verify123ABC(usr)){
			System.out.println("username_error");
			out.print("username_error");
		}else if(!FormatVerification.verify123ABC(pwd)){
			System.out.println("password_error");
			out.print("password_error");
		}else if(!FormatVerification.verifyStuNO(stuNO)){
			System.out.println("student_number_error");
			out.print("student_number_error");
		}else if(!FormatVerification.verifyMail(email)){
			System.out.println("email_error");
			out.print("email_error");
		}else if(!FormatVerification.verifyPhone(phone)){
			System.out.println("phone_error");
			out.print("phone_error");
		}else{
			System.out.print("Android request is legal,start registering...");
			ClientInfo androidRegister = new ClientInfo();
			ClientType androidCustomer = new ClientType(usr,pwd,sex,stuNO,phone,email,date);
			if(androidRegister.addClient(androidCustomer)){
				System.out.println("Register Successful.Congratulations!!");
				out.print("success");
			}else{
				System.out.println("Register failed.Sorry...");
				out.print("sorry");
			}
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
