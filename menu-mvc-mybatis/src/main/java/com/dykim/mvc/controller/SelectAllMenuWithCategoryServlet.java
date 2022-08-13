package com.dykim.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.MenuAndCategoryDTO;
import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;


@WebServlet("/detail-list")
public class SelectAllMenuWithCategoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		List<MenuAndCategoryDTO> menuDetailList = menuService.selectAllMenuWithCategory();
		
		String path="";
		
		if(menuDetailList != null) {
			path = "/WEB-INF/views/menu/menuDetailList.jsp";
			request.setAttribute("menuDetailList", menuDetailList);
		} else {
			path = "/WEB-INF/common/errorPage.jsp";
			request.setAttribute("message", "메뉴&카테고리 목록 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
