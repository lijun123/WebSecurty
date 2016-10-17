package com.lijun.action;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijun.service.initDataService;
import com.lijun.tools.Tools;

public class initDataAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数值
		String userCookies = request.getParameter("cookieData");

		String userName = "";
		String userPassWord = "";

		if (userCookies != null && userCookies.contains("=")) {

			String[] temp = userCookies.split("=");
			if (temp != null && temp.length > 0) {
				for (int i = 0; i < temp.length; i++) {
					if ("".equals(userName) && "".equals(userPassWord)) {
						userName = temp[i];
						userPassWord = temp[i + 1];
					}
				}

			}

		}

		if (userName != "" && userPassWord != "") {
			StringBuffer sql = new StringBuffer(
					" insert into userdata values(?,?,?,?); ");
			String[] paras = new String[] { UUID.randomUUID().toString(), userName,
					userPassWord,Tools.getCurrentTime()};

			initDataService initData = new initDataService();
			if (initData.insert(sql.toString(), paras)) {
				response.getWriter().print("成功保存用户信息！");
			} else {
				response.getWriter().print("保存用户信息异常！");
			}
		} else {
			response.getWriter().print("没有获取到有效的用户信息！");
		}

	}

}
