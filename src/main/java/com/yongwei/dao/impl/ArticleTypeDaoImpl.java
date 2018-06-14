package com.yongwei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yongwei.dao.ArticleTypeDao;
import com.yongwei.entity.ArticleTypeEntity;

@Repository
public class ArticleTypeDaoImpl implements ArticleTypeDao{

	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ArticleTypeEntity> findAllFirstArticleType() {
		return sqlSessionTemplate.selectList("ArticleTypeDao.findAllFirstArticleType");
	}

	public ArticleTypeEntity findFirstArticleTypeByCode(String firstArticleTypeCode) {
		return sqlSessionTemplate.selectOne("ArticleTypeDao.findFirstArticleTypeByCode",firstArticleTypeCode);
	}

	public List<ArticleTypeEntity> findAllSecondArticleType(String firstArticleTypeCode) {
		return sqlSessionTemplate.selectList("ArticleTypeDao.findAllSecondArticleType",firstArticleTypeCode);
	}

}
