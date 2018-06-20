package com.yongwei.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yongwei.dao.ArticleDao;
import com.yongwei.entity.ArticleEntity;
import com.yongwei.entity.ArticleTypeEntity;
import com.yongwei.service.*;
import com.yongwei.service.impl.*;

@Controller
public class ArticleController {
	
	@Resource
	ArticleService as;
	
	@Resource
	ArticleTypeService ats;
	
	@RequestMapping(value= {"index.do","/","list.jsp"})
	public String getListPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String typecode = request.getParameter("typecode");
		String keyword = request.getParameter("keyword");
		
		// 查询出所有的一级分类
		List<ArticleTypeEntity> firstArticleTypes = ats.findAllFirstArticleType();
		// 判断typecode是否有值 ，如果没有值则是第一次进入，获取第一个类型
		if (typecode == null || typecode.equals("")) {
			typecode = firstArticleTypes.get(0).getCode();
		}
		// 获取请求的一级物品类型，目的是展示在右边窗口左上角（如点击查询的是二级物品类型，则需截取前四位获取一级物品类型）
		String firstArticleTypeCode = typecode.substring(0, 4);
		ArticleTypeEntity firstArticleType = ats.findFirstArticleTypeByCode(firstArticleTypeCode);
		
		System.out.println("firstArticleTypeCode===" + firstArticleTypeCode);
		System.out.println("firstArticleType==" + firstArticleType);
		
		// 获取请求的一级物品类型下所有的二级物品类型
		List<ArticleTypeEntity> allSecondArticleTypes = ats.findAllSecondArticleType(firstArticleTypeCode);
		System.out.println("allSecondArticleTypes=====" + allSecondArticleTypes);
		
		//根据物品类型和关键字查询所有的商品
		List<ArticleEntity> articles = as.findByCodeAndKeyWord(keyword, typecode);
				
		request.setAttribute("articles", articles);	
		request.setAttribute("typecode", typecode);
		request.setAttribute("keyword", keyword);
		request.setAttribute("allSecondArticleTypes", allSecondArticleTypes);
		request.setAttribute("firstArticleType", firstArticleType);
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		return "list";
	}
	
	@RequestMapping(value="item.do")
	public String getItemPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<ArticleTypeEntity> firstArticletype = ats.findAllFirstArticleType();
		String id = request.getParameter("id");
		ArticleEntity articleEntity = as.findById(id);
		request.setAttribute("article", articleEntity);
		request.setAttribute("firstArticleTypes", firstArticletype);
		return "item";
	}
	
	
	@RequestMapping(value="buy.action")
	public String getBuyPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String typecode = request.getParameter("typecode");

		// 查询出所有的一级分类
		List<ArticleTypeEntity> firstArticleTypes = ats.findAllFirstArticleType();
		// 判断typecode是否有值 ，如果没有值则是第一次进入，获取第一个类型
		if (typecode == null || typecode.equals("")) {
			typecode = firstArticleTypes.get(0).getCode();
		}
		// 获取请求的一级物品类型，目的是展示在右边窗口左上角（如点击查询的是二级物品类型，则需截取前四位获取一级物品类型）
		String firstArticleTypeCode = typecode.substring(0, 4);
		ArticleTypeEntity firstArticleType = ats.findFirstArticleTypeByCode(firstArticleTypeCode);
		request.setAttribute("typecode", typecode);
		request.setAttribute("firstArticleType", firstArticleType);
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		
		
		
		
		return "shopCar";
	}
	
}
