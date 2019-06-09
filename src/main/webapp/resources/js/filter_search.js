$(document).ready(function() {
	
	var data_all = [];
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/search_newbooks"
    }).then(function(data) {
    	data_all = data;
    });
	
	var publishers = [];
	var authors = [];
	var supliers = [];
	$("#filter_author input[type='checkbox']").change(function(){
		var current_check = $(this).data('author');
		if ($(this).is(':checked')) {
			authors.push(current_check);
		}else{
			authors = jQuery.grep(authors, function(value) {
			  return value != current_check;
			});
		}
		var search = filter_search(publishers , authors, supliers, data_all);
		edit_listbook(search);
		console.log(search);
		
	});
	
	$("#filter_supplier input[type='checkbox']").change(function(){
		var current_check1 = $(this).data('supplier');
		if ($(this).is(':checked')) {
			supliers.push(current_check1);
		}else{
			supliers = jQuery.grep(supliers, function(value) {
			  return value != current_check1;
			});
		}
		var search = filter_search(publishers , authors, supliers, data_all);
		console.log(search);
		
	});
	
	$("#filter_publisher input[type='checkbox']").change(function(){
		var current_check2 = $(this).data('publisher');
		if ($(this).is(':checked')) {
			 publishers.push(current_check2);
		}else{
			publishers = jQuery.grep(publishers, function(value) {
			  return value != current_check2;
			});
		}
		var search = filter_search(publishers , authors, supliers, data_all);
		console.log(search);
		
	});
	
	function filter_search(publishers , authors, supliers, data_alll){
		var data_all_1 = data_alll;
		if(authors.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in authors) {
					  for (var item_author in item.authors) {
					    if (item.authors[item_author]['nameAuthor'] !== undefined && item.authors[item_author]['nameAuthor'] === authors[value])
					      return true;//
					  }
				  }
			  return false;
			});
		}
		if(publishers.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in publishers) {
				    if (item['publisher'] !== undefined && item['publisher'] === publishers[value])
				      return true;//
				  }
			  return false;
			});
		}
		if(supliers.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in supliers) {
					  for (var item_supplier in item.supplier) {
					    if (item.supplier[item_supplier] !== undefined && item.supplier[item_supplier] === supliers[value])
					      return true;
					  }
				  }
			  return false;
			});
		}
		return data_all_1;
	}
	
	function edit_listbook(filter_search){
		
	}
	
	/*function filterSelection(c) {
	  var x, i;
	  x = document.getElementsByClassName("chiller_cb");
	  if (c == "all") c = "";
	  for (i = 0; i < x.length; i++) {
	    w3RemoveClass(x[i], "show");
	    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
	  }
	}
	function w3AddClass(element, name) {
	  var i, arr1, arr2;
	  arr1 = element.className.split(" ");
	  arr2 = name.split(" ");
	  for (i = 0; i < arr2.length; i++) {
	    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
	  }
	}

	function w3RemoveClass(element, name) {
	  var i, arr1, arr2;
	  arr1 = element.className.split(" ");
	  arr2 = name.split(" ");
	  for (i = 0; i < arr2.length; i++) {
	    while (arr1.indexOf(arr2[i]) > -1) {
	      arr1.splice(arr1.indexOf(arr2[i]), 1);     
	    }
	  }
	  element.className = arr1.join(" ");
	}
	
	// Add active class to the current button (highlight it)
	var btnContainer = document.getElementById("myBtnContainer");
	var btns = btnContainer.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
	  btns[i].addEventListener("click", function(){
	    var current = document.getElementsByClassName("active");
	    current[0].className = current[0].className.replace(" active", "");
	    this.className += " active";
	  });
	}*/

});