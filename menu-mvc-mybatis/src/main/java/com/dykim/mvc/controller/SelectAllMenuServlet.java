package com.dykim.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;

/**
 * Servlet implementation class SelectAllMenuServlet
 */
@WebServlet("/list")
public class SelectAllMenuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MenuService menuService = new MenuService();
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		String path="";
		
		if(menuList != null) {
			path = "/WEB-INF/views/menu/menuList.jsp";
			request.setAttribute("menuList", menuList);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "메뉴 목록 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
