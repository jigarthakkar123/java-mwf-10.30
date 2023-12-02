<%@page import="com.bean.Employee"%>
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
		<th>EPID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Address</th>
		<th>EID</th>
		<th>User Name</th>
		<th>Dept Name</th>
		<th>Salary</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	
		<%
			List<Employee> list=EmployeeDao.getAllEmployees();
			for(Employee e:list)
			{
			%>
		<tr>
			<td><%=e.getEpinfo().getEpid() %></td>
			<td><%=e.getEpinfo().getFname() %></td>
			<td><%=e.getEpinfo().getLname() %></td>
			<td><%=e.getEpinfo().getEmail() %></td>
			<td><%=e.getEpinfo().getMobile() %></td>
			<td><%=e.getEpinfo().getAddress() %></td>
			<td><%=e.getEid() %></td>
			<td><%=e.getUname() %></td>
			<td><%=e.getDname() %></td>
			<td><%=e.getSalary() %></td>
			<td>
				<form name="edit" method="post" action="EmployeeController">
					<input type="hidden" name="eid" value="<%=e.getEid()%>">
					<input type="submit" name="action" value="EDIT" class="btn btn-primary">
				</form>
			</td>
			<td>
				<form name="delete" method="post" action="EmployeeController">
					<input type="hidden" name="eid" value="<%=e.getEid()%>">
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