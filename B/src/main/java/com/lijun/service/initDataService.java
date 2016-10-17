package com.lijun.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lijun.model.UserData;
import com.lijun.tools.Tools;

public class initDataService {

	/***
	 * 参数化防止注入
	 * @param sql
	 * @param params
	 * @return
	 */
	public Boolean insert(String sql,String[] params) {
		boolean temp=false;
		Connection conn = null;
		PreparedStatement pt = null; 
		try {
			conn =Tools.getConn();
			pt=conn.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				pt.setString(i+1,params[i]);
			}
			
			if(pt.executeUpdate()>0){
				temp=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				Tools.CloseSource(conn, null, pt);
		}
		return temp;
	}
	/**
	 * 内容查询
	 * 
	 * @param sql
	 * @return
	 */
	public List<UserData> queryContent(String sql) {
		Connection conn = Tools.getConn();
		Statement stmt = null;
		List<UserData> cInfos = new ArrayList<UserData>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setUserName(rs.getString("username"));
				userData.setPassWord(rs.getString("password"));
				userData.setCreateTime(rs.getString("createTime"));
				cInfos.add(userData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cInfos;
	}
	
}
