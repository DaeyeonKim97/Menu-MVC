package com.dykim.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.CategoryDTO;
import com.dykim.mvc.model.service.MenuService;

/**
 * Servlet implementation class SelectAllCategoryServlet
 */
@WebServlet("/category-list")
public class SelectAllCategoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		List<CategoryDTO> categoryList = menuService.selectAllCategory();
		
		
		String path ="";
		if(categoryList!=null) {
			path = "/WEB-INF/views/menu/categoryList.jsp";
			request.setAttribute("categoryList", categoryList);
		}
		else 
		{
			path = "/WEB-INF/common/errorPage.jsp";
			request.setAttribute("message", "카테고리 목록 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);;
	}
}
