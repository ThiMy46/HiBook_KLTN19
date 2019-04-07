$(document).ready(function() {
	$("#birthday").datepicker();
	var idUser= $('#myTabContent').data('id');
	
	$('#btn_LuuInfo').click(function(){
		var nameUser=$('#nameUser').val();
    	var numberphone=$('#numberphone').val();
    	var email=$('.profile-usertitle-job').text();
    	var password='';
    	var sex=$('.radio input:checked').val();
    	var birthday=$('#birthday').datepicker('getDate');
    	var formatted = (birthday.getMonth() + 1)+"/"+birthday.getDate()+"/"+birthday.getFullYear();
    	var address=$('#address').val();
		$.ajax({
			url : "/HiBookTLCN/api/user/"+idUser,
	    	type : "PUT",
	    	data:JSON.stringify({
	    		nameUser:nameUser,
	    		numberphone:numberphone,
	    		email:email,
	    		password:password,
	    		sex:sex,
	    		birthday:formatted,
	    		address:address
	    	}),
	    	headers: {
        	      'Accept': 'application/json',
        	      'Content-Type': 'application/json'
        	},
	    	success : function(data) {
	    		alert("Chỉnh sửa thành công!!!");
	    		window.location = '/HiBookTLCN/user_update/'+idUser;
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
	});
	$('#btn_LuuPass').click(function(){
		var old=$('#passwordold').val();
		var pass=$('#passwordnew').val();
		var pass1=$('#passwordagain').val();
		if(pass==pass1){
			$.ajax({
				url : "/HiBookTLCN/api/user/"+idUser,
		    	type : "POST",
		    	data:{
		    		old:old,
		    		passnew:pass
		    	},
		    	success : function(data) {
		    		if(data==1){
		    			alert("Đổi mật khẩu thành công!!!");
		    		}else if(data==-1){
		    			alert("Mật khẩu cũ không chính xác!!!");
		    		}
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
			alert("Nhập lại mật khẩu mới không trùng nhau!");
		}
	});
	

});