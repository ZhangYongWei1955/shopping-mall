package com.yongwei.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yongwei.entity.ArticleEntity;
import com.yongwei.entity.ArticleTypeEntity;
import com.yongwei.entity.LoginEntity;
import com.yongwei.pojo.User;
import com.yongwei.service.ArticleService;
import com.yongwei.service.ArticleTypeService;
import com.yongwei.service.UserService;

@Controller
public class PageController {

	@Resource
	UserService userService;
	
	@Resource
	ArticleService as;
	
	@Resource
	ArticleTypeService ats;
	
	
	@RequestMapping(value= {"register.do","register.action","register.jsp"})
	public String getRegisterPage(User user,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		return "register";
	}
	
	@RequestMapping(value={"login.do","login.jsp"})
	public String getLoginPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		
		return "login";
	}
	
	@RequestMapping(value="login.action")
	public String loginFrom(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String loginName = request.getParameter("loginName").trim();
		String password = request.getParameter("password").trim();
		
		System.out.println("name: "+loginName+"  password: "+password);
		
		if(loginName == null || loginName.equals("") || password == null || password.equals("")) {
			return "redirect:/login.do";
		}else {
			List<LoginEntity> ln = userService.login(loginName, password);
			
			System.out.println(ln.size());
			
			if(ln.size() == 1) {
				return "redirect:/index.do";
			}else {
				System.out.println("redirect:/login.do");
				return "redirect:/login.do";
			}
		}	
	}
	
	
	
}
