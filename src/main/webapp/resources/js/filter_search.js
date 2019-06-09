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
		edit_listbook(search);
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
		edit_listbook(search);
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
		$("#list_search").empty();
		var sp_search='';
		$.each(filter_search, function (i, item) {
			if(i<6)
			{
				sp_search+='<div class="col-sm-6 col-md-4 " style="margin-bottom: 20px;"><div class="sanpham"><div class="thumbnail entry">'
					+'<a href="/HiBook_KLTN19/detail-book/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center">'
					+'<img src="/HiBook_KLTN19/resources/images/book/'+item.picBook+'" alt="Nature"></div></a>'
					+'</div><div class="h"><span id="NameSP">'+item.nameBook+'</span><br /><span style="color: #8a8787; padding: 10px; font-size: 14px;">';
				$.each(item.authors, function (i, author) {
					sp_search += author.nameAuthor+" ";
				});
				sp_search+='</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+Math.round(item.price*(1-item.discount/100))+'đ</span>'
					+'<span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+item.price+'đ</del></span>'
					+'<span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">-'+item.discount+'%</span><br /></div></div></div>';
			}

	    });
		$("#list_search").append(sp_search);
		
		
		$(".pagination").empty();
		
		var page_button='<li class="disabled"><a href="#">«</a></li>';
		var number_page = 1;
		if(filter_search.length>5){
			number_page = filter_search.length/6;
		}
		for(var i=0 ; i<number_page ; i++){
			var newurl = window.location.href.replace("page=1", "page="+(i+1));
			if((i+1)==1){
				page_button+='<li class="active"><a data-page="'+(i+1)+'" href="'+newurl+'">'+(i+1)+' <span class="sr-only">(current)</span></a></li>'
			}else{
				page_button+='<li ><a data-page="'+(i+1)+'" href="'+newurl+'">'+(i+1)+' <span class="sr-only">(current)</span></a></li>'
			}
		}
		page_button+='<li><a href="#">»</a></li>';
		$('.pagination').append(page_button);
	}

});