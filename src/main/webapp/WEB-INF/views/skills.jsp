<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mad Skillz</title>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.4.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/skillRest.js" />"></script>
</head>
<body>
	<h1>Some Mad Skillz</h1>
	<table>
		<tr>
			<th>Name</th> <th>Category</th>
		</tr>
		<c:forEach items = "${skills}" var = "skill">
			<tr>
				<td>${skill.name}</td>
				<td>${skill.category.name}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<input type = "text" id = "newSkill"/>
	<button id = "submitSkill">Submit</button>
</body>
</html>