package com.lijun.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lijun.web.model.UserInfo;
import com.lijun.web.utils.Tools;

public class UserService {

	/***
	 * 有注入风险
	 * @param sql
	 * @return
	 */
	public Boolean insert(String sql) {
		boolean temp=false;
		Connection conn=null;
		Statement stmt=null;
		try {
			conn =Tools.getConn();
		    stmt = conn.createStatement();
			if(stmt.executeUpdate(sql)>0){
				temp=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Tools.CloseSource(conn, stmt, null);
		}
		return temp;
	}
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
			pt.setString(1, params[0]);
			pt.setString(2, params[1]);
			pt.setString(3, params[2]);
			
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
	 * 无参数查询
	 * @param sql
	 * @return
	 */
	public List<UserInfo> queryUsers(String sql) {
		Connection conn = Tools.getConn();
		Statement stmt=null;
		List<UserInfo> uInfos=new ArrayList<UserInfo>();
	    try {
	    	stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        int col = rs.getMetaData().getColumnCount();
	        
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	            	UserInfo userInfo=new UserInfo();
	            	userInfo.setUserName(rs.getString("username"));
	            	userInfo.setPassWord(rs.getString("password"));
	            	uInfos.add(userInfo);
	             }   
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return uInfos;
	}
	/***
	 * 有参查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<UserInfo> queryUsers(String sql,String[] params) {
		
		Connection conn = Tools.getConn();
		PreparedStatement pt = null; 
		List<UserInfo> uInfos=new ArrayList<UserInfo>();
	    try {
	    	pt=conn.prepareStatement(sql);
	    	for (int i = 0; i < params.length; i++) {
	    		pt.setString(i+1, params[i]);
			}
	        ResultSet rs = pt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	            	UserInfo userInfo=new UserInfo();
	            	userInfo.setUserName(rs.getString("username"));
	            	userInfo.setPassWord(rs.getString("password"));
	            	uInfos.add(userInfo);
	             }   
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return uInfos;
	}
}
