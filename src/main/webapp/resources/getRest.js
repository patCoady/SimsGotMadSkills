$.getScript("resources/json.min.js", function(){
	var categoriesRest = "http://localhost:8080/SimGotMadSkills/rest";
	$('#restTest').click(function() {
		alert("woo");
		$.ajax({
			type : "GET",
			dataType : "charset=utf-8", 
			url : categoriesRest,
			success : function(data) {
				alert(data);
				//$("#googleBooksData").val(data);
			}
		});
	});

});
