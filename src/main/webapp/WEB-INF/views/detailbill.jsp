<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/datatables.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fullcalendar.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootadmin.min.css">

<title>Detail Bill | HiBookAdmin</title>
<style type="text/css">
.top-alert {
	position: fixed;
	top: 80px;
	width: 100%;
	z-index: 100000;
	left: 0;
	padding: 20px;
	display: inline-block;
	text-align: center;
}

.top-alert .alert {
	width: auto !important;
	height: 100%;
	display: inline;
	position: relative;
	margin: 0;
}

.top-alert .alert .close {
	position: absolute;
	top: 11px;
	right: 10px;
	color: inherit;
}
</style>
</head>
<body class="bg-light">
	<div class="container">
		<h2 class="mb-4">HÓA ĐƠN</h2>

		<div class="card">
			<div class="card-body">
				<div class="row py-5">
					<div class="col-md-10 offset-md-1">
						<div class="row">
							<div class="col-md">
								<h1 class="text-uppercase">Hóa Đơn</h1>

								<p id="idBill" class="mb-0"></p>
							</div>
							<div class="col-md text-md-right">
								<img style="width: 220px;"
									src="<%=request.getContextPath()%>/resources/images/TC.png">
								<p class="mt-2 mb-0">
									hibook@gmail.com<br> (+84)1869123456<br> Số 1, Võ Văn
									Ngân, Thủ Đức, TP Hồ Chí Minh
								</p>
							</div>
						</div>

						<hr class="my-5">

						<div class="row">
							<div class="col-md ">
								<h5 class="text-uppercase">Người nhận</h5>
								<p id="nameReceiver" class="mb-0" data-id="${idUser }">${namereviece}</p>
							</div>
							<div class="col-md">
								<h5 class="text-uppercase">SĐT</h5>
								<p id="numberphone">${SDT}</p>
							</div>
							<div class="col-md">
								<h5 class="text-uppercase">Ngày tạo</h5>
								<p id="dateCreate" class="mb-0">${date}</p>
							</div>
							<div class="col-md text-md-right">
								<h5 class="text-uppercase">Địa chỉ nhận</h5>
								<p id="deliveryAdress" class="mb-0">${diachi}</p>
							</div>
						</div>

						<hr class="my-5">

						<table class="table table-borderless mb-0">
							<thead>
								<tr class="border-bottom text-uppercase">
									<th scope="col">Tên sách</th>
									<th scope="col">số lượng</th>
									<th scope="col">Giá</th>
									<th scope="col">Tổng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="value" items="${listcart}">
									<tr>
										<td class="tensp">${value.getNameBook()}</td>
										<td class="soluong" data-num="${value.getQuantity()}">${value.getQuantity()}</td>
										<td class="giasp" data-many="${value.getPrice()}">${value.getPrice()}</td>
										<td class="tongtien"></td>
									</tr>
								</c:forEach>
								
							</tbody>
							
						</table>
						<hr class="my-5">
						<h3 style="text-align: right;">
							<span>Tổng Tiền:</span> <span id="tongtienbill"
								style="color: red;">0 VND</span>
						</h3>
						<hr class="my-5">
						<div class="row">
							<div class="col-md ">
								<h5 class="text-uppercase">Phương thức thanh toán</h5>
								<p id="payment" class="mb-0" data-id="${thanhtoan.idPayment }">${thanhtoan.namePayment }</p>
							</div>

							<div class="col-md text-md-right">
								<h5 class="text-uppercase">Phương thức vận chuyển</h5>
								<p id="transport" class="mb-0"
									data-id="${vanchuyen.idTransport }">${vanchuyen.nameTransport}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: right; margin-top: 10px;">
			<button class="btn btn-success dathang" style="margin-bottom: 20px">Xác nhận đặt Hàng >></button>
		</div>
		<div class="thongbao top-alert"></div>
		<!-- MODAL -->
		<div class="modal fade" id="modalChange" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<h5 class="modal-title">Bạn có chắc muốn đặt đơn hàng này?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy
							bỏ</button>
						<button id="dat-hang" class="btn btn-success">Đặt hàng</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/datatables.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/fullcalendar.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hoadon.js"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-118868344-1');
	</script>

	<!-- CUSTOM JS AJAX  -->
	<!-- <script src="<%=request.getContextPath()%>/resources/js/user-custom/getListtypebook.js"></script> -->

</body>
</html>