$.getScript("resources/json.min.js", function(){
	var categoriesRest = "http://localhost:8080/SimsGotMadSkills/rest/category";
	$('#addCategory').click(function(){
		var jsonData;
		if($("#parentCategory").val() != "noParent"){
			var parentData ={id:$("#parentCategory").val()};
			jsonData = {name:$("#categoryName").val(),  parentCategory:parentData};
		}
		else{
			jsonData = {name:$("#categoryName").val()};
		}	
		/*alert(JSON.stringify(jsonData));*/
		$.ajax({
			  type: "POST",
			  url: categoriesRest,
			  data: JSON.stringify(jsonData),
			  contentType: "application/json",
			  success: function(data){
				  //alert(data);\
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	});
	

	$("button").click(function() {
		//Split the id of the button
		var splitId = this.id.split("-");
		//Check if edit or submit button were selected
		if(splitId[0] == "editButton"){
			edit(splitId);
		}else if(splitId[0]=="submitButton"){
			submit(splitId);
		}else if(splitId[0]=="deleteButton"){
			deleteCategory(splitId)
		}
	});
	
	
	function edit(splitId){
		//get the name of the category
		var name = document.getElementById("name-".concat(splitId[1])).innerHTML;
		//set the name of the category into a input box
		document.getElementById("name-".concat(splitId[1])).innerHTML = '<input type = text id = "inputName-'.concat(splitId[1]).concat('" value ="'.concat(name).concat('"/>'));
		//get the parentId
		var parentId = document.getElementById('parentName-'.concat(splitId[1])).title;
		//Remove parentName text and replace with a dropdown box
		$('#parentName-'.concat(splitId[1])).empty();
		$('#parentCategory').clone().attr({'id':'parentNameSelect-'.concat(splitId[1])}).appendTo('#parentName-'.concat(splitId[1]));
		//Set inital value to that of its original parent
		$("#parentNameSelect-".concat(splitId[1])).val(parentId);
		//Remove edit button
		$("#editButton-".concat(splitId[1])).remove();
		//Create submit button

		//Add submit button to table
		$("#submitButton-".concat(splitId[1])).show();
		$("#deleteButton-".concat(splitId[1])).show();
	}
	
	function submit(splitId){
		var jsonData;
		if($("#parentNameSelect-".concat(splitId[1])).val() != "noParent"){
			var parentData ={id:$("#parentNameSelect-".concat(splitId[1])).val()};
			jsonData = {id:splitId[1], name:$("#inputName-".concat(splitId[1])).val(),  parentCategory:parentData};
		}
		else{
			 jsonData = {id:splitId[1], name:$("#inputName-".concat(splitId[1])).val()};
		}	
		alert(JSON.stringify(jsonData));
		$.ajax({
			  type: "PUT",
			  url: categoriesRest.concat("/").concat(splitId[1]),
			  data: JSON.stringify(jsonData),
			  contentType: "application/json",
			  success: function(data){
				  //alert(data);\
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
	}
	function deleteCategory(splitId){
		alert("wow");
		$.ajax({
			  type: "DELETE",
			  url: categoriesRest.concat("/").concat(splitId[1]),
			  contentType: "application/json",
			  success: function(data){
				  //alert(data);\
				  },
			  failure: function(errMsg) {
			        alert(errMsg);
			    }
		
			});
		
	}

});
