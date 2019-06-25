$(document).ready(function getlistbook() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	var mydata;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/promotions"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {
    		auth+='<tr><td class="idBook">'+item.idPromotion+'</td> ' +
                '<td ><a href="#" style="text-decoration: none;" class="namebook font-weight-bold">'+item.titlePromotion+'</a></td>'+
                '<td class="picBook"><img class="card-img-top" src="resources/images/banner/'+item.picPromotion+'"/></td>'+
                '<td class="publicationDate">'+item.timeStart +'</td>'+
                '<td class="quantity">'+item.timeEnd+'</td>'+
                '<td class="price">'+item.picPromotion+'</td>'+
                '<td class="discount">'+item.saleOff+'%'+'</td>'+
                '<td><a href="promotions/'+item.idPromotion+'" class="edit-book btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-book" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
    		
        });
    	mydata=data;
    	$('#list-book').append(auth);
    	table=$('#table-book').DataTable(); 	         
    });
    
    /*click delete*/ 
    $('#table-book tbody ').on( 'click', 'a.delete-book', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idBook').text();
        console.log(id);
        var name=$(this).closest("tr").find('.namebook').text();
        console.log(name);
        var index= table.row( $(this).closest("tr") ).index();
        console.log(index);
        $('#xoa-title').text('Bạn có chắc muốn xóa cuốn: "'+name+'" không?');
        
        deletebook(id, index);
    });
    /* Delete book*/ 
    function deletebook(idPromotion, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-book').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
    			type : "DELETE",
            	url : "api/v1/promotions/"+idPromotion,

            	success : function(data) {
                    table.row(index).remove().draw();
                    mydata.splice(index, 1);
                    alert('xóa thành công!');
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
    }
    
    
   
});