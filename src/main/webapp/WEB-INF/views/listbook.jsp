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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/myhome.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/list_search_css.css" />
	<link href="https://fonts.googleapis.com/css?family=Open+Sans"
		rel="stylesheet">
</head>
<body>
	
	<%@ include file="_header.jsp" %>
	<!--
		==============================content===================================
	-->
	
	<div class="container" style="margin-top: 10px;margin-bottom: 50px;">
		<div class="row">
			<div class="col-sm-3">
				<div class="card" style="border: 1px solid #99ca8d; padding: 15px; border-radius: 5px;">
					<div class="card-header">
						<h5><strong>LỌC THEO</strong></h5><hr/>
					</div>
					<div class="card-body text-success">
					    <h5 class="card-title" style="color: black;"><strong>TÁC GIẢ</strong></h5>
					    <div class="bg">
					    	<c:forEach var="item" items="${search.lstAuthor}">
					    		<div class="chiller_cb"><a href="#"><label>&nbsp; ${item.nameAuthor} (${item.numBookSearch})</label></a></div>
					    	</c:forEach>
						</div>
					</div>
					<div class="card-body text-success">
					    <h5 class="card-title" style="color: black;"><strong>NHÀ CUNG CẤP</strong></h5>
					    <div class="bg">
					    	<c:forEach var="item" items="${search.lstSupplier}">
					    		<div class="chiller_cb"><a href="#"><label>&nbsp; ${item.nameSupplier} (${item.numBookSearch})</label></a></div>
					    	</c:forEach>
						</div>
					</div>
					<div class="card-body text-success">
					    <h5 class="card-title" style="color: black;"><strong>NHÀ XUẤT BẢN</strong></h5>
					    <div class="bg">
					    	<c:forEach var="item" items="${search.lstPublisher}">
					    		<div class="chiller_cb"><a href="#"><label>&nbsp; ${item.namePublisher} (${item.numBookSearch})</label></a></div>
					    	</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<p style="font-size: 25px; padding: 4px;"><strong>DANH SÁCH TÌM KIẾM</strong></p>
				 <div class="form-group" style="width: 20%; text-align: right;display: -webkit-box;">
				      <select class="form-control">
				        <option>Sắp xếp</option>
				        <option>Bán chạy nhất</option>
				        <option>Giá bán</option>
				        <option>Mới nhất</option>
				      </select>
				      <select class="form-control" style="margin-left: 20px;">
				        <option>6 sản phẩm</option>
				        <option>12 sản phẩm</option>
				        <option>24 sản phẩm</option>
				      </select>
				  </div>
				<div id="list_search" class="row wow slideInUp" style="padding-top: 20px">
					<c:forEach var="item" items="${search.currentBooks}">
						<div class="col-sm-6 col-md-4 " style="margin-bottom: 20px;">
							<div class="sanpham">
								<div class="thumbnail entry">
									<a href="/HiBook_KLTN19/detail-book/${item.idBook}" class="non-textdecoration" target="_blank">
									<div id="hinh" class="img_center">
										<img src="/HiBook_KLTN19/resources/images/book/${item.picBook}" alt="Nature">
									</div>
									</a>
								</div>
								<div class="h">
									<span id="NameSP">${item.nameBook}</span><br />
									<span style="color: #8a8787; padding: 10px; font-size: 14px;">
										<c:forEach var="author" items="${item.authors}">
											${author.nameAuthor} 
										</c:forEach>
									</span><br/> 
									<span style="color: black; padding: 10px; font-size: 14px;">${Math.round(item.price*(1-item.discount/100))}đ</span>
									<span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>${item.price}đ</del></span>
									<span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">-${item.discount}%</span><br />
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				
				<div id="right_pagination">
					<ul class="pagination">
						<c:if test="${search.currentpage==1}">
							<li class='disabled'><a href="#">«</a></li>
						</c:if>
						<c:if test="${search.currentpage!=1}">
							<li><a href=<c:out value="${requestScope['javax.servlet.forward.request_uri']}?page=${search.currentpage-1}"/> >«</a></li>
						</c:if>
						<c:forEach var = "i" begin = "1" end = "${search.totalpage}">
							<c:if test="${search.currentpage == i}">
								<li class="active"><a data-page="${i}" href=<c:out value="${requestScope['javax.servlet.forward.request_uri']}?page=${i}"/>>${i} <span class="sr-only">(current)</span></a></li>
							</c:if>
							<c:if test="${search.currentpage != i}">
								<li><a data-page="${i}" href=<c:out value="${requestScope['javax.servlet.forward.request_uri']}?page=${i}"/> >${i} <span class="sr-only">(current)</span></a></li>
							</c:if>
					    </c:forEach>
					    <c:if test="${search.currentpage == search.totalpage}">
							<li class='disabled'><a href="#">»</a></li>
						</c:if>
						<c:if test="${search.currentpage != search.totalpage}">
							<li><a href=<c:out value="${requestScope['javax.servlet.forward.request_uri']}?page=${search.currentpage+1}"/>>»</a></li>
						</c:if>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--  -->
	<%@ include file="_footer.jsp" %>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>