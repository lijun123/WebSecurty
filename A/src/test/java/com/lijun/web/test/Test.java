package com.lijun.web.test;

import java.sql.Connection;

import com.lijun.web.service.UserService;
import com.lijun.web.utils.Tools;


public class Test {

	@org.junit.Test
	public void testConn(){
		Connection connection= Tools.getConn();
		if(connection!=null){
			System.out.println("成功！");
		}
		
	}
	@org.junit.Test
	public void queryObj() {
		String sql="select * from userinfo ";
		UserService uService=new UserService();
		uService.queryUsers(sql);
	}
}
