package com.yongwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yongwei.dao.*;
import com.yongwei.entity.ArticleEntity;
import com.yongwei.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	ArticleDao articleDao;
	
	public List<ArticleEntity> findByCodeAndKeyWord(String keyword, String typecode) {
		return articleDao.findByCodeAndKeyWord(keyword, typecode);
	}

	public ArticleEntity findById(String id) {
		
		return articleDao.findById(id);
	}

}
