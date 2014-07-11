$.getScript("resources/json.min.js", function(){
	var skillsRest = "http://localhost:8080/SimsGotMadSkills/rest/skills";
	$('#submitSkill').click(function(){
		var skillsCategory ={id:$("#skillCategory").val()};
		jsonData = {name:$("#skillName").val(),  category:skillsCategory};
		alert(JSON.stringify(jsonData));
		$.ajax({
			  type: "POST",
			  url: skillsRest,
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
		splitId = this.id.split("-");
		switch(splitId[0]) {
	    case "editBtn": 	
	        editSkill(splitId);
	        break;
	    case "submitBtn":
	    	submitSkill(splitId);
	        break;
	    case "deleteBtn":
	    	deleteSkill(splitId);
	    	break;
	    default:
	        alert(splitId[0]);
	    
	}
	});
	
	function editSkill(splitId){
		//get the name of the category
		var name = document.getElementById("name-".concat(splitId[1])).innerHTML;
		//set the name of the category into a input box
		document.getElementById("name-".concat(splitId[1])).innerHTML = '<input type = text id = "inputName-'.concat(splitId[1]).concat('" value ="'.concat(name).concat('"/>'));
		//get the categoryName
		var categoryId = document.getElementById('categoryName-'.concat(splitId[1])).title;
		//Remove parentName text and replace with a dropdown box
		$('#categoryName-'.concat(splitId[1])).empty();
		$('#skillCategory').clone().attr({'id':'skillCategoryNameSelect-'.concat(splitId[1])}).appendTo('#categoryName-'.concat(splitId[1]));
		//Set inital value to that of its original parent
		$("#skillCategoryNameSelect-".concat(splitId[1])).val(categoryId);
		//Remove edit button
		$("#editBtn-".concat(splitId[1])).remove();
		//Create submit button

		//Add submit button to table
		$("#submitBtn-".concat(splitId[1])).show();
		$("#deleteBtn-".concat(splitId[1])).show();
	}
	function submitSkill(splitId){
		var jsonData;
		var categoryData ={id:$("#skillCategoryNameSelect-".concat(splitId[1])).val()};
		jsonData = {id:splitId[1], name:$("#inputName-".concat(splitId[1])).val(),  category:categoryData};

		alert(JSON.stringify(jsonData));
		$.ajax({
			  type: "PUT",
			  url: skillsRest.concat("/").concat(splitId[1]),
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
	function deleteSkill(splitId){
		$.ajax({
			  type: "DELETE",
			  url: skillsRest.concat("/").concat(splitId[1]),
			  contentType: "application/json",
			  success: function(data){
				  location.reload();
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	}
	
});