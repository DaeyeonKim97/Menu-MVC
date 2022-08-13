package com.dykim.mvc.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dykim.mvc.model.service.MenuService;


@WebServlet(urlPatterns = {}, loadOnStartup = 1)
public class PreloadingController extends HttpServlet {
	
	public void init() {
		System.out.println("MenuService Preloaded...");
		MenuService menuService = new MenuService();
		menuService.selectAllCategory();
	}

}
