package com.lijun.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lijun.web.model.ContentInfo;
import com.lijun.web.model.UserInfo;
import com.lijun.web.service.ContentService;
import com.lijun.web.service.UserService;

public class LoginAction extends HttpServlet {

	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter();
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		
		List<UserInfo> uInfos =new ArrayList<UserInfo>();
		
		if(userInfo==null){
		
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		
		//----------------无参数start-----------------
		String sql="select * from userinfo where username='"+userName+"'and password='"+passWord+"'";
		UserService userService=new UserService();
	    uInfos=userService.queryUsers(sql);
		
		}else {
			uInfos.add(userInfo);
		}
		if(uInfos!=null&&uInfos.size()>0){
			userInfo=uInfos.get(0);
			

			Cookie cookie=new Cookie(userInfo.getUserName(), userInfo.getPassWord());
			response.addCookie(cookie);
			
			
			session.setAttribute("userInfo", userInfo);
			
			String sqlContent="select * from content";
		    ContentService contentService=new ContentService();
		    List<ContentInfo> lsContentInfos= contentService.queryContent(sqlContent);
		    if(lsContentInfos!=null&&lsContentInfos.size()>0){
		    	request.setAttribute("contents", lsContentInfos);
		    }
		    RequestDispatcher dispatcher = request.getRequestDispatcher("content.jsp");
	    	dispatcher.forward(request, response);
		}else {
			response.getWriter().print("用户名或者密码错误！");
		}
		//----------------无参数end-------------------
		
		
		
		//----------------有参查询start-----------------
		/*String sql="select * from userinfo where username=? and password=?";
		String[] paras=new String[]{userName,passWord};
		
		UserService userService=new UserService();
		List<UserInfo> uInfos=userService.queryUsers(sql,paras);
		
		if(uInfos!=null&&uInfos.size()>0){
			UserInfo userInfo=uInfos.get(0);
			
			Cookie cookie=new Cookie(userInfo.getUserName(), userInfo.getPassWord());
			response.addCookie(cookie);
			
			response.getWriter().print("登录成功！");
		}else {
			response.getWriter().print("登录失败！");
		}*/
		//----------------有参查询end-------------------
		

	}

	

}
