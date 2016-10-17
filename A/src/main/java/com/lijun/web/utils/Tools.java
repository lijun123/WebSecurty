package com.lijun.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

	/***
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
       
        String url = "jdbc:mysql://localhost:3306/websecurity?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
         }catch (Exception e) {
			System.out.println("数据库连接错误！");
		} 
        return conn;
        
	}
	/***
	 * 关闭常用资源
	 * @param conn
	 * @param stmt
	 * @param pt
	 */
	public static void CloseSource(Connection conn,Statement stmt,PreparedStatement pt) {
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(pt!=null){
			try {
				pt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static String getCurrentTime(){
		  Date date=new Date();
		  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return format.format(date);
	}
}
