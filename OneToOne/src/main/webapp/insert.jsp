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
<form method="post" action="EmployeeController" name="frm">
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
			<td><span id="email"></span></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea rows="5" cols="22" name="address"></textarea></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><input type="text" name="mobile"></td>
			<td><span id="mobile"></span></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>Department Name</td>
			<td><input type="text" name="dname"></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert" class="btn btn-secondary">
			</td>
		</tr>
	</table>
</form>
<a href="show.jsp">Show All User</a>
</body>
</html>