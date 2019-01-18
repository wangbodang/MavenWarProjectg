package com.wangbodang.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="mainCotroller", urlPatterns= {"/index", "/login", "/confirm"}, loadOnStartup=1)
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
		}else if("confirm".equals(uri)) {
			//判断帐号密码
			boolean confirm = false;
			
			System.out.println("->判断帐号密码");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(("wang".equals(username) && "111".equals(password)) ||("xie".equals(username) && "222".equals(password))) {
				confirm = true;
				Cookie userCookie = new Cookie("username", username);
				req.setAttribute("userName", username);
				userCookie.setMaxAge(120);
				res.addCookie(userCookie);
			}
			
			
			if(confirm) {				
				dispatcherUri = "/WEB-INF/jsp/index.jsp";				
			}else {
				System.out.println("->帐号密码错误");
				req.setAttribute("errorMsg", "帐号密码错误");
				dispatcherUri = "/WEB-INF/jsp/error.jsp";
			}
			
		}  		
		req.getRequestDispatcher(dispatcherUri).forward(req, res);
		
		
	}
	

}
