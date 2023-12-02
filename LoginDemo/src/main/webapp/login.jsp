<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(request.getAttribute("msg")!=null)
	{
		out.println(request.getAttribute("msg"));
	}
%>
<form name="login" method="post" action="LoginServlet">
	<table cellpadding="10px" cellspaing="10px">
		<tr>
			<td>EMail</td>
			<td><input type="text" name="email">
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password">
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Login">
			</td>
		</tr>
	</table>
</form>
</body>
</html>