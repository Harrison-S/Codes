package org.market.serviceservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.market.controlmysql.ClientInfo;
import org.market.types.ClientType;

public class ModifyUserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ModifyUserInfoServlet() {
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
		//System.out.println("Start Modifying User Infomation...");
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String usr = request.getParameter("usr");
		String pwd = request.getParameter("password");
		String stuNO = request.getParameter("stuNO");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		System.out.println("usr:"+usr+"\npassword:"+pwd+"\nStuNO:"+stuNO+"\nsex:"+sex+
				"\nemail:"+email+"\nphone:"+phone+"\ndate:"+date);
		ClientInfo modifyClient = new ClientInfo();
		if(modifyClient.modifyClient(new ClientType(usr,pwd,sex,stuNO,phone,email,date))){
			System.out.println("Modify User Infomation Successfully!!");
		}else{
			System.out.println("Modify User Infomation failed!!");
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
