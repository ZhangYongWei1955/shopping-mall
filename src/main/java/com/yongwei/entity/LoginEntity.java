package com.yongwei.entity;

import org.apache.ibatis.type.Alias;

@Alias(value="LoginEntity")
public class LoginEntity {

	private int id;
	private String loginName;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
