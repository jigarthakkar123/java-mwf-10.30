<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
tr,td
{
	padding:10px;
}
</style>
</head>
<body>
<%
	if(request.getAttribute("msg")!=null)
	{
		out.println(request.getAttribute("msg"));
	}
%>
<form name="insert" method="post" action="insert">
<table>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="fname"></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lname"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
		
	<tr>
		<td colspan="2" align="center">
			<input type="submit" name="action" value="Insert" class="btn btn-primary">
		</td>
	</tr>
</table>
</form>
<a href="show">Show All Student</a>
</body>
</html>