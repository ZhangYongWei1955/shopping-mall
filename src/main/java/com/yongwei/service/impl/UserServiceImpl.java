package com.yongwei.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yongwei.dao.UserDao;
import com.yongwei.entity.LoginEntity;
import com.yongwei.pojo.User;
import com.yongwei.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;	
	
	@Override
	public void register(User user) {
		userDao.register(user);
	}

	@Override
	public List<LoginEntity> login(String loginName, String password) {
		return userDao.login(loginName, password);
	}

}
