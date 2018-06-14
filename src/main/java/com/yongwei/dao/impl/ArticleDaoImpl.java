package com.yongwei.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.yongwei.dao.ArticleDao;
import com.yongwei.entity.ArticleEntity;

@Repository
public class ArticleDaoImpl implements ArticleDao{

	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ArticleEntity> findByCodeAndKeyWord(String keyword, String typecode) {
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("keyword", "%"+((keyword != null )?keyword:"")+"%");
		parameters.put("typecode","%"+typecode+"%");
		return sqlSessionTemplate.selectList("ArticleDao.findByCodeAndKeyWord",parameters);
	}

	public ArticleEntity findById(String id) {
		return sqlSessionTemplate.selectOne("ArticleDao.findById",id);
	}

}
