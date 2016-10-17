package com.lijun.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijun.web.model.ContentInfo;
import com.lijun.web.service.ContentService;

public class ContentAction extends HttpServlet {

	
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
	    
		request.removeAttribute("contents");
		
		String sql="select * from content";
	    ContentService contentService=new ContentService();
	    List<ContentInfo> lsContentInfos= contentService.queryContent(sql);
	    if(lsContentInfos!=null&&lsContentInfos.size()>0){
	    	request.setAttribute("contents", lsContentInfos);
	    }
	    RequestDispatcher dispatcher = request.getRequestDispatcher("content.jsp");
    	dispatcher.forward(request, response);
	   
	}

}
