$(document).ready(function() {
	
	/*======== Sách bán chạy==========*/
    $.ajax({
    	type : "GET",
    	url : "/HiBookTLCN/api/bookssold"
    }).then(function(data) {
    	var Ltc2 = '';
    	var Ltc3 = '';
    	$.each(data, function (i, item) {
    		if(i<4){
    			Ltc2 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry"><a href="detail/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;"></span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    			
    		}
    		else{
    			Ltc3 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry"><a href="detail/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;"></span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    			
    		}
    		
        });
    	$('#loadtrangchu').append(Ltc2);
    	$('#loadtrangchu1').append(Ltc3);
    });
    /*======Sách mới xuất bản========= */
    $.ajax({
    	type : "GET",
    	url : "/HiBookTLCN/api/booknew"
    }).then(function(data) {
    	var row1 = '';
    	var row2 = '';
    	$.each(data, function (i, item) {
    		if(i<4){
    			row1 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    		}
    		else if(i<8 && i>=4){
    			row2 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    		}
        });
    	$('#booknew0').append(row1);
    	$('#booknew1').append(row2);
    });
});