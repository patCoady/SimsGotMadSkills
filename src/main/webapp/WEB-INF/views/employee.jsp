<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<h1>Employees!</h1>
	<table>
		<tr>
			<th>Name</th><th>Email</th><th>Skype Name</th>
		</tr>
		<c:forEach items = "${employees}" var = "employee">
			<tr>
				<td>${employee.firstName}  ${employee.lastName}</td>
				<td>${employee.email }</td>
				<td>${employee.skypeName }</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>