package com.yongwei.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.yongwei.dao.UserDao;
import com.yongwei.entity.LoginEntity;
import com.yongwei.entity.UserEntity;
import com.yongwei.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public User register(User user) {
		
		return null;
	}

	@Override
	public List<LoginEntity> login(String loginName, String password) {
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("loginName", "\""+loginName+"\"");
		parameters.put("password", "\""+password+"\"");
		return sqlSessionTemplate.selectList("UserDao.login", parameters);
	}
	
	

}
