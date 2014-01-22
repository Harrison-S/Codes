package org.market.serviceservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.market.controlmysql.GoodsInfo;
import org.market.types.GoodsType;

public class AndroidSearchGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AndroidSearchGoodsServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//DataOutputStream output = new DataOutputStream(response.getOutputStream());
		int mainClass = Integer.parseInt(request.getParameter("list1"));
		int subClass = Integer.parseInt(request.getParameter("list2"));
		System.out.println(mainClass+"\n"+subClass);
		GoodsInfo androidSearch = new GoodsInfo();
		ArrayList<GoodsType> result = androidSearch.certainGoods(mainClass, subClass);
		System.out.println(build(result));
		out.print(build(result));
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public String build(ArrayList<GoodsType> result){
		String re = "";
		for(int i = 0; i < result.size();i++){
			GoodsType temp = result.get(i);
			if(re.equals("")){
				System.out.println("first time...");
				re = temp.getGNO()+"|"+temp.getName()+"|"+temp.getOwner()+"|"+temp.getPrice()
			+"|"+temp.getImage()+temp.getMainClass()+"|"+temp.getSubClass()+"|"+temp.getIntroduction()
			+"|"+temp.getDate()+"$";
				}
			else
				re = re + temp.getGNO()+"|"+temp.getName()+"|"+temp.getOwner()+"|"+temp.getPrice()
				+"|"+temp.getImage()+temp.getMainClass()+"|"+temp.getSubClass()+"|"+temp.getIntroduction()
				+"|"+temp.getDate()+"$";
		}
		return re;
	}
}
