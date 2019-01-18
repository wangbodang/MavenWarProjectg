package com.wangbodang.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="mainCotroller", urlPatterns= {"/index", "/aoo"}, loadOnStartup=1)
public class MainControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("--->请求URI为:"+uri);
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, res);
	}
	

}
