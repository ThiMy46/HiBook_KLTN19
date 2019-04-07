<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Xác định bộ mã ký tự cho văn bản HTML. -->
<meta charset="UTF-8">
<!-- ĐỊnh dạng tiêu đề HTML -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Giúp trang web dễ nhìn trên tất cả các thiết bị -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">
<!-- CSS -->
<link href="<%=request.getContextPath()%>/resources/css/info_css.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mycssHome.css" />

<title>Thông tin các nhân User</title>
<!--Icon fa-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
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
		==============================content===================================
	-->
	<div class="container" style="margin-top: 100px;">
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${info.getNameUser()}</div>
						<div class="profile-usertitle-job">
							${info.getEmail()}</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active"><a href="/HiBookTLCN/info_user/${info.getIdUser()}"> <span
									class="glyphicon glyphicon-user"></span> Thông tin
							</a></li>
							<li><a href="/HiBookTLCN/user_update/${info.getIdUser() }"> <span
									class="glyphicon glyphicon-pencil"></span> Quản lý thông tin
							</a></li>
							<li ><a href="/HiBookTLCN/user_bill/${info.getIdUser()}" > <span
									class="glyphicon glyphicon-list-alt"></span> Quản lý hóa đơn
							</a></li>
							<li><a href="<%=request.getContextPath()%>/logout"> <span
									class="glyphicon glyphicon-log-out"></span> Đăng xuất
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<div class="container">
						<div class="row">

							<div class="col-md-8 ">

									<div class="row">
										<h4 class="mb-4">Thông tin cá nhân</h4>
									</div>
									<div class="row">

										<div class="box box-info">
											<div class="col-sm-6">
								            <h4 style="color:#4ad048;">${info.getRole().getNameRole() } </h4>
								            </div>
								            <div class="clearfix"></div>
								            <hr style="margin:5px 0 5px 0;">

											<div class="col-sm-4 col-xs-6 tital ">Tên:</div>
											<div class="col-sm-8 col-xs-6 ">${info.getNameUser()}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>

											<div class="col-sm-4 col-xs-6 tital ">Ngày sinh:</div>
											<div class="col-sm-8">${info.getBirthday()}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>

											<div class="col-sm-4 col-xs-6 tital ">Số điện thoại:</div>
											<div class="col-sm-8">${info.getNumberphone()}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>

											<div class="col-sm-4 col-xs-6 tital ">Email:</div>
											<div class="col-sm-8">${info.getEmail()}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>
											
											<div class="col-sm-4 col-xs-6 tital ">Giới tính:</div>
											<div class="col-sm-8">${info.getSex()==1?"Nữ":"Nam"}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>
																						
											<div class="col-sm-4 col-xs-6 tital ">Địa chỉ:</div>
											<div class="col-sm-8">${info.getAddress()}</div>
											<div class="clearfix"></div>
											<div class="bot-border"></div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- =================END CONTENT===========================
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
	<!-- ./Footer -->

	<!--nút quay về đầu trang-->
	<div class="btn-top">
		<a href="javascript:void(0);" title="Top" style="display: inline;">
			<i class="glyphicon glyphiconc glyphicon-chevron-up"></i>
		</a>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/myjsHome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>
	<script>
              $(function() {
			    $('#profile-image1').on('click', function() {
			        $('#profile-image-upload').click();
			    });
			});       
              </script>
</body>
</html>