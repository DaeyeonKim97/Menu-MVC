package com.dykim.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;

/**
 * Servlet implementation class InsertMenuServlet
 */
@WebServlet("/insertMenu")
public class InsertMenuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price")) ;
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode")) ;
		String orderableStatus = request.getParameter("orderableStatus");
		
		String path = "";
		boolean result = true;
		
		try {
			result = menuService.insertMenu(new MenuDTO(0,name,price,categoryCode,orderableStatus));
		} catch (Exception e) {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "존재하지 않는 카테고리 번호입니다.");
			
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		if(result) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "InsertMenu");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "메뉴 추가에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
