package com.u.spring.mock.web.test;

import javax.servlet.SessionCookieConfig;

public class MockSessionCookieConfig implements SessionCookieConfig {


	private String name;

	private String domain;

	private String path;

	private String comment;

	private boolean httpOnly;

	private boolean secure;

	private int maxAge;


	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setDomain(String domain) {
		this.domain = domain;
	}

	
	public String getDomain() {
		return this.domain;
	}

	
	public void setPath(String path) {
		this.path = path;
	}

	
	public String getPath() {
		return this.path;
	}

	
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public String getComment() {
		return this.comment;
	}

	
	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

	
	public boolean isHttpOnly() {
		return this.httpOnly;
	}

	
	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	
	public boolean isSecure() {
		return this.secure;
	}

	
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	
	public int getMaxAge() {
		return this.maxAge;
	}


}
