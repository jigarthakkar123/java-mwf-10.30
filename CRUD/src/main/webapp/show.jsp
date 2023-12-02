<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" cellpadding="10px" cellspacing="10px" border="1">
	<tr>
		<th>UID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Address</th>
		<th>Gender</th>
		<th>Password</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	
		<%
			List<User> list=EmployeeDao.getAllUser();
				for(User u:list)
				{
			%>
		<tr>
			<td><%=u.getUid() %></td>
			<td><%=u.getFname() %></td>
			<td><%=u.getLname() %></td>
			<td><%=u.getEmail() %></td>
			<td><%=u.getMobile() %></td>
			<td><%=u.getAddress() %></td>
			<td><%=u.getGender() %></td>
			<td><%=u.getPassword() %></td>
			<td>
				<form name="edit" method="post" action="UserController">
					<input type="hidden" name="uid" value="<%=u.getUid()%>">
					<input type="submit" name="action" value="EDIT" class="btn btn-primary">
				</form>
			</td>
			<td>
				<form name="delete" method="post" action="UserController">
					<input type="hidden" name="uid" value="<%=u.getUid()%>">
					<input type="submit" name="action" value="DELETE" class="btn btn-danger">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	
</table>
<a href="insert.jsp">INSERT USER</a>
</body>
</html>