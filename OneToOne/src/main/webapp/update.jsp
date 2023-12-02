<%@page import="com.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<%
	Employee e=(Employee)request.getAttribute("e");
%>
<body>
<form method="post" action="EmployeeController" name="frm">
	<input type="hidden" name="eid" value="<%=e.getEid()%>">
	<input type="hidden" name="epid" value="<%=e.getEpinfo().getEpid()%>">
	<table>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname"  value="<%=e.getEpinfo().getFname()%>"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname"  value="<%=e.getEpinfo().getLname()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"  value="<%=e.getEpinfo().getEmail()%>"></td>
			<td><span id="email"></span></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea rows="5" cols="22" name="address"><%=e.getEpinfo().getAddress() %></textarea></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><input type="text" name="mobile"  value="<%=e.getEpinfo().getMobile()%>"></td>
			<td><span id="mobile"></span></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><input type="text" name="uname"  value="<%=e.getUname()%>"></td>
		</tr>
		<tr>
			<td>Department Name</td>
			<td><input type="text" name="dname"  value="<%=e.getDname()%>"></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"  value="<%=e.getSalary()%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Update" class="btn btn-secondary">
			</td>
		</tr>
	</table>
</form>
</body>
</html>