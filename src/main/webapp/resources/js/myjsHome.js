
$(document).ready(function(){
    // When the user clicks anywhere outside of the modal, close it
    $("#btnClose").click(function(){
        $("#idLogin").hide();
    });
    $("#btnCancel").click(function(){
        $("#idLogin").hide();
    });
    $("#btnClose1").click(function(){
        $("#idCreate").hide();
    });
    $("#btnCancel1").click(function(){
        $("#idCreate").hide();
    });
    $("#nutDN").click(function(){
        if(document.getElementById('idCreate').style.display=='block')
            document.getElementById('idCreate').style.display='none';
        $("#idLogin").show();
    });
    $("#nutDK").click(function(){
        if(document.getElementById('idLogin').style.display=='block')
            document.getElementById('idLogin').style.display='none';
        $("#idCreate").show();
    });
    //
    //
    //
    if($(".btn-top").length > 0){
        $(window).scroll(function () {
            var e = $(window).scrollTop();
            if (e > 300) {
                $(".btn-top").show()
            } else {
                $(".btn-top").hide()
            }
        });
        $(".btn-top").click(function () {
            $('body,html').animate({
                scrollTop: 0
            })
        })
    }   
    //
    //validate login
    //
        //ẩn các thông báo
        $("#username_error").hide();
        $("#password_error").hide();
        $("#username1_error").hide();
        $("#password0_error").hide();
        $("#email_error").hide();
        $("#password1_error").hide();
        var error_username = false;
        var error_password = false;
        var error_username1 = false;
        var error_password0 = false;
        var error_email = false;
        var error_password1 = false;
        
        $("#username").focusout(function() {

            check_username();
        });
        $("#password").focusout(function() {

            check_password();
        });
         $("#username1").focusout(function() {

            check_username1();
        });
        $("#password0").focusout(function() {

            check_password0();
        });
        $("#password1").focusout(function() {

            check_password1();
        });
        $("#email").focusout(function() {

            check_email();
        });

        function check_username() {
        
            var username_length = $("#username").val().length;
            if($("#username").val()=="")
            {
                $("#username_error").html("Không được để trống!!!");
                $("#username_error").show(); 
                //$("#username_error").css("color","red");
                error_username = true;
            }
            else {
                $("#username_error").hide();
            }
        
        }
        
        function check_password() {
        
            var password_length = $("#password").val().length;
            
            if($("#password").val()=="")
            {
                $("#password_error").html("Không được để trống!!!");
                $("#password_error").show();
                //$("#password_error").css("color","red");
                error_password = true;
            }
            else if(password_length < 8) {
                $("#password_error").html("Mật khẩu phải lớn hơn 8 kí tự");
                $("#password_error").show();
                error_password = true;
            } else {
                $("#password_error").hide();
            }
        }
        function check_username1() {
        
            var username_length = $("#username1").val().length;
            if($("#username1").val()=="")
            {
                $("#username1_error").html("Không được để trống!!!");
                $("#username1_error").show(); 
                error_username1 = true;
            }
            else {
                $("#username1_error").hide();
            }
        
        }
        
        function check_password0() {
        
            var password_length = $("#password0").val().length;
            
            if($("#password0").val()=="")
            {
                $("#password0_error").html("Không được để trống!!!");
                $("#password0_error").show();
                error_password0 = true;
            }
            else if(password_length < 6) {
                $("#password0_error").html("Mật khẩu phải lớn hơn 5 kí tự");
                $("#password0_error").show();
                error_password0 = true;
            } else {
                $("#password0_error").hide();
            }
        }
        function check_password1() {
        
            var password_length = $("#password1").val().length;

            if($("#password1").val()!=$("#password0").val()) {
                $("#password1_error").html("Mật khẩu nhập lại phải khớp với mật khẩu trên");
                $("#password1_error").show();
                error_password1 = true;
            } else {
                $("#password1_error").hide();
            }
        }

        function check_email() {

            var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
        
            if(pattern.test($("#email").val())) {
                $("#email_error").hide();
            } else {
                $("#email_error").html("Hãy nhập địa chỉ email!");
                $("#email_error").show();
                error_email = true;
            }
        
        }
        $("#btnDangNhap").click(function() {
                                                
            var error_username = false;
            var error_password = false;
                                                
            check_username();
            check_password();
            
            if(error_username == false && error_password == false) {
                return true;
            } else {
                return false;   
            }
        });
        $("#btnDangKy").click(function() {
                                                
            var error_username1 = false;
            var error_password0 = false;
            var error_email = false;
            var error_password1 = false;
                                                
            check_username1();
            check_password0();
            check_password1();
            check_email();
            
            if(error_username1 == false && error_password0 == false && error_email == false && error_password1 == false) {
                return true;
            } else {
                return false;   
            }
        });
        
});

