<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%
	User u=(User)request.getAttribute("u");
%>
<form method="post" action="UserController" name="frm">
	<table>
		<tr>
			<td><input type="hidden" name="uid" value="<%=u.getUid()%>"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" value="<%=u.getFname()%>"></td>
			<td><span id="fname"></span></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" value="<%=u.getLname()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%=u.getEmail()%>"></td>
			<td><span id="email"></span></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><input type="text" name="mobile" value="<%=u.getMobile()%>"></td>
			<td><span id="mobile"></span></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea rows="5" cols="21" name="address"><%=u.getAddress() %></textarea></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
			<%
				if(u.getGender().equals("male"))
				{
			%>
					<input type="radio" name="gender" value="male" checked="checked">Male
					<input type="radio" name="gender" value="female">Female
			<%		
				}
				else
				{
			%>
					<input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female" checked="checked">Female
			<%		
				}
			%>
				
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value="<%=u.getPassword()%>"></td>
			<td><span id="password"></span></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Update" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>
</body>
</html>