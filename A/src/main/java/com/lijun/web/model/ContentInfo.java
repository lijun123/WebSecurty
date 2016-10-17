package com.lijun.web.model;

import java.sql.Date;

public class ContentInfo {

	private String title;
	private String content;
	private String createTime;
	private String bySomeOne;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBySomeOne() {
		return bySomeOne;
	}
	public void setBySomeOne(String bySomeOne) {
		this.bySomeOne = bySomeOne;
	}
}
