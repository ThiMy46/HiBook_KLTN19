$(document).ready(function() {
	/*===============Chung nhiều trang================================MUCH Using menu*/
	$('input.gtm_search_bar').keyup(function(e){
		if(e.keyCode == 13)
		{
			var key=$(this).val();
			window.location="/HiBook_KLTN19/search?q="+key;
		}
	});
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/typebooks"
	}).then(function(data) {
		var type = '';    	
		$.each(data, function (i, item) {	 	
			type+='<li><a href="/HiBook_KLTN19/search?type='+item.idType+'"><i class="fas fa-book"></i> '+item.nameType+'</a></li>';
		});
		$('#typeBook').append(type); 
	});
	getThongbao();
	function getThongbao(isEventChange) {
		$(".getthongbao").each(
				function() {
					$.ajax({
						url : "/HiBook_KLTN19/detail1/",
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
	$("#btn-purchase").click(function() {

		var email = $(".get-email").attr("data-email");
		var quantity = $(".section > div > input").val();
		$.ajax({
			url : "/HiBook_KLTN19/api/getnotice/" + idSach,
			type : "GET",
			data : {
				email : email,
				price : gia,
			},
			success : function(data) {
				var value = $(".giohang_circle").find("span").text();
				if (data == 0) {
					if(value==''){
						value=1;
					}else{
						value++;
					}
				}
				alert("Đã thêm vào giỏ!");
				$(".giohang_circle").find("span").text(value);
			}
		})
	});
});