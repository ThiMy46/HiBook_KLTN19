$(document).ready(function() {

	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idSach = vars[vars.length - 1];
	var gia = 0;
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/books/" + idSach
	}).then(function(data) { 
				if(data.quantity < 1){
					$('#btn-purchase').html('<i class="fas fa-ban"></i> Hết sách');
				}
				$('.item-photo').append(
						'<img style="max-width:100%;" src="../resources/images/book/'
						+ data.picBook + '" />');
				$('#tensach').text(data.nameBook);
				$('#tensach').attr('data-type',data.typebook.idType);
				$('#giaban').text(data.price * (100 - data.discount) / 100 + " đ");
				$('#giamgia').text(data.discount + "%");
				$('#giagoc small').text("Giá bìa: "+ data.price+ " đ");
				gia = data.price;
				$('#tab_default_1').append('<p style="font-weight: bold;">'
						+ data.nameBook+ '</p><p>'+ data.introBook+ '</p>');
				$('#table_chitiet')
				.append('<tbody><tr>'
						+ '<th style="width: 25%">Công ty phát hành</th><td><a href="#">'
						+ data.supplier.nameSupplier + '</a></td>'
						+ '</tr><tr><th>Tác giả</th><td><a id="tacgia1" href="#"></a></td>'
						+ '</tr><tr><th >Nhà xuất bản</th><td>'
						+ data.publisher + '</td></tr>'
						+ '<tr><th >Ngày xuất bản</th><td>'
						+ data.publicationDate + '</td></tr>'
						+ '<tr><th >Kích thước</th><td>'
						+ data.size + '</td></tr>'
						+ '<tr><th >Số trang</th><td>'
						+ data.numberPage + '</td></tr>'
						+ '<tr><th >Loại bìa</th><td>'
						+ data.cover + '</td></tr></tbody>');
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
				$.each(data.userreviews,function(i, item) {
					var start = "";
					for (var st = 0; st < item.star; st++) {
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
				/*Get book same type */
				var idType=$('#tensach').data('type');
				$.ajax({
					type : "GET",
					url : "/HiBook_KLTN19/api/v1/search-by-type",
					data:{
						type:idType
					}
				}).then(function(data) {
					var sp1='';
					var sp2='';
					$.each(data,function(i, item) {
						if(i<4){
							sp1+='<div class="col-xs-3 col-sm-3"><a href="/HiBook_KLTN19/detail-book/'+item.idBook+'" class="thumbnail">'
								+'<img src="/HiBook_KLTN19/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
						}else if(i>3&&i<8){
							sp2+='<div class="col-xs-3 col-sm-3"><a href="/HiBook_KLTN19/detail-book/'+item.idBook+'" class="thumbnail">'
								+'<img src="/HiBook_KLTN19/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
						}
					});
					if(data.length <= 4){
						//$('#Carousel').						
						$("a.left").remove();
						$("a.right").remove();
						$('#Carousel').carousel('pause');
					}
					$('#sp_type1').append(sp1);
					$('#sp_type2').append(sp2);
				});
			});

	$("#TryRead").click(function () { 
		var file=$('#TryRead a').data('value');
		if(file==null)
		{

		}else{$("#frame").attr("src", '/HiBook_KLTN19/resources/images/file/'+file);}
	});
	
	//click buy book (*)
	$("#btn-purchase").click(function() {
		
		var amount = $("#get-quantity").val();
		var quantity = $(".section > div > input").val();
		$.ajax({
			url : "/HiBook_KLTN19/api/v1/numCart/" + idSach,
			type : "GET",
			data : {
				price : gia,
				amount : amount
			},
			success : function(data) {
				if(data != -1) {
					alert("Đã thêm vào giỏ!");
					$(".giohang_circle").find("span").text(data);
				}
				else{
					alert("Bạn vui lòng đăng nhập trước để mua hàng!!!");
				}
			}
		});
	});
});
