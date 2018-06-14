package com.yongwei.service;

import java.util.List;

import com.yongwei.entity.ArticleTypeEntity;

public interface ArticleTypeService {
	
	public List<ArticleTypeEntity> findAllFirstArticleType();
	
	public ArticleTypeEntity findFirstArticleTypeByCode(String firstArticleTypeCode);
	
	public List<ArticleTypeEntity> findAllSecondArticleType(String firstArticleTypeCode);
	
}
