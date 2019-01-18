package com.wangbodang.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="mainCotroller", urlPatterns= {"/index", "/login"}, loadOnStartup=1)
public class MainControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fullUri = req.getRequestURI();
		System.out.println("--->请求URI为:"+fullUri);
		String uri = fullUri.substring(fullUri.lastIndexOf("/")+1);
		String dispatcherUri = "/WEB-INF/jsp/login.jsp";
		if("login".equals(uri)) {
			dispatcherUri = "/WEB-INF/jsp/login.jsp";
		}else if("index".equals(uri)) {
			dispatcherUri = "/WEB-INF/jsp/index.jsp";
		}		
		req.getRequestDispatcher(dispatcherUri).forward(req, res);
		
		
	}
	

}
