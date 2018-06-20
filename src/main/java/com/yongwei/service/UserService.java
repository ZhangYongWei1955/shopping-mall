package com.yongwei.service;

import java.util.List;

import com.yongwei.entity.LoginEntity;
import com.yongwei.pojo.User;

public interface UserService {
	
	public void register(User user);
	
	public List<LoginEntity> login(String loginName,String password);
	
}
