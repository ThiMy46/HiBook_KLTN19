$(document).ready(function getlistaddbook() {
	
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idBook = vars[vars.length-1];
	var them=true;
	var hinh;
	var docthu;
	/* Get Type Book*/
    $.ajax({
    	type : "GET",
    	url : "/HiBookTLCN/api/typebook"
    }).then(function(data) {
    	var type = '<option value="0">Please select</option>';    	
    	$.each(data, function (i, item) {	 	
    		type+='<option value="'+item.idType+'">'+item.nameType+'</option>';
        });
    	$('#idType').append(type);
 	    
    });
    /* Get Supplier Book*/
    $.ajax({
    	type : "GET",
    	url : "/HiBookTLCN/api/supplier"
    }).then(function(data) {
    	var sup = '<option value="0">Please select</option>';    	
    	$.each(data, function (i, item) {	 	
    		sup+='<option data-id="'+item.idSupplier+'">'+item.nameSupplier+'</option>';
        });
    	$('#idSupplier').append(sup);
 	    
    });
    /* Get Author Book*/
    $.ajax({
    	type : "GET",
    	url : "/HiBookTLCN/api/author"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		auth+='<option data-id="'+item.idAuthor+'" value="'+item.nameAuthor+'">'+item.nameAuthor+'</option>';
        });
    	$('select#idAuthor').append(auth);
    });
    
    if(idBook!=''&&idBook!='add-book'){
		$.ajax({
	    	type : "GET",
	    	url : "/HiBookTLCN/api/book/"+idBook
	    }).then(function(data) {
	       $('#nameBook').val(data.nameBook);
	 	   $('#price').val(data.price);
	 	   $('#discount').val(data.discount);
	 	   $('#publisher').val(data.publisher);
	 	   $('#size').val(data.size);
	 	   $('#numberPage').val(data.numberPage);
	 	   $('#publicationDate').val(data.publicationDate);
	 	   $('#quantity').val(data.quantity);
	 	   $('.radio input:checked').val(data.cover);
	 	  if(data.cover=='Bìa mềm'){
	    		$('.radio input:radio[name=cover][id="radio1"]').attr('checked', true);
	    		$('.radio input:radio[name=cover][id="radio2"]').attr('checked', false);
	    	}else{
	    		$('.radio input:radio[name=cover][id="radio2"]').attr('checked', true);
	    		$('.radio input:radio[name=cover][id="radio1"]').attr('checked', false);
	    	}
	 	   $('#intro').val(data.intro);
	 	  hinh=data.fileimg;
	 	  docthu=data.fileproofread;
	 	 $("#idType option[value='" + data.idType +"']").attr("selected","selected");
	 	   $("#idSupplier option[data-id='" + data.idSupplier +"']").attr("selected","selected");
	 	   var arr1=data.arr_author;
	 	   var add='';
	 	   for(var i=0; i< arr1.length;i++){
	 		  /*var name=$('#idAuthor > option[data-id='+arr1[i]+']').text();*/
	 		  add+='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
	  		    '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
	  		    '<strong data-id="'+arr1[i]+'">'+data.arr_nameauthor[i]+'</strong></div>';
	   		   arr[arr.length]=arr1[i];
	 	   }
	 	   $('#arr_author').append(add);
	    });
		them=false;
	}
    
    /*Upload Img*/
    var imgfiles =[];
    $('#file-multiple-img').change(function(event){
    	$('#progressBarImg').text('0%');
    	$('#progressBarImg').css('width','0%');
    	imgfiles = event.target.files;
    	forms=new FormData();
    	forms.append("file", imgfiles[0]);
    	$.ajax({
        	type : "POST",
        	url : "/HiBookTLCN/api/upload-img",
        	data: forms,
        	contentType: false,
        	processData: false,
        	enctype: "multipart/form-data",
        	xhr: function(){
                //Get XmlHttpRequest object
                 var xhr = $.ajaxSettings.xhr() ;
                
                //Set onprogress event handler 
                 xhr.upload.onprogress = function(event){
                  	var perc = Math.round((event.loaded / event.total) * 100);
                  	$('#progressBarImg').text(perc + '%');
                  	$('#progressBarImg').css('width',perc + '%');
                 };
                 return xhr ;
            	}
        }).then(function(data) {
        	$('#file-multiple-img').text(data);
     	    
        });
    });
    var files =[];
    $('#file-multiple-proofread').change(function(event){
    	$('#progressBarFile').text('0%');
    	$('#progressBarFile').css('width','0%');
    	files = event.target.files;
    	forms=new FormData();
    	forms.append("file", files[0]);
    	$.ajax({
        	type : "POST",
        	url : "/HiBookTLCN/api/upload-img",
        	data: forms,
        	contentType: false,
        	processData: false,
        	enctype: "multipart/form-data",
        	xhr: function(){
                //Get XmlHttpRequest object
                 var xhr = $.ajaxSettings.xhr() ;
                
                //Set onprogress event handler 
                 xhr.upload.onprogress = function(event){
                  	var perc = Math.round((event.loaded / event.total) * 100);
                  	$('#progressBarFile').text(perc + '%');
                  	$('#progressBarFile').css('width',perc + '%');
                 };
                 return xhr ;
            	}
        }).then(function(data) {
        	$('#file-multiple-proofread').text(data);
        });
    });
   $("#reset_book").click(function(){
	   $('#progressBarFile').text('0%');
   		$('#progressBarFile').css('width','0%');
   		$('#progressBarImg').text('0%');
		$('#progressBarImg').css('width','0%');
   });
   var arr=[];
   $('#idAuthor').change(function(){
	   var optionSelected = $("option:selected", this);
       var valueSelected = this.value;
       var id=$("#idAuthor option:selected").data('id');
      /* $("#idAuthor option:selected").hide();
       var add = '<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
  		    '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
  		    '<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
   		   arr[arr.length]=id; */
      var add='';
       if(arr.length==0){
    	   add='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
  		    '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
  		    '<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
   		   arr[arr.length]=id; 
       }else{
    	   var flag=0;
    	   $.each(arr, function(i,item){
        	   if(item==id){
        		   flag=1;
        	   }
           })
           if(flag==0){
        	   add='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
      		    '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
      		    '<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
       		   arr[arr.length]=id;
           }
       }
       
	   $('#arr_author').append(add);
   });
   $('#arr_author').on('click', 'a.close',function(){
	   var id=$(this).parent('div').find('strong').data('id');
	  alert(id);
	   $.each(arr, function(i,item){
    	   if(item==id){
    		   arr[i]=arr[arr.length-1];
    		   arr.length--;
    	   }
       })
   });
   $('#submit_book').click(function(){
	   var nameBook=$('#nameBook').val();
	   var price=$('#price').val();
	   var discount=$('#discount').val();
	   var publisher=$('#publisher').val();
	   var size=$('#size').val();
	   var numberPage=$('#numberPage').val();
	   var publicationDate=$('#publicationDate').val();
	   var quantity=$('#quantity').val();
	   var cover= $('.radio input:radio[name=cover][checked="checked"]').val();
	   var intro=$('#intro').val();
	   var idType= $('#idType option:selected').val();
	   var idSup= $('#idSupplier option:selected').data('id');
	   var file_img=$('#file-multiple-img').text();
	   var file_proofread=$('#file-multiple-proofread').text();
	   
	   if(them){
		   
		   $.ajax({
	       	url : "/HiBookTLCN/api/book",
	       	type : "POST",
	       	data:{
	       		publisher:publisher,
	      		nameBook:nameBook,
	      		price:price,
	      		discount:discount,
	      		size:size,
	      		numberPage:numberPage,
	      		publicationDate:publicationDate,
	      		quantity:quantity,
	      		cover:cover,
	      		intro:intro,
	      		fileimg:file_img,
	      		fileproofread:file_proofread,
	      		idType:idType,
	      		idSupplier:idSup,
	       		arr_author:arr
	       	},
	       	success : function(data) {
	               alert('thêm thành công!');
	               window.location = '/HiBookTLCN/admin-book';
	       },
	    	statusCode: {
	    	    404: function() {
	    	      alert('404 page not found');
	    	    },
	
	    	    400: function() {
	    	       alert('400 bad request');
	    	   }
	    	}
	       });
	   }else{
		   if(file_img==''){
			   file_img=hinh;
		   }
		   if(file_proofread=='')
		   {
			   file_proofread=docthu;
		   }
		  
		   $.ajax({
		       	url : "/HiBookTLCN/api/book/"+idBook,
		       	type : "PUT",
		       	data:JSON.stringify({
		       		publisher:publisher,
		      		nameBook:nameBook,
		      		price:price,
		      		discount:discount,
		      		size:size,
		      		numberPage:numberPage,
		      		publicationDate:publicationDate,
		      		quantity:quantity,
		      		cover:cover,
		      		intro:intro,
		      		fileimg:file_img,
		      		fileproofread:file_proofread,
		      		idType:idType,
		      		idSupplier:idSup,
		       		arr_author:arr
		       	}),
		       	headers: {
	        	      'Accept': 'application/json',
	        	      'Content-Type': 'application/json'
	        	},
		       	success: function(data) {
		               alert('update thành công!');
		               window.location = '/HiBookTLCN/admin-book';
		       },
		    	statusCode: {
		    	    404: function() {
		    	      alert('404 page not found');
		    	    },
		
		    	    400: function() {
		    	       alert('400 bad request');
		    	   }
		    	}
		       });
	   }
   });
});
    

