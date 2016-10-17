package com.lijun.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lijun.web.model.UserInfo;
import com.lijun.web.service.ContentService;
import com.lijun.web.utils.Tools;

public class AddContentAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddContentAction() {
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

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		
		if(userInfo!=null){
			
			//--------防止SQL注入 start-------
			StringBuffer sql=new StringBuffer(" insert into content values(?,?,?,?,?); ");
			String[] paras=new String[]{UUID.randomUUID().toString(),title,content,Tools.getCurrentTime(),userInfo.getUserName()};
			
			ContentService cService=new ContentService();
			if(cService.insert(sql.toString(),paras)){
				response.getWriter().print(true);
			}else {
				response.getWriter().print(false);
			}
			//--------防止SQL注入 end-------
			
		}else {
			response.getWriter().print("会话过期！请重新登录");
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
