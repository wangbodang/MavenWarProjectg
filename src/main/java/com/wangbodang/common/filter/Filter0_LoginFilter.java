package com.wangbodang.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="loginFilter", urlPatterns= {"/*"})
public class Filter0_LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("--->loginFilter");
		HttpServletRequest httpReq = (HttpServletRequest)request;
		String fullUri = httpReq.getRequestURI();
		//System.out.println("--->请求URI为:"+fullUri);
		String uri = fullUri.substring(fullUri.lastIndexOf("/")+1);
		//测试过滤器转发
		if("fook".equals(uri)) {
			request.getRequestDispatcher("/WEB-INF/jsp/fook.jsp").forward(request, response);
			//chain.doFilter(request, response);
			//return;
		}		
		if("login".equals(uri) || "confirm".equals(uri) ) {
			//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			request.setAttribute("errorMsg", "未登陆或密码错误");
			chain.doFilter(request, response);
		}else if("error".equals(uri)){
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			//chain.doFilter(request, response);
		}else if(fullUri.endsWith(".css") || fullUri.endsWith(".js") || fullUri.endsWith(".jpg")){
			chain.doFilter(request, response);
		}else {
			boolean login = false;
			Cookie[] cookies = httpReq.getCookies();
			for(Cookie cookie:cookies) {
				if("userid".equals(cookie.getName())) {
					login = true;
				}
			}
			if(login) {
				System.out.println("--->登陆, 转到下一个过惉器");
				chain.doFilter(request, response);
			}else {
				System.out.println("--->未登陆, 转到登陆页面");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}				
		System.out.println("--->到此不doFilter");		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
