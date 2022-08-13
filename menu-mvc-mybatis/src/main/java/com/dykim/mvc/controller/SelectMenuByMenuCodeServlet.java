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

@WebServlet("/menuCode")
public class SelectMenuByMenuCodeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		int menuCode = Integer.parseInt(request.getParameter("menuCode"));
		MenuDTO menu = menuService.selectMenuByMenuCode(menuCode);
		
		String path ="";
		if(menu!=null) {
			path = "/WEB-INF/views/menu/menuInfo.jsp";
			request.setAttribute("menu", menu);
		}
		else 
		{
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "해당 메뉴 번호가 존재하지 않습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);;
	}

}
