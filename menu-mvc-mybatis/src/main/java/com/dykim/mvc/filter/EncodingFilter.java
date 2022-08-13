package com.dykim.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


public class EncodingFilter extends HttpFilter implements Filter {
	
	private String encodingType;
       
	@Override
	public void init(FilterConfig config) {

		encodingType = config.getInitParameter("encoding-type");

	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)

			throws IOException, ServletException {

		
		String method = ((HttpServletRequest) request).getMethod();

		
		if("POST".equals(method)) {

			request.setCharacterEncoding(encodingType);

		}

		
		chain.doFilter(request, response);

	}


}
