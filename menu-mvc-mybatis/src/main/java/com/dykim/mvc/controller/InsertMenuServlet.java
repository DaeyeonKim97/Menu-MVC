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
		
		boolean result = menuService.insertMenu(new MenuDTO(0,name,price,categoryCode,orderableStatus));
		
		String path = "";
		if(result) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "InsertMenu");
		} else {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("message", "메뉴 추가 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
