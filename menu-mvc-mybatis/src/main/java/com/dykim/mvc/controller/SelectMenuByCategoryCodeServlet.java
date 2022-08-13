package com.dykim.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.CategoryAndMenuDTO;
import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;

@WebServlet("/categoryCode")
public class SelectMenuByCategoryCodeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		CategoryAndMenuDTO categoryWithMenu = menuService.selectMenuByCategoryCode(categoryCode);
		
		String path ="";
		if(categoryWithMenu!=null) {
				path = "/WEB-INF/views/menu/categoryMenuList.jsp";
				request.setAttribute("categoryWithMenu", categoryWithMenu);
			
		}
		else 
		{
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "해당 카테고리가 존재하지 않거나 해당 카테고리에 메뉴가 존재하지 않습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
