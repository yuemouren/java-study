<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			type:'GET',
			url:'category/getCategory',
			dataType:'json',
			success:function(data){
				$(data).each(function(index,item){
					var li = "<li><a href='product/getProByCid?cid="+item.cid+"'>"+item.cname+"</a></li>";
					$("#categoryUl").append(li);
				});
			}
		});
	});
</script>
</head>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5"></div>
	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">

			<c:if test="${empty sessionScope.activeuser}">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
	
			<c:if test="${ !empty sessionScope.activeuser}">
				<li style="color: red">欢迎您${sessionScope.activeuser.username}</li>
				<li><a href="${pageContext.request.contextPath}/user/logout">退出</a></li>
			</c:if>
		
			<li><a href="cart/getCart">购物车</a></li>
			<li><a href="orders/getOrders">我的订单</a></li>
			
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<!-- 导航条 显示的内容 -->
				<ul class="nav navbar-nav" id="categoryUl">
					<!-- <li><a href="product_list.jsp">手机数码</a></li> -->
					
				</ul>

				<form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/product/likeSerach"
					method="post" role="search">
					<input type="hidden" name="method" value="likeSearch">
					<div class="form-group">
						<input type="text" name="searchinfo" class="form-control"
							placeholder="Search">
					</div>
					<input type="submit" class="btn btn-default" value="搜索">
				</form>
			</div>
		</div>

	</nav>
</div>

</html>