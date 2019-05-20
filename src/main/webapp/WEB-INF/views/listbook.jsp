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
	<%@ include file="_footer.jsp" %>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>