<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categorizzz</title>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.4.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/getRest.js" />"></script>
</head>
<body>
	<table>
		<tr>
			<th>Category</th>
			<th>Parent Category</th>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
					<td id ="name-${category.id}">${category.name}</td>
					<td id ="parentName-${category.id}" title = "${category.parentCategory.id}">${category.parentCategory.name}</td>
					<td id = "buttonSpot-${category.id}">
						<button id ="editButton-${category.id}">Edit</button>
						<button id ="submitButton-${category.id}" style = "display: none;">Submit</button>
						<button id ="deleteButton-${category.id}" style = "display: none;">Delete</button>
					</td>
					
			</tr>
		</c:forEach>
		
	</table>
	<div id ="test"></div>
	<!-- value ="${category.id}" -->
	<input type="text" id="categoryName" />
	<select id="parentCategory">
		<option value="noParent">...</option>

		<c:forEach items="${categories}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
	</select>
	<button id="addCategory">Submit</button>
</body>
</html>