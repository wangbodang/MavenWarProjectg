<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/common.css" rel="stylesheet" type="text/css" /> 
<title>Login Page</title>
</head>
<body>
	<h3>Login</h3>
	<hr/>
	<div>
		<form method="post" action="confirm">
			<table style="width:30%; margin-top:30px; margin-left:30px;">
				<tr>
					<td class="leftTd"><span>username:</span></td>
					<td class="rightTd">
						<input type="text" id="username" name="username" />
					</td>
				</tr>
				<tr>
					<td class="leftTd"><span>password:</span></td>
					<td class="rightTd">
						<input type="text" id="password" name="password" />
					</td>
				</tr>
				<tr>	
					<td class="leftTd"></td>
					<td class="rightTd">
						<input type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>