$(document).ready(function() {

	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idSach = vars[vars.length - 1];
	var gia = 0;
	$.ajax({
		type : "GET",
		url : "/HiBookTLCN/api/get-detail-book/" + idSach
	}).then(
			function(data) {

				if(data.quantity < 1){
					$('#btn-purchase').html('<i class="fas fa-ban"></i> Hết sách');
				}
				$('.item-photo').append(
						'<img style="max-width:100%;" src="../resources/images/book/'
						+ data.picBook
						+ '" />');
				$('#tensach').text(data.nameBook);
				$('#tensach').attr('data-type',data.typeBook.idType);
				$('#giaban').text(data.price * (100 - data.discount) / 100 + " đ");
				$('#giamgia').text(data.discount + "%");
				$('#giagoc small').text("Giá bìa: "
						+ data.price
						+ " đ");
				gia = data.price;
				$('#tab_default_1').append(
						'<p style="font-weight: bold;">'
						+ data.nameBook
						+ '</p><p>'
						+ data.introBook
						+ '</p>');
				$('#table_chitiet')
				.append(
						'<tbody><tr>'
						+ '<th style="width: 25%">Công ty phát hành</th><td><a href="#">'
						+ data.supplier.nameSupplier
						+ '</a></td>'
						+ '</tr><tr><th>Tác giả</th><td><a id="tacgia1" href="#"></a></td>'
						+ '</tr><tr><th >Nhà xuất bản</th><td>'
						+ data.publisher
						+ '</td></tr>'
						+ '<tr><th >Ngày xuất bản</th><td>'
						+ data.publicationDate
						+ '</td></tr>'
						+ '<tr><th >Kích thước</th><td>'
						+ data.size
						+ '</td></tr>'
						+ '<tr><th >Số trang</th><td>'
						+ data.numberPage
						+ '</td></tr>'
						+ '<tr><th >Loại bìa</th><td>'
						+ data.cover
						+ '</td></tr></tbody>');
				var text_author = "";
				$.each(data.authors, function(i, item) {
					text_author += item.nameAuthor
					+ " ";
				});
				$('#tacgia').text(text_author);
				$('#tacgia1').text(text_author);
				// $('.h').append(trHTML);
				var text_review = "";
				var star_number=0;
				var dem=0;
				$.each(data.userReviews,function(i, item) {
					var st;
					var start = "";
					for (st = 0; st < item.star; st++) {
						start += '<span class="fa fa-star checked"></span>';
					}
					star_number+=item.star;
					dem++;
					text_review += '<h4>' + item.user.nameUser + ' - ' + item.title + '</h4>'
					+ '<div class="stars">' + start + '</div>'
					+ '<p class="review-text">' + item.content + '</p>'
					+ '<small class="review-date">' + item.timeReview + '</small>'
					+ '<a href="#" style="color: #404040; font-weight: 600;"> Báo cáo</a><hr/>';
				});

				$('#TryRead a').data('value',data.proofread);
				$('#mucreview').append(text_review);
				var star_tb=star_number/dem;

				for(var i=0;i<5;i++){
					if(i<star_tb){
						$("#start_tb").text(i+1);
						$('.rating-block').append('<span class="glyphicon glyphicon-star checked"></span>');
					}else{
						$('.rating-block').append('<span class="glyphicon glyphicon-star"></span>');
					}
				}
			});
	$("#btn-purchase").click(function() {

		var email = $(".get-email").attr("data-email");
		var quantity = $(".section > div > input").val();
		$.ajax({
			url : "/HiBookTLCN/api/getnotice/" + idSach,
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

	$("#TryRead").click(function () { 
		var file=$('#TryRead a').data('value');
		if(file==null)
		{

		}else{$("#frame").attr("src", '/HiBookTLCN/resources/images/file/'+file);}
	});
	/*Get book same type */
	var idType=$('#tensach').data('type');
	$.ajax({
		type : "GET",
		url : "/HiBookTLCN/api/search",
		data:{
			q:'',
			type:idType
		}
	}).then(function(data) {
		var sp1='';
		var sp2='';
		$.each(data,function(i, item) {
			if(i<4){
				sp1+='<div class="col-xs-3 col-sm-3"><a href="#" class="thumbnail">'
					+'<img src="/HiBookTLCN/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
			}else if(i>3&&i<8){
				sp2+='<div class="col-xs-3 col-sm-3"><a href="#" class="thumbnail">'
					+'<img src="/HiBookTLCN/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
			}
		});
		$('#sp_type1').append(sp1);
		$('#sp_type2').append(sp2);
	});

});
