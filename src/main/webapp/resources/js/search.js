$(document).ready(function() {
	$('input.gtm_search_bar').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	    	var key=$(this).val();
	    	window.location="/HiBookTLCN/search?q="+key;
	    }
	});
	let searchParams = new URLSearchParams(window.location.search)
	var type='';
	var key='';
	var page;
	if(searchParams.get('type')){
		type=searchParams.get('type');
	}if(searchParams.get('q')){
		key=searchParams.get('q');
	}if(searchParams.get('page')){
		page=searchParams.get('page');
	}
	
	$.ajax({
    	type : "GET",
    	url : "api/typebook"
    }).then(function(data) {
    	var type = '';    	
    	$.each(data, function (i, item) {	 	
    		type+='<div class="chiller_cb"><a href="/HiBookTLCN/search?q='+key+'&type='+item.idType+'"><label >'+item.nameType+'</label></a></div>';
        });
    	$('.bg').append(type); 
	});
	var list_data;
	if(window.location.href.indexOf("search") > -1){
		 $.ajax({
		    	type : "GET",
		    	url : "/HiBookTLCN/api/search",
		    	data:{
		    		q:key,
		    		type:type
		    	}
		    }).then(function(data) {
		    	var sp_search='';
				var linkHref=window.location.href;
				if(page==null||page==1){
					page=1;
					linkHref+='&page=1';
				}
		    	loaddata(data, linkHref);
		    });
	}else if(window.location.href.indexOf("booknew") > -1){
		 $.ajax({
		    	type : "GET",
		    	url : "/HiBookTLCN/api/booknew"
		    }).then(function(data) {
		    	var sp_search='';
				var linkHref=window.location.href;
				if(page==null||page==1){
					page=1;
					linkHref+='?page=1';
				}
		    	loaddata(data,linkHref);
		    });
	}else if(window.location.href.indexOf("bookssold") > -1){
		$.ajax({
	    	type : "GET",
	    	url : "/HiBookTLCN/api/bookssold"
	    }).then(function(data) {
	    	var sp_search='';
			var linkHref=window.location.href;
			if(page==null||page==1){
				page=1;
				linkHref+='?page=1';
			}
	    	loaddata(data,linkHref);
	    });
	}
	
	function loaddata(data, linkHref){
		var sp_search='';
				
		/* div page*/
		var page_button='<li class="disabled"><a href="#">«</a></li>';
		var number_page=data.length/8;
		for(var i=0;i<number_page;i++){
			var newurl=linkHref.replace("page="+page, "page="+(i+1));
			if(page==(i+1)){
				page_button+='<li class="active"><a data-page="'+(i+1)+'" href="'+newurl+'">'+(i+1)+' <span class="sr-only">(current)</span></a></li>'
			}else{
				page_button+='<li><a data-page="'+(i+1)+'" href="'+newurl+'">'+(i+1)+' <span class="sr-only">(current)</span></a></li>'
			}
		}
		page_button+='<li><a href="#">»</a></li>';
		$('.pagination').append(page_button);
		
		$.each(data, function (i, item) {
			
			var tacgia='';
			if(null!=item.authors){
				tacgia=item.authors[0].nameAuthor;
			}
			if((page*9-9)<=i && i<page*9)
			{
				sp_search+='<div class="col-sm-6 col-md-4 " style="margin-bottom: 20px;"><div class="sanpham"><div class="thumbnail entry">'+
				'<a href="/HiBookTLCN/detail/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center">'+
				'<img src="/HiBookTLCN/resources/images/book/'+item.picBook+'" alt="Nature"></div></a></div>'+
				'<div class="h"><span id="NameSP">'+item.nameBook+'</span><br /><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+
				tacgia+' </span><br /> <span style="color: black; padding: 10px; font-size: 14px;">'+Math.round(item.price*(1-item.discount/100))+'đ</span><span '+
				'style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+item.price+'đ</del></span>'+
				'<span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">-'+item.discount+'%</span><br />'+
				'</div></div></div>';
			}
	    });
		
		$('#list_search').append(sp_search);
	}
});