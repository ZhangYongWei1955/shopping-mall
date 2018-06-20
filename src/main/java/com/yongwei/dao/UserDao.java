package com.yongwei.dao;

import java.util.List;

import com.yongwei.entity.LoginEntity;
import com.yongwei.pojo.User;

public interface UserDao {
	
	public User register(User user);
	
	public List<LoginEntity> login(String loginName,String password);
	
}
