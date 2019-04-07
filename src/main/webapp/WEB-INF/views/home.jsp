<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<!--Icon fa-->
    <link rel="stylesheet" href="resources/css/fontawesome-all.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="resources/css/mycssHome.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/animate.css" />
	<link href="https://fonts.googleapis.com/css?family=Open+Sans"
		rel="stylesheet">

</head>
<body>
	<!--
			==============================Hearder====================================
	-->
	<div class="container">
		<header id="header">
			<nav class="navbar .navbar-expand-sm navbar-inverse" data-spy="affix"
				data-offset-top="0">
				<div class="container">
					<div class="navbar-header">
						<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name !=null}">
								<a class="navbar-brand" href="<%=request.getContextPath()%>/"> <img
									style="width: 220px; padding-top: 10px;"
									src="<%=request.getContextPath()%>/resources/images/TC.png" />
								</a>
							</c:when>
							<c:otherwise>
								<a class="navbar-brand" href="<%=request.getContextPath()%>/"> <img
									style="width: 220px; padding-top: 10px;"
									src="<%=request.getContextPath()%>/resources/images/TC.png" />
								</a>
							</c:otherwise>
						</c:choose>

						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>

					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav ">
							<li class="dropdown"><a href="khoahoc.html"
								class="dropdown-toggle" data-toggle="dropdown"> <i
									class="fas fa-th-list"></i> Thể Loại<span class="caret"></span></a>
								<ul class="dropdown-menu" id="typeBook">
									
								</ul>
							</li>
							<!-- form search -->
							<li class="search">
								<div class="header_search">
										<span class="glyphicon glyphicon-search"
											style="width: 18px; height: 18px; margin-right: 9.6px"></span>
									<input class="gtm_search_bar search-bar" name="q"
											placeholder="Tìm kiếm sách ..."
											style="font-family: Open Sans;" type="text">
								</div>
							</li>
						</ul>
						
						<ul class="nav navbar-nav navbar-right"
							style="padding-left: -69px; margin-left: -29px; margin-top: -3px;">
							<c:choose>
								<c:when test="${pageContext.request.userPrincipal.name !=null}">
									<ul class="nav navbar-nav navbar-left" style="margin-top: -7px;">
		
												<li id="giohanghome" class="getthongbao"><a class="nav-link" href="<%=request.getContextPath()%>/loadcart/${getIdUser}">
													<img id="header_logo" alt="logo"
														src="<%=request.getContextPath()%>/resources/images/shopping-cart.png"/>
														<div class="giohang_circle">
															<span></span>
														</div>
														</a>
												</li>
									</ul>
									<li class="dropdown"><a href="khoahoc.html"
										class="dropdown-toggle" data-toggle="dropdown"> 
											<i class="fas fa-user fa-fw text-success"></i> Thông tin <span class="caret"></span></a>
										<ul class="dropdown-menu">


											<li><a class="nav-link" 
												 href="<%=request.getContextPath()%>/info_user/${getIdUser}">
													${pageContext.request.userPrincipal.name}</a></li>
											<li><a class="nav-link" href="<%=request.getContextPath()%>/logout"> Logout</a></li>
										</ul>
									</li>
								</c:when>

							
								<c:otherwise>
									<li><a class="nav-link" id="nutDK" data-toggle="modal">
											Đăng Ký </a></li>
									<li><a class="nav-link" id="nutDN" data-toggle="modal">
											Đăng Nhập </a></li>
								</c:otherwise>
							</c:choose>

						</ul>


					</div>
				</div>
				<!--end container-->
			</nav>
			<!--end nav-->
		</header>
		<!--end header-->
	</div>
	<!--
			==============================Login mờ màn hình====================================
	-->

	<div id="idLogin" class="modal">
		<form class="modal-content animate" action="j_spring_security_login"
			method="post">
			<div class="imgcontainer">
				<span id="btnClose" class="close" title="Close Modal">&times;</span>
				<img src="resources/images/TC.png" alt="Avatar" class="avatar">
			</div>

			<div class="inputcontainer">
				<input type="text" id="username" placeholder="Tên đăng nhập*"
					name="username" required><br />
				<p>
					<span class="error" id="username_error"></span>
				</p>

				<input type="password" id="password" placeholder="Mật khẩu*"
					name="password" required><br />
				<p>
					<span class="error" id="password_error"></span>
				</p>

				<input type="checkbox" checked="checked"> Ghi nhớ<br />
				<button type="submit" id="btnDangNhap" class="submitbtn">Đăng
					nhập</button>
				<br />
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="inputcontainer">
				<button type="button" id="btnCancel" class="cancelbtn">Hủy</button>
				<span class="psw">Quên <a href="#">mật khẩu?</a></span>
			</div>
		</form>
		<!--end form-->
	</div>
	<!--end div login-->
	<!--
			==============================Đăng kí====================================
	-->

	<div id="idCreate" class="modal">
		<form class="modal-content animate" action="<%=request.getContextPath()%>/register" method="post">
			<div class="imgcontainer">
				<span id="btnClose1" class="close" title="Close Modal">&times;</span>
				<img src="resources/images/TC.png" alt="Avatar" class="avatar">
			</div>

			<div class="inputcontainer">
				<input type="text" id="username1" placeholder="Tên người dùng*"
					name="uname" required><br />
				<p>
					<span class="error" id="username1_error"></span>
				</p>

				<input type="password" id="password0" placeholder="Mật khẩu*"
					name="psw" required><br />
				<p>
					<span class="error" id="password0_error"></span>
				</p>
				<input type="password" id="password1"
					placeholder="Nhập lại mật khẩu*" name="rpsw" required><br />
				<p>
					<span class="error" id="password1_error"></span>
				</p>

				<input type="text" id="email" placeholder="Email*" name="email"
					required><br />
				<p>
					<span class="error" id="email_error"></span>
				</p>
				<button type="submit" id="btnDangKy btn-register" class="submitbtn">Đăng
					Ký</button>
				<br />
			</div>
			<div><span>${erro}</span></div>

			<div class="inputcontainer">
				<button type="button" id="btnCancel1" class="cancelbtn">Hủy</button>
			</div>
		</form>
		<!--end form-->
	</div>
	<!--end div login-->
	<!--
		==============================content===================================
	-->
	<!--
	=================================Slider=====================================
	-->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="resources/images/trangchu/p4.png" alt="Hinh slide 1"
					style="width: 100%;">
			</div>

			<div class="item">
				<img src="resources/images/trangchu/P6.png" alt="Hinh slide 2"
					style="width: 100%;">
			</div>

			<div class="item">
				<img src="resources/images/trangchu/P2.png" alt="Hinh slide 3"
					style="width: 100%;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!--
	================================NỘI DUNG=======================
  -->
	<!--
	===========================giới thiệu====================
  -->
	<div class="container-fluid bg-blue">
		<div class="container khung1">
			<div class="row text-center">
				<div class="col-sm-3 col-xs-6 first-box">
					<h1>
						<i class="fas fa-book"></i>
					</h1>
					<h3>Đa thể loại</h3>
					<p>Thể loại đa dạng, nhiều tựa sách</p>
					<br>
				</div>
				<div class="col-sm-3 col-xs-6 second-box">
					<h1>
						<i class="fas fa-shipping-fast"></i>
					</h1>
					<h3>Vận chuyển nhanh</h3>
					<p>Vận chuyển nhanh nhất có thể</p>
					<br>
				</div>
				<div class="col-sm-3 col-xs-6 third-box">
					<h1>
						<i class="fas fa-home"></i>
					</h1>
					<h3>Giao hàng tận nhà</h3>
					<p>Giao tận nơi, kiểm tra hàng khi nhận</p>
					<br>
				</div>
				<div class="col-sm-3 col-xs-6 fourth-box">
					<h1>
						<i class="fas fa-piggy-bank"></i>
					</h1>
					<h3>Tiết kiệm</h3>
					<p>Tiết kiệm đến 40% so với giá thị trường</p>
					<br>
				</div>
			</div>
		</div>
	</div>

	<!--
	========================SÁCH VỪA XUẤT BẢN================
	-->
	<div class="container-fluid" id="courseshome">
		<div class="container khung" style="text-align: center;">
			<div class="gioithieu">
				<h2>
					<i class="fas fa-torah"></i> SÁCH MỚI XUẤT BẢN
				</h2>
				<p class="p_home">Một số sách vừa được xuất bản</p>
			</div>
			<div class="row container wow slideInUp" style="padding-top: 20px" id="booknew0">
				
			</div>
			<div class="row container wow slideInUp" style="padding-top: 20px" id="booknew1">
				
			</div>
			<div style="margin-top: 10px;">
				<button class="btn btn-success btn_xemthem" onclick="window.location.href='/HiBookTLCN/booknew'">Xem thêm</button>
			</div>
		</div>
	</div>
	<!--
	========================SÁCHBÁN CHẠY NHẤT================
	-->
	<div class="container-fluid" id="courseshome">
		<div class="container khung" style="text-align: center;">
			<div class="gioithieu">

				<h2>
					<i style="width: fit-content;" class="fas fa-star"></i> SÁCH BÁN
					CHẠY NHẤT
				</h2>
				<p class="p_home">Những thể loại sách bán chạy nhất</p>
			</div>
			<div class="row container wow slideInUp" id="loadtrangchu"
				style="padding-top: 20px"></div>
			<div class="row container wow slideInUp" id="loadtrangchu1"
				style="padding-top: 20px"></div>
			<div class="text-center" style="margin-top: 10px;">
				<button class="btn btn-success btn_xemthem" onclick="window.location.href='/HiBookTLCN/bookssold'">Xem thêm</button>
			</div>

		</div>
	</div>
	<!--
	========================LOGO ĐỐI TÁC================
	-->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div id="Carousel_doitac" class="carousel slide">

					<!-- Carousel items -->
					<div class="carousel-inner">

						<div class="item active">
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo-tiki.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo (1).png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo_mobile.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo_nhanam.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/nxbkd.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/thaiha_logo.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/nxbtre.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel_doitac"
						class="left carousel-control carousel-control-doitac-left">‹</a> <a
						data-slide="next" href="#Carousel_doitac"
						class="right carousel-control carousel-control-doitac-right">›</a>
				</div>
				<!--.Carousel-->

			</div>
		</div>
	</div>
	<!--.container-->

	<!--  -->
	<!--
	==========================Footer================
	-->
	<!-- Footer -->
	<section id="footer">
		<div class="container">
			<div class="row text-xs-center text-sm-left text-md-left">
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>VỀ HiBook</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Giới thiệu HiBook</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Chính sách bảo mật</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Điều khoản dịch vụ</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>đánh giá</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Tuyển dụng</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>TRỢ GIÚP</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Hướng dẫn mua hàng</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Phương thức thanh toán</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Phương thức vận chuyển</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Câu hỏi thường gặp</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Chính sách đổi trả</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>TÀI KHOẢN</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Tài khoản</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Thông báo</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Đơn hàng</a></li>
						<li><a href="javascript:void();"><i
								class="fa fa-angle-double-right"></i>Giỏ hàng</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>LIÊN HỆ</h5>
					<ul class="list-unstyled quick-links">
						<li><a><i class="fa fa-map-marker"></i>Address : Số 1, Võ
								Văn Ngân, Thủ Đức, TP Hồ Chí Minh</a></li>
						<li><a><i class="fa fa-phone"></i>(+84)1869123456</a></li>
						<li><a href="#"><i class="fa fa-envelope"></i>hibook@gmail.com</a>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
						<ul class="list-unstyled list-inline social text-center">
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fab fa-facebook"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fab fa-twitter-square"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fab fa-instagram"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fab fa-google-plus-square"></i></a></li>
						</ul>
					</div>
					</hr>
				</div>
				<div class="row">
					<div
						class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
						<p class="h6">
							&copy 2018 All right Reversed <a class="text-green ml-2"
								href="https://www.HiBook.com" target="_blank">HiBook</a>
						</p>
					</div>
					</hr>
				</div>
			</div>
	</section>
	<!--nút quay về đầu trang-->
	<div class="btn-top">
		<a href="javascript:void(0);" title="Top" style="display: inline;">
			<i class="glyphicon glyphiconc glyphicon-chevron-up"></i>
		</a>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/myjsHome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/handlehome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/handle-detail.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>