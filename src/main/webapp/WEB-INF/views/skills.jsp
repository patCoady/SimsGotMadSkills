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
			<th>Name</th>
			<th>Category</th>
		</tr>
		<c:forEach items="${skills}" var="skill">
			<tr>
				<td id = "name-${skill.id}">${skill.name}</td>
				<td id = "categoryName-${skill.id}" title = "${skill.category.id}">${skill.category.name}</td>
				<td>
					<button id = "editBtn-${skill.id}">Edit</button>
					<button id = "submitBtn-${skill.id}" style = "display: none;">Submit</button>
					<button id = "deleteBtn-${skill.id}" style = "display: none;"> Delete</button>
				</td>
			</tr>
		</c:forEach>
	</table>



	<input type="text" id="skillName" />
	<select id="skillCategory">
		<c:forEach items="${categories}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
	</select>
	<button id="submitSkill">Submit</button>
</body>
</html>