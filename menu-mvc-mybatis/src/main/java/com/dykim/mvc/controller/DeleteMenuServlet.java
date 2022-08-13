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
 * Servlet implementation class DeleteMenuServlet
 */
@WebServlet("/deleteMenu")
public class DeleteMenuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		boolean result = menuService.deleteMenu(code);
		
		String path = "";
		if(result) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "deleteMenu");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "해당 메뉴 코드가 존재하지 않아 삭제에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
