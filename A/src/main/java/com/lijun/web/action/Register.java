package com.lijun.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijun.web.service.UserService;

public class Register extends HttpServlet {

	
	public Register() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter();
		
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		
		//-----有注入 start-----
		String sql="insert into userinfo values("+"'"+UUID.randomUUID()+"'"+","+"'"+userName+"'"+","+"'"+passWord+"')";
		UserService uService=new UserService();
		if(uService.insert(sql)){
			response.getWriter().print("注册成功！");
		}else {
			response.getWriter().print("注册失败！");
		}
		//-----有注入 end-----
		
		
		//--------防止SQL注入 start-------
		
		/*StringBuffer sql=new StringBuffer(" insert into userinfo values(?,?,?); ");
		String[] paras=new String[]{UUID.randomUUID().toString(),userName,passWord};
		
		UserService uService=new UserService();
		if(uService.insert(sql.toString(),paras)){
			response.getWriter().print("注册成功！");
		}else {
			response.getWriter().print("注册失败！");
		}*/
		
		//--------防止SQL注入 end-------
		
	}

}
