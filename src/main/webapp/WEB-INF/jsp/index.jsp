<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String cookieUsername = "";
	Cookie[] cookies = request.getCookies();
	for(Cookie c:cookies){
		if("username".equals(c.getName())){
			cookieUsername = c.getValue();
		}
	}
	String contextPath = request.getContextPath();	
%>
<c:set var="ctxPath" scope="page" value="<%=contextPath %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${ctxPath}/css/common.css" rel="stylesheet" type="text/css"  />
<title>Insert title here</title>
</head>

<body>
	<h3>Index Page</h3>
	<div style="float:right;"> | <span>Cookie Username:<%=cookieUsername %></span></div>
	<hr style="display:block;"/>
	<p>WELCOME : <span>${userName} </span></p>
	<p>This page is index page!</p>
	<p>
		<c:forEach items="${textList }" var="line">
			<span>${line }</span><br/>
		</c:forEach>
	</p>
	<div>
		<table>
			<tr>
				<td><span class="redText">This text should be red!!!</span></td>
				<td>ttt</td>
			</tr>
			<tr>
				<td>xxx</td>
				<td>ttt</td>
			</tr>
		</table>
	</div>
</body>
</html>