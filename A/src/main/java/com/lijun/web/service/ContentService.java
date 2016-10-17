package com.lijun.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lijun.web.model.ContentInfo;
import com.lijun.web.utils.Tools;

public class ContentService {

	/**
	 * 内容查询
	 * 
	 * @param sql
	 * @return
	 */
	public List<ContentInfo> queryContent(String sql) {
		Connection conn = Tools.getConn();
		Statement stmt = null;
		List<ContentInfo> cInfos = new ArrayList<ContentInfo>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ContentInfo contentInfo = new ContentInfo();
				contentInfo.setContent(rs.getString("content"));
				contentInfo.setTitle(rs.getString("title"));
				contentInfo.setCreateTime(rs.getString("createTime"));
				contentInfo.setBySomeOne(rs.getString("bySomeone"));
				cInfos.add(contentInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cInfos;
	}

	public Boolean insert(String sql, String[] params) {
		boolean temp = false;
		Connection conn = null;
		PreparedStatement pt = null;
		try {
			conn = Tools.getConn();
			pt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pt.setString(i+1,params[i]);
			}
			if (pt.executeUpdate() > 0) {
				temp = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Tools.CloseSource(conn, null, pt);
		}
		return temp;
	}
}
