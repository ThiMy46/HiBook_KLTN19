<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thông tin</title>
<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">

<!-- Include the above in your HEAD tag -->
<link href="<%=request.getContextPath()%>/resources/css/detail_css.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/mycssHome.css" />
<!-- fa icon -->
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
			==============================Login mờ màn hình====================================
	-->

	<div id="idLogin" class="modal">
		<form class="modal-content animate" action="../j_spring_security_login"
			method="post">
			<div class="imgcontainer">
				<span id="btnClose" class="close" title="Close Modal">&times;</span>
				<img src="<%=request.getContextPath()%>/resources/images/TC.png" alt="Avatar" class="avatar">
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
				<img src="<%=request.getContextPath()%>/resources/images/TC.png" alt="Avatar" class="avatar">
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
	<!-- ================CONTENT=============  -->
	<div class="container" style="margin-top: 100px;">
		<div class="row">
			<div class="col-xs-12 col-sm-6 item-photo">
				<div id="TryRead">
					<a href="#" data-toggle="modal" data-value=''
						data-target="#modalTryRead" style="color: #21b334;">>> ĐỌC THỬ</a>
				</div>
				<!--  <img style="max-width:100%;" src="resources/images/info_user/detail.jpg" /> -->
			</div>

			<div class="col-xs-12 col-sm-6" style="border: 0px solid gray">

				<!-- Datos del vendedor y titulo del producto -->
				<h3 id="tensach" data-type=""></h3>
				<h5 style="color: #000">
					Tác giả: <a id="tacgia" href="#"></a>
				</h5>

				<!-- Review -->
				<div class="rating">
					<div class="stars">
						<span class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span class="fa fa-star"></span>
						<span class="fa fa-star"></span> <a href="#"><small
							style="color: #337ab7">(5 đánh giá)</small></a>
					</div>
				</div>
				<hr />
				<!-- Precios -->
				<h3 id="giaban" style="margin-top: 30px;">đ</h3>
				<h6 class="title-price">
					<small>Tiết kiệm: <span id="giamgia" style="color: red;">%<span></small>
				</h6>
				<h6 id="giagoc" class="title-price">
					<small></small>
				</h6>
				<hr />
				<!-- Detalles especificos del producto -->

				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>SỐ LƯỢNG</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input id="get-quantity" value="1" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
				</div>

				<!-- Botones de compra -->
				<div class="section" style="padding-bottom: 20px;">
					<button class="btn btn-success" id="btn-purchase"
						style="width: 200px; border-radius: 5px;">
						<span class="glyphicon glyphicon-shopping-cart get-email"
							aria-hidden="true" data-email="${email }"> </span>Chọn mua
					</button>
				</div>
			</div>

			<div class="col-xs-12 col-sm-12">
				<div class="tabbable-panel">
					<div class="tabbable-line">
						<ul class="nav nav-tabs ">
							<li class="active"><a href="#tab_default_1"
								data-toggle="tab"> GIỚI THIỆU SÁCH </a></li>
							<li><a href="#tab_default_2" data-toggle="tab"> THÔNG
									TIN CHI TIẾT </a></li>
							<li><a href="#tab_default_3" data-toggle="tab"> KHÁCH
									HÀNG NHẬN XÉT </a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tab_default_1"></div>
							<div class="tab-pane" id="tab_default_2">

								<table id="table_chitiet" class="table table-bordered">

								</table>

							</div>
							<div class="tab-pane" id="tab_default_3">
								<!--Thống kê Review-->
								<div class="row text-center">
									<div class="col-xs-6 col-md-4">
										<div class="rating-block">
											<h4>Đánh giá trung bình</h4>
											<h2 class="bold padding-bottom-7">
												<p id="start_tb">0</p>
												<small>/ 5</small>
											</h2>
										</div>
									</div>
									<div class="col-xs-6 col-md-4">
										<h4>Thống kê</h4>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													5 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="4" aria-valuemin="0"
														aria-valuemax="5" style="width: 100%"></div>
												</div>
											</div>
											<div class="pull-right" style="margin-left: 10px;">2</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													4 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="4" aria-valuemin="0"
														aria-valuemax="5" style="width: 80%"></div>
												</div>
											</div>
											<div class="pull-right" style="margin-left: 10px;">1</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													3 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													2 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													1 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div class="pull-right" style="margin-left: 10px;">0</div>
										</div>
									</div>
									<!--WRITE REVIEW-->
									<div class="col-xs-6 col-md-4">
										<h4>Chia sẽ nhận xét của bạn</h4>
										<div class="well well-sm">
											<div class="text-right">
												<a class="btn btn-success btn-green" href="#reviews-anchor"
													id="open-review-box">Viết nhận xét của bạn</a>
											</div>

											<div class="row" id="post-review-box" style="display: none;">
												<div class="col-md-12">
													<form accept-charset="UTF-8" action="" method="post">
														<input id="ratings-hidden" name="rating" type="hidden">
														<input class="form-control" id="title_review_write"
															name="title_write" type="text"
															style="margin-bottom: 10px;"
															placeholder="Tiêu đề nhận xét...">
														<textarea class="form-control animated" cols="50"
															id="new-review" name="comment"
															placeholder="Viết nội dung nhận xét tại đây..." rows="5"></textarea>

														<div class="text-right">
															<div class="star starrr"
																style="margin: 20px 0; font-size: 24px; color: #fd8402;"
																data-rating="0"></div>
															<a class="btn btn-danger btn-sm" href="#"
																id="close-review-box"
																style="display: none; margin-right: 10px; margin-bottom: 5px;">
																<span class="glyphicon glyphicon-remove"></span> Cancel
															</a>
															<button class="btn btn-success btn-lg" type="submit">Save</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--END Thống kê Review-->
								<p style="font-weight: bold;">Nhận xét của khách hàng</p>
								<!--Review Box Customer 1-->
								<div class="reviews">
									<div class="row blockquote review-item">
										<div id="mucreview"></div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- The Modal Doc Thu-->
	<div class="modal fade" id="modalTryRead" data-backdrop="false"
		role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content" style="width: 100%;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">ĐỌC THỬ</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="mydiv">
						<iframe id="frame" src="" width="100%" height="400"> </iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--CÁC SẢN PHẨM LIÊN QUAN-->
	<div class="container">
		<div class="row">
			<h3>Các sản phẩm cùng loại</h3>
			<div class="col-sm-12">
				<div id="Carousel" class="carousel slide">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="item active">
							<div class="row" id="sp_type1"></div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row" id="sp_type2"></div>
							<!--.row-->
						</div>
						<!--.item-->


					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a>
					<a data-slide="next" href="#Carousel"
						class="right carousel-control">›</a>
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
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/detail_js.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/myjsHome.js"></script>
	<!-- api -->
	<script
		src="<%=request.getContextPath()%>/resources/js/handle-detail.js"></script>
</body>
</html>
