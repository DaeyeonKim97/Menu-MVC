package com.dykim.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.service.MenuService;

@WebServlet("/updateMenu")
public class UpdateMenuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price")) ;
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode")) ;
		String orderableStatus = request.getParameter("orderableStatus");
		
		boolean result = true;
		String path = "";
		
		try {
			result = menuService.updateMenu(new MenuDTO(code,name,price,categoryCode,orderableStatus));
		} catch (Exception e) {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "카테고리 코드가 존재하지 않아 메뉴 수정에 실패했습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		if(result) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "updateMenu");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "해당 메뉴코드의 메뉴가 존재하지 않아 수정에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
