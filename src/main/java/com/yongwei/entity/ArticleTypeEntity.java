package com.yongwei.entity;

import org.apache.ibatis.type.Alias;

@Alias(value="ArticleTypeEntity")
public class ArticleTypeEntity {
	private String code;
	private String name;
	private String remark;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
