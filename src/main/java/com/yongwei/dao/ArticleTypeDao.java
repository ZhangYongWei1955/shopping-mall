package com.yongwei.dao;

import java.util.List;

import com.yongwei.entity.ArticleTypeEntity;

public interface ArticleTypeDao {
	
	public List<ArticleTypeEntity> findAllFirstArticleType();
	
	public ArticleTypeEntity findFirstArticleTypeByCode(String firstArticleTypeCode);
	
	public List<ArticleTypeEntity> findAllSecondArticleType(String firstArticleTypeCode);
	
}
