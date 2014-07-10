$.getScript("resources/json.min.js", function(){
	var categoriesRest = "http://localhost:8080/SimsGotMadSkills/rest/category";
	
	$('#addCategory').click(function(){
		var jsonData = {name:$("#categoryName").val()};
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

});
