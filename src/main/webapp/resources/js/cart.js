$(document).ready(function() {
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idSach = vars[vars.length - 1];
	
	GanTongTien();
	function GanTongTien(isEventChange) {
		var tongtiensp = 0;
		$(".totalmoney").each(
				function(i, price) {
					var giatiensp = $(this).closest("tr").find(
					".giatien").attr("data-price");
					var soluong = $(this).closest("tr").find(
					".soluong").attr("data-num");

					var giatien = soluong * giatiensp;
					tongtiensp = tongtiensp + giatien;
					if (!isEventChange) {
						$(this).html(
								"<span>" + giatien + " VND"
								+ "</span>");

					}

					$("#totalall").html(
							"<h5>" + "<strong>" + "Tổng Tiền: "
							+ tongtiensp + " VND"
							+ "</strong>" + "</h5>");

				})

	}
	$(".soluong_giohang").change(
			function() {
				var soluong1 = $(this).val();
				$(this).closest("tr").find(".soluong").attr("data-num",soluong1);


				var email = $("#getemail1").attr("data-toggle1");
				var giatiensp1 = $(this).closest("tr").find(
				".giatien").attr("data-price");
				var tongtien1 = soluong1 * giatiensp1;
				$(this).closest("tr").find(".totalmoney").html(
						"<span>" + tongtien1 + " VND"
						+ "</span>");											
				GanTongTien(true);	
				var idCart= $(this).closest("tr").find( "#getIdCart").attr("data-idCart");
				$.ajax({
					url:"/HiBookTLCN/api/capnhatsoluong/"+ idSach,
					type:"GET",
					data:{
						idCart:idCart,
						soluong:soluong1
					},
					success: function(value){


					}
				})

			});


	$(".deletecart").click(function() {
		//alert("không xóa");
		var seft=$(this);
		var idCart= $(this).closest("tr").find(
		"#getIdCart").attr("data-idCart");
		$.ajax({
			url:"/HiBookTLCN/api/xoagiohang/",
			data :{
				idCart:idCart,

			},

			type:"GET",
			success: function(value){
				alert("Xóa Thành Công");
				seft.closest("tr").remove();
				GanTongTien();
				var value = $(".giohang_circle").find("span").text();
				value--;
				$(".giohang_circle").find("span").text(value);	 
			}
		})


	});
});