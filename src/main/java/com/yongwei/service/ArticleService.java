package com.yongwei.service;

import java.util.List;

import com.yongwei.entity.ArticleEntity;

public interface ArticleService {
	
	public List<ArticleEntity> findByCodeAndKeyWord(String keyword, String typecode);
	
	public ArticleEntity findById(String id);
}
