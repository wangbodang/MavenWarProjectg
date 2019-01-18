<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String cookieUsername = "";
	Cookie[] cookies = request.getCookies();
	for(Cookie c:cookies){
		if("username".equals(c.getName())){
			cookieUsername = c.getValue();
		}
	}
%>
<body>
	<h3>Index Page</h3>
	<div style="float:right;"> | <span>Cookie Username:<%=cookieUsername %>></span></div>
	<hr style="display:block;"/>
	<p>WELCOME : <span>${userName} </span></p>
	<p>This page is index page!</p>
</body>
</html>