<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--bootstrap & Jquery-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
<!--Icon fa-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">

<!--CSS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/mycssHome.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/animate.css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/stylecart.css" />

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

	<!--

	================================NỘI DUNG=======================
  -->

	<div class="container" style="margin-top: 106px;">
		<div class="col-md-12">
			<h4 class="lbl-shopping-cart lbl-shopping-cart-gio-hang" style="margin: 23px;
    /* margin-top: 45px; */
    margin-bottom: -5px;
    margin-top: 38px;">
				Giỏ hàng <span>(${listquantitycart} sản phẩm)</span>
			</h4>
		</div>
		<div class="col-md-12">
			<div class="col-md-8" id="shopping-cart">
			

				<table id="cart" class="table table-hover table-condensed">
					<thead>
						<tr>
							<th style="width: 50%">Tên sản phẩm</th>
							<th style="width: 10%">Giá</th>
							<th style="width: 8%">Số lượng</th>
							<th style="width: 22%" class="text-center">Thành tiền</th>
							<th style="width: 10%"></th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="list" items="${listcart}">
						<tr >
							<td data-th="Product">
								<div class="row">
									<div class="col-md-8 hidden-xs" >
										<img id="getIdCart" data-idCart="${list.getIdCart()}"
											src="<%=request.getContextPath() %>/resources/images/book/${list.getImgBook()}"
											alt="Sản phẩm 1" class="img-responsive" width="100">
											<h4 class="nomargin" style="color: red;">${list.getNameBook()}</h4>
									</div>
									
								</div>
							</td>
							<td class="giatien" data-price="${list.getPrice()}">${list.getPrice()}&nbsp;₫</td>
							<td  class="soluong" data-num="${list.getQuantity()}" style="padding: 2px;"><input
								class="form-control text-center soluong_giohang" value="${list.getQuantity()}" type="number" min="1" >
							</td>
							<td class="totalmoney" data-th="Subtotal" class="text-center"></td>
							<td class="actions" data-th="">
								<button class="btn btn-danger btn-sm deletecart" >
									<i class="fa fa-trash"></i>
								</button>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
					
					<tfoot>
						
						<tr>
							<td><a href="<%=request.getContextPath()%>/"
								class="btn btn-warning"><i class="fa fa-angle-left"></i>
									Tiếp tục mua hàng</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center" id="totalall"><strong>Tổng tiền:</strong></td>
							
						</tr>
					</tfoot>
				</table>

			</div>

			<div class="col-md-4 col-sm-12" style="margin-top: -27px;">
				<h3>Thông Tin Đặt Hàng</h3>
				 <form action="<%=request.getContextPath()%>/getbill/${getIdUser}" method="POST">
				 	
					<div class="form-group">
						<label for="usr">Name:</label> <input type="text"
							class="form-control" id="usr" name="tenKhachHang" value="${use.getNameUser()}">
					</div>
					<div class="form-group">
						<label for="pwd">Number Phone:</label> 
						<input type="number" class="form-control" id="pwd" name="soDT" value="${use.getNumberphone()}">
					</div>
					<div class="form-group">
						<label for="pay">Phương Thức Thanh Toán:</label>
						<c:forEach var="vaulue" items="${listpay}">
							<div class="radio">
								<label><input type="radio" name="noigiaohang" checked="checked" value="${vaulue.getIdPayment()}" >${vaulue.getNamePayment()}</label>
							</div>
						</c:forEach>
					</div>


					<div class="form-group">
						<label for="adr">Adress:</label> <input type="text"
							class="form-control" id="adr" name="diaChiGiao" value="${use.getAddress()}">
					</div>
					<div class="form-group">
						<label for="pay">Phương Thức Vận Chuyển:</label>
						<c:forEach var="vaulue1" items="${listtran}">
							<div class="radio">
								<label><input type="radio" name="vanchuyen" checked="checked" value="${vaulue1.getIdTransport()} " >${vaulue1.getNameTransport()}</label>
							</div>
						</c:forEach>
					</div>
					<div>		
						<input type="submit" value="Đặt Hàng" class="btn btn-danger dathang" 
							style="margin-bottom: 11px"/>
				
					</div>
				</form>	
				
			</div>

		</div>
	</div>
	<!--
	===========================giới thiệu====================
  -->

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
	<script src="../resources/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../resources/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/myjsHome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/cart.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>