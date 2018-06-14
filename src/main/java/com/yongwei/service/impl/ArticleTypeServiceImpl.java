package com.yongwei.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yongwei.dao.ArticleTypeDao;
import com.yongwei.entity.ArticleTypeEntity;
import com.yongwei.service.ArticleTypeService;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService{

	@Resource
	ArticleTypeDao articleTypeDao;

	public List<ArticleTypeEntity> findAllFirstArticleType() {
		return articleTypeDao.findAllFirstArticleType();
	}

	public ArticleTypeEntity findFirstArticleTypeByCode(String firstArticleTypeCode) {
		return articleTypeDao.findFirstArticleTypeByCode(firstArticleTypeCode);
	}

	public List<ArticleTypeEntity> findAllSecondArticleType(String firstArticleTypeCode) {
		return articleTypeDao.findAllSecondArticleType(firstArticleTypeCode);
	}

}
