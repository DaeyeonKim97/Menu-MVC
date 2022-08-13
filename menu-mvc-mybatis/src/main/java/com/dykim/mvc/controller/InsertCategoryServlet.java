package com.dykim.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.CategoryDTO;
import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;

@WebServlet("/insertCategory")
public class InsertCategoryServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		String name = request.getParameter("name");
		Integer refCategoryCode = null;
		if(request.getParameter("refCategoryCode") != "")
			refCategoryCode = Integer.parseInt(request.getParameter("refCategoryCode"));
		
		
		String path = "";
		
		boolean result = true;
		
		try {
			result = menuService.insertCategory(new CategoryDTO(0,name,refCategoryCode));
		} catch ( Exception e ) {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "참조 카테고리 코드가 존재하지 않습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		if(result) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "InsertCategory");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "카테고리 추가 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
