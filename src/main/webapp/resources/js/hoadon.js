$(document).ready(function() {
	var tongtiensp = 0;
	thongtien();		
	function thongtien(isEventChange){
		$(".tongtien").each(function(i,price) {
			var soluong=$(this).closest("tr").find(".soluong").attr("data-num");
			var giatiensp=$(this).closest("tr").find(".giasp").attr("data-many");
			
			var giatien = soluong * giatiensp;
			tongtiensp = tongtiensp + giatien;
			if (!isEventChange) {
			$(this).html(giatien + " VND");
			}
			$("#tongtienbill").html(tongtiensp + " VND");
		})
	}				
					
	$("button.dathang").click(function() {
		var nameReceiver=$('#nameReceiver').text();
		var numberphone=$('#numberphone').text();
		var dateCreate=$('#dateCreate').text();
		var deliveryAdress=$('#deliveryAdress').text();
		
		var idUser=$('#nameReceiver').data('id');
		var idPayment=$('#payment').data('id');
		var idTransport=$('#transport').data('id');	

		$.ajax({
			url : "/HiBookTLCN/api/bill",
			type : "POST",
			data:{
				nameReceiver:nameReceiver,
				numberphone:numberphone,
				deliveryAdress:deliveryAdress,
				dateCreate:dateCreate,
				total:tongtiensp,
				idUser:idUser,
				idPayment:idPayment,
				idTransport:idTransport
			},
			success : function(data) {
				
				alert("Đặt hàng thành công!");
				window.location ="/HiBookTLCN";
			}

		})

	});
					
});
