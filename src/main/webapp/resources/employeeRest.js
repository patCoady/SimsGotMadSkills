$.getScript("resources/json.min.js", function(){
	var employeeRest = "http://localhost:8080/SimsGotMadSkills/rest/employee";
	$('#addEmployee').click(function(){
		jsonData = {firstName:$("#employeeFistName").val(), lastName:$("#employeeLastName").val(), email:$("#employeeEmail").val(), skypeName:$("#employeeSkypeName").val(),  };
		alert(JSON.stringify(jsonData));
		$.ajax({
			  type: "POST",
			  url: employeeRest,
			  data: JSON.stringify(jsonData),
			  contentType: "application/json",
			  success: function(data){
				  location.reload();
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	
	});
	
	$("button").click(function(){
		var splitId = this.id.split("-");
		
		switch(splitId[0]){
			case "editBtn":
				editEmployee(splitId);
				break;
			case "submitBtn":
				updateEmployee(splitId);
				break;
			case "deleteBtn":
				deleteEmployee(splitId);
				break;
			case "editSkillsBtn":
				editSkills(splitId);
				break;
			case "submitSkillsBtn":
				submitSkills(splitId);
				break;
			default:
				alert("default");
				
		}
	});
	
	
	function editEmployee(splitId){
		//get the name of the empoyee
		var name = document.getElementById("name-".concat(splitId[1])).innerHTML;
		var email = document.getElementById("email-".concat(splitId[1])).innerHTML;
		var skype = document.getElementById("skype-".concat(splitId[1])).innerHTML;
		
		//set the name of the category into a input box
		document.getElementById("name-".concat(splitId[1])).innerHTML = '<input type = text id = "inputName-'.concat(splitId[1]).concat('" value ="'.concat(name).concat('"/>'));
		document.getElementById("email-".concat(splitId[1])).innerHTML = '<input type = text id = "inputEmail-'.concat(splitId[1]).concat('" value ="'.concat(email).concat('"/>'));
		document.getElementById("skype-".concat(splitId[1])).innerHTML = '<input type = text id = "inputSkype-'.concat(splitId[1]).concat('" value ="'.concat(skype).concat('"/>'));
		
		//Remove edit button
		$("#editBtn-".concat(splitId[1])).remove();
		$("#editSkillsBtn-".concat(splitId[1])).remove();
		//Create submit button
		//Add submit button to table
		$("#submitBtn-".concat(splitId[1])).show();
		$("#deleteBtn-".concat(splitId[1])).show();
	}
	function updateEmployee(splitId){
		var jsonData;
		
		jsonData = {id:splitId[1], firstName:$("#inputName-".concat(splitId[1])).val().split(" ")[0], lastName:$("#inputName-".concat(splitId[1])).val().split(" ")[1],  
				email:$("#inputEmail-".concat(splitId[1])).val(), skypeName:$("#inputSkype-".concat(splitId[1])).val()};
		$.ajax({
			  type: "PUT",
			  url: employeeRest.concat("/").concat(splitId[1]),
			  data: JSON.stringify(jsonData),
			  contentType: "application/json",
			  success: function(data){
				  location.reload();
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	}
	function deleteEmployee(splitId){
		$.ajax({
			  type: "DELETE",
			  url: employeeRest.concat("/").concat(splitId[1]),
			  contentType: "application/json",
			  success: function(data){
				  location.reload();
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	}
	
	function editSkills(splitId){
		$("#editBtn-".concat(splitId[1])).remove();
		$("#editSkillsBtn-".concat(splitId[1])).remove();
		//$("#showSkills-".concat(splitId[1])).remove();
		
		$("#submitSkillsBtn-".concat(splitId[1])).show();
		$("#selectSkills-".concat(splitId[1])).show();
	}
	function submitSkills(splitId){
		var skillId = {id: $("#selectSkills-".concat(splitId[1])).val()};
		var employeeId = {id: splitId[1]};
		jsonData = {skill: skillId, employee: employeeId};
		$.ajax({
			  type: "POST",
			  url: employeeRest.concat("/skills/"),
			  data: JSON.stringify(jsonData),
			  contentType: "application/json",
			  success: function(data){
				  location.reload();
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
	});
	};
	
	
	
	
});