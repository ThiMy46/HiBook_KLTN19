$(document).ready(function() {
	
	var idUser= $('#table_bill').data('id');
	$.ajax({
		url : "/HiBookTLCN/api/bill/user/"+idUser,
		type : "GET"
	}).then(function(data) {
		var row='';
		$.each(data,function(i, item) {
			row+='<tr> <th scope="row"><a href="#" class="idBill">'+item.idBill+'</a></th>'+
			     '<td>'+item.dateCreate+'</td> <td></td>'+
			      '<td>'+item.total+'</td><td data-status="'+item.idStatus+'">'+item.nameStatus+'</td></tr>';
		});
		$('#table_bill tbody').append(row);	
	});
	$('#table_bill tbody').on( 'click', 'a.idBill', function () {
		$('#table_sp tbody').html('');
		$('#modalDetail').modal('toggle');
		$('.modal-backdrop').css("display","none");
		var idBill=$(this).closest("tr").find('.idBill').text();
		$.ajax({
			url : "/HiBookTLCN/api/bill/"+idBill,
			type : "GET"
		}).then(function(data) {
			var row='';
			$('.nguoinhan').text(data.nameReceiver);
			$('.numberphone').text(data.numberphone);
			$('.address').text(data.deliveryAdress);
			$.each(data.detailBillDTOs,function(i, item) {
				row+='<tr> <th scope="row">'+item.book.nameBook+'</th>'+
				     '<td>'+item.quantityBuy+'</td> '+
				      '<td>'+item.price+'</td><td >'+(item.quantityBuy*item.price)+'</td></tr>';
			});
			$('#table_sp tbody').append(row);
			$('.payment').text(data.namePayment);
			$('.status').text(data.nameStatus);
			$('.transport').text(data.nameTransport);
		});
	})

});