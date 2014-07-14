<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.4.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/employeeRest.js" />"></script>
</head>
<body>
	<h1>Employees!</h1>
	<table>
		<tr>
			<th>Name</th><th>Email</th><th>Skype Name</th> <th>Skills</th>
		</tr>
		<c:forEach items = "${employees}" var = "employee">
			<tr>
				<td id = "name-${employee.id}">${employee.firstName} ${employee.lastName}</td>
				<td id = "email-${employee.id}">${employee.email }</td>
				<td id = "skype-${employee.id}">${employee.skypeName }</td>
				<td> 
				<select id = "selectSkills-${employee.id}" style = "display: none;" >
					<c:forEach items = "${skills}" var ="skill">
						<option>${skill.name}</option>
					</c:forEach>
				</select>
				<div id = "showSkills-${employee.id}">
					<c:forEach items = "${employee.skills}" var ="empSkill">
						${empSkill.skill.name }
					</c:forEach>
				</div>
				</td>
				<td>
					<button id ="editBtn-${employee.id}">Edit</button>
					<button id = "editSkillsBtn-${employee.id}">Add Skills</button>
					<button id ="submitBtn-${employee.id}" style = "display: none;">Submit</button>
					<button id ="deleteBtn-${employee.id}" style = "display: none;">Delete</button>
					
					<button id = "submitSkillsBtn-${employee.id}" style = "display: none;">Add Skill</button>
				</td>
			</tr>
		</c:forEach>		
	</table>
	
	<div>
		<label>First</label>
		<input type = "text" id = "employeeFistName"/>
		<label>Last</label>
		<input type = "text" id = "employeeLastName"/>
		<label>Email</label>
		<input type = "text" id = "employeeEmail"/>
		<label>Skype</label>
		<input type = "text" id = "employeeSkypeName"/>
	</div>
	<button id = "addEmployee">Add Employee</button>
</body>
</html>