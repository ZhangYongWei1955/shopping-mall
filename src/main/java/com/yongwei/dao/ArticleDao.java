package com.yongwei.dao;

import java.util.List;

import com.yongwei.entity.ArticleEntity;

public interface ArticleDao {
	
	public List<ArticleEntity> findByCodeAndKeyWord(String keyword, String typecode);
	
	public ArticleEntity findById(String id);
}
