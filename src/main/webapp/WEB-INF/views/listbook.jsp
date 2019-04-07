<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>List Search</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
	<!--Icon fa-->
	<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">

	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/mycssHome.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/list_search_css.css" />
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
	
	<div class="container" style="margin-top: 100px;margin-bottom: 50px;">
		<div class="row">
			<div class="col-sm-3">
				<div class="card" style="border: 1px solid #99ca8d; padding: 15px; border-radius: 5px;">
					<div class="card-header">
						<h5><strong>LỌC THEO</strong></h5><hr/>
					</div>
					<div class="card-body text-success">
					    <h5 class="card-title" style="color: black;"><strong>THỂ LOẠI</strong></h5>
					    <div class="bg">
							  
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<p style="font-size: 25px; padding: 4px;"><strong>DANH SÁCH TÌM KIẾM</strong></p>
				 <!-- <div class="form-group" style="width: 20%; text-align: right;display: -webkit-box;">
				      <select class="form-control">
				        <option>Sắp xếp</option>
				        <option>Bán chạy nhất</option>
				        <option>Giá bán</option>
				        <option>Mới nhất</option>
				      </select>
				      <select class="form-control" style="margin-left: 20px;">
				        <option>12 sản phẩm</option>
				        <option>24 sản phẩm</option>
				        <option>48 sản phẩm</option>
				      </select>
				  </div> -->
				<div id="list_search" class="row wow slideInUp" style="padding-top: 20px">
				
				</div>
				<div id="right_pagination">
					<ul class="pagination">
						
					</ul>
				</div>
			</div>
		</div>
	</div>
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
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Giới thiệu HiBook</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Chính sách bảo mật</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Điều khoản dịch vụ</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>đánh giá</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Tuyển dụng</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>TRỢ GIÚP</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Hướng dẫn mua hàng</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Phương thức thanh toán</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Phương thức vận chuyển</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Câu hỏi thường gặp</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Chính sách đổi trả</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>TÀI KHOẢN</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Tài khoản</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Thông báo</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Đơn hàng</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Giỏ hàng</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3">
					<h5>LIÊN HỆ</h5>
					<ul class="list-unstyled quick-links">
						<li>
							<a><i class="fa fa-map-marker"></i>Address : Số 1, Võ Văn Ngân, Thủ Đức, TP Hồ Chí Minh</a>
						</li>
						<li>
							<a><i class="fa fa-phone"></i>(+84)1869123456</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-envelope"></i>hibook@gmail.com</a>
						</li>
					</ul>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
					<ul class="list-unstyled list-inline social text-center">
						<li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-facebook"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-twitter-square"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-instagram"></i></a></li>
						<li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-google-plus-square"></i></a></li>
					</ul>
				</div>
				</hr>
			</div>	
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
					<p class="h6">&copy 2018 All right Reversed <a class="text-green ml-2" href="https://www.HiBook.com" target="_blank">HiBook</a></p>
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
	<script src="<%=request.getContextPath()%>/resources/js/user-custom/search.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>