<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Sim Got Mad Skilzzzz
</h1>
<form method = "GET" action = "categories"  name ="categories">
	<button type = "submit">View Categoriez</button>
</form>
<form method ="GET" action ="skills" name = "skills">
	<button type = "submit">View Skillz</button>
</form>


<input type = "text" id = "skillName"/>
<button id ="addSkill">Add Skill</button>
</body>
</html>
