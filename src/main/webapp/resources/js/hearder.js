$(document).ready(function() {
	/*===============Chung nhiều trang================================MUCH Using menu*/
	$('input.gtm_search_bar').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	    	var key=$(this).val();
	    	window.location="/HiBookTLCN/search?q="+key;
	    }
	});
	 $.ajax({
	    	type : "GET",
	    	url : "/HiBookTLCN/api/typebook"
	    }).then(function(data) {
	    	var type = '';    	
	    	$.each(data, function (i, item) {	 	
	    		type+='<li><a href="/HiBookTLCN/search?type='+item.idType+'"><i class="fas fa-book"></i> '+item.nameType+'</a></li>';
	        });
	    	$('#typeBook').append(type); 
	});
		getThongbao();
		function getThongbao(isEventChange) {
			$(".getthongbao").each(
					function() {
						$.ajax({
							url : "/HiBookTLCN/detail1/",
							type : "GET",
							success : function(data) {
								if (data != null) {
									// alert(data);
									// $(".getthongbao").html(data);
									$("#giohanghome").find("span")
									.text(data);
								}
							}

						})

					});

		}
});